package br.com.fiap.techchallange.domain.entity;

import br.com.fiap.techchallange.domain.enums.GatewayPayment;
import br.com.fiap.techchallange.domain.enums.MethodPayment;
import br.com.fiap.techchallange.domain.enums.StatusPayment;
import br.com.fiap.techchallange.domain.vo.MonetaryValue;
import br.com.fiap.techchallange.domain.vo.ProcessingCodePayment;
import br.com.fiap.techchallange.domain.vo.ReadingCodePayment;


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
        this.datePayment = getPaymentDate(datePayment);
        this.setMethod(method);
        this.status = StatusPayment.fromValue(status);
        this.readingCode = new ReadingCodePayment(readingCode);
        this.processingCode = new ProcessingCodePayment(processingCode);
    }

    private LocalDateTime getPaymentDate(String dateTimeString){
        String dateTimeFormat = "yyyy-MM-dd'T'HH:mm:ss";
        LocalDateTime localDateTime = null;
        try {
            if (dateTimeString == null || dateTimeString.trim().isEmpty()) {
                localDateTime = DEFAULT_DATE_TIME;
            }else{
                localDateTime = stringToLocalDateTime(dateTimeString, dateTimeFormat);
            }
        } catch (DateTimeParseException e) {
            System.err.println("Invalid date time format: " + e.getMessage());
        }
        return localDateTime;
    }

    private static LocalDateTime stringToLocalDateTime(String dateTimeString, String dateTimeFormat) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(dateTimeFormat);
        return LocalDateTime.parse(dateTimeString, formatter);
    }

    public void addReadingCode(String readingCode){
        if (status.equals(StatusPayment.OPEN)){
            this.readingCode = new ReadingCodePayment(readingCode);
        }
        else{
            throw new IllegalArgumentException(
                    "Reading Code cannot be add, status payment different of Open."
            );
        }
    }

    public void addProcessingCode(String processingCode){
        if (status.equals(StatusPayment.OPEN) && this.readingCode != null){
            this.processingCode = new ProcessingCodePayment(processingCode);
            this.status = StatusPayment.PAID;
            this.datePayment = LocalDateTime.now();
        }
        else{
            throw new IllegalArgumentException(
                    "Processing Code cannot be add, data of payment incosistent."
            );
        }
    }

    public void alterValue(float valueMonetary){
        if(!status.equals(StatusPayment.OPEN))
            this.setMonetaryValue(valueMonetary);
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
            return datePayment.toString();
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