package br.com.fiap.techchallange.core.entity;

import br.com.fiap.techchallange.core.entity.enums.GatewayPayment;
import br.com.fiap.techchallange.core.entity.enums.MethodPayment;
import br.com.fiap.techchallange.core.entity.enums.StatusPayment;
import br.com.fiap.techchallange.core.entity.vo.MonetaryValue;
import br.com.fiap.techchallange.core.entity.vo.ProcessingCodePayment;
import br.com.fiap.techchallange.core.entity.vo.ReadingCodePayment;


import java.io.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.UUID;


public class Payment implements Serializable {
    private final String id;
    private final String idOrder;
    private MonetaryValue monetaryValue;
    private MethodPayment method;
    private LocalDateTime datePayment;
    private final GatewayPayment gatewayPayment;
    private StatusPayment status;
    private ReadingCodePayment readingCode;
    private ProcessingCodePayment processingCode;

    private static final LocalDateTime DEFAULT_DATE_TIME = LocalDateTime.of(1970, 1, 1, 23, 59, 59);

    public Payment(String id) {
        this.idOrder = id;
        this.id = UUID.randomUUID().toString();
        this.setMonetaryValue(0.0f);
        this.datePayment = DEFAULT_DATE_TIME;
        this.gatewayPayment =  GatewayPayment.MERCADOPAGO;
        this.setMethod(MethodPayment.QRCODE.getValue());
        this.status = StatusPayment.OPEN;
        readingCode = new ReadingCodePayment("");
        processingCode = new ProcessingCodePayment("");
    }

    public Payment(String id,
                   String idOrder,
                   float value,
                   String gateway,
                   String datePayment,
                   String method,
                   String status,
                   String readingCode,
                   String processingCode){

        this.idOrder = idOrder;
        this.id = id;
        this.setMonetaryValue(value);
        this.gatewayPayment =  GatewayPayment.fromValue(gateway);
        this.datePayment = parseDateTime(datePayment);
        this.setMethod(method);
        this.status = StatusPayment.fromValue(status);
        this.readingCode = new ReadingCodePayment(readingCode);
        this.processingCode = new ProcessingCodePayment(processingCode);
    }

    // public state-changing methods

    public void addReadingCode(String readingCode){
        if (status.equals(StatusPayment.OPEN)){
            this.readingCode = new ReadingCodePayment(readingCode);
            this.setStatusPayment(StatusPayment.PROCESSING);
        }
        else{
            throw new IllegalArgumentException(
                    "Reading Code cannot be add, status payment different of OPEN."
            );
        }
    }

    public void addProcessingCode(String processingCode, StatusPayment statusPayment){
        if (status.equals(StatusPayment.PROCESSING) && this.readingCode != null){
            this.processingCode = new ProcessingCodePayment(processingCode);
            this.setStatusPayment(statusPayment);
        }
        else{
            throw new IllegalArgumentException(
                    "Payment cannot be processed, status payment different of PROCESSING or Reading Code is empty."
            );
        }
    }

    // Private methods

    private static LocalDateTime parseDateTime(String dateTimeString){
        String dateTimeFormat = "yyyy-MM-dd'T'HH:mm:ss";
        LocalDateTime localDateTime = null;
        try {
            if (dateTimeString == null || dateTimeString.trim().isEmpty()) {
                localDateTime = DEFAULT_DATE_TIME;
            }else{
                localDateTime = stringToLocalDateTime(dateTimeString, dateTimeFormat);
            }
        } catch (DateTimeParseException e) {
            System.err.println("Invalid date time format: " + e.getMessage() + " must be in format: " + dateTimeFormat);
        }
        return localDateTime;
    }

    private static LocalDateTime stringToLocalDateTime(String dateTimeString, String dateTimeFormat) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(dateTimeFormat);
        return LocalDateTime.parse(dateTimeString, formatter);
    }
    private void setStatusPayment(StatusPayment statusPayment) {
        switch (this.status) {
            case OPEN:
                if (statusPayment.equals(StatusPayment.PROCESSING)) {
                    this.status = statusPayment;
                } else {
                    throw new IllegalArgumentException(
                            "Status can only be changed from 'OPEN' to 'PROCESSING'"
                    );
                }
                break;
            case PROCESSING:
                if (statusPayment.equals(StatusPayment.PAID) || statusPayment.equals(StatusPayment.PAYMENT_DENIED)) {
                    this.status = statusPayment;
                } else {
                    throw new IllegalArgumentException(
                            "Status can only be changed from 'PROCESSING' to 'PAID' or 'PAYMENT_DENIED'"
                    );
                }
                break;
            case PAID:
                throw new IllegalArgumentException(
                        "Status cannot be changed, payment already made."
                );
            case PAYMENT_DENIED:
                throw new IllegalArgumentException(
                        "Status cannot be changed, payment denied."
                );
        }
    }

    private void setMethod(String method){

        if(method == null){
            throw new IllegalArgumentException(
                    "Gateway of Payment cannot be empty."
            );
        }

        this.method = MethodPayment.QRCODE;
    }

    private void setMonetaryValue(float monetaryValue){
       this.monetaryValue = new MonetaryValue(new BigDecimal(monetaryValue));
    }

    // public getters

    public String getId() {
        return id;
    }

    public String getStatus() {
        return status.getValue();
    }

    public float getMonetaryValue() {
        return monetaryValue.getValue();
    }

    public String getCurrenty() {
        return monetaryValue.getCurrency();
    }

    public String getMethod() {
        return method.getValue();
    }

    public String getPaymentDate() {

        if(datePayment == null){
            return "";
        }else{
            return datePayment.format(DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss"));
        }
    }

    public String getGatewayPayment() {
        return gatewayPayment.getValue();
    }

    public String getReadingCode() {
        return readingCode.getCode();
    }

    public String getProcessingCode() {
        return processingCode.getCode();
    }

    public String getIdOrder() {
        return idOrder;
    }
}