package br.com.fiap.techchallange.domain.entity;

import br.com.fiap.techchallange.domain.enums.GatewayPayment;
import br.com.fiap.techchallange.domain.enums.MethodPayment;
import br.com.fiap.techchallange.domain.enums.StatusPayment;
import br.com.fiap.techchallange.domain.vo.MonetaryValue;
import br.com.fiap.techchallange.domain.vo.ProcessingCodePayment;
import br.com.fiap.techchallange.domain.vo.ReadingCodePayment;


import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

public class Payment {
    private final String id;
    private final String idOrder;
    private MonetaryValue monetaryValue;
    private MethodPayment method;
    private LocalDateTime dateTime;
    private final GatewayPayment gatewayPayment;
    private StatusPayment status;
    private ReadingCodePayment readingCode;
    private ProcessingCodePayment processingCode;

    public Payment(String id) {
        this.idOrder = id;
        this.id = UUID.randomUUID().toString();
        this.setMonetaryValue(0.0f);
        this.gatewayPayment =  GatewayPayment.MERCADOPAGO;
        this.setMethod(MethodPayment.QRCODE.getValue());
        this.status = StatusPayment.OPEN;
        readingCode = new ReadingCodePayment("");
        processingCode = new ProcessingCodePayment("");
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
            this.dateTime = LocalDateTime.now();
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

    public String getDateTime() {
        return dateTime.toString();
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