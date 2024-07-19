package br.com.fiap.techchallange.core.usecase.dto.orderpayment;

import br.com.fiap.techchallange.core.entity.Payment;

public class OutputDataPaymentDTO {
    private String id;
    private String orderId;
    private float monetaryValue;
    private String method;
    private String datePayment;
    private String gatewayPayment;
    private String status;
    private String processingCode;
    private String readingCode;

    public OutputDataPaymentDTO(Payment payment) {
        this.setId(payment.getId());
        this.setOrderId(payment.getIdOrder());
        this.setMonetaryValue(payment.getMonetaryValue());
        this.setMethod(payment.getMethod());
        this.setDatePayment(payment.getPaymentDate());
        this.setGatewayPayment(payment.getGatewayPayment());
        this.setStatus(payment.getStatus());
        this.setProcessingCode(payment.getProcessingCode());
        this.setReadingCode(payment.getReadingCode());
    }

    public OutputDataPaymentDTO(
            String id,
            String orderId,
            float monetaryValue,
            String method,
            String datePayment,
            String gatewayPayment,
            String status,
            String processingCode,
            String readingCode
    ) {
        this.setId(id);
        this.setOrderId(orderId);
        this.setMonetaryValue(monetaryValue);
        this.setMethod(method);
        this.setDatePayment(datePayment);
        this.setGatewayPayment(gatewayPayment);
        this.setStatus(status);
        this.setProcessingCode(processingCode);
        this.setReadingCode(readingCode);
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getReadingCode() {
        return readingCode;
    }

    public void setReadingCode(String readingCode) {
        this.readingCode = readingCode;
    }

    public float getMonetaryValue() {
        return monetaryValue;
    }

    public void setMonetaryValue(float monetaryValue) {
        this.monetaryValue = monetaryValue;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getDatePayment() {
        return datePayment;
    }

    public void setDatePayment(String datePayment) {
        this.datePayment = datePayment;
    }

    public String getGatewayPayment() {
        return gatewayPayment;
    }

    public void setGatewayPayment(String gatewayPayment) {
        this.gatewayPayment = gatewayPayment;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getProcessingCode() {
        return processingCode;
    }

    public void setProcessingCode(String processingCode) {
        this.processingCode = processingCode;
    }
}
