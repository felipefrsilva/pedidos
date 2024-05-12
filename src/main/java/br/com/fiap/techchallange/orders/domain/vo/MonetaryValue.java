package br.com.fiap.techchallange.orders.domain.vo;

import java.math.BigDecimal;

public class MonetaryValue {
    private BigDecimal value;
    private String currency;

    public MonetaryValue(BigDecimal value, String currency) {
        this.setValue(value);
        this.setCurrency(currency);
    }

    public MonetaryValue(BigDecimal amount) {
        this.setValue(amount);
        this.setCurrency("Real");
    }

    public float getValue() {
        return value.floatValue();
    }

    private void setValue(BigDecimal amount) {
        if(amount.floatValue() < 0){
            throw new IllegalArgumentException(
                    "amount of MonetaryValue cannot be less than to zero"
            );
        }
        this.value = amount;
    }

    public String getCurrency() {
        return currency;
    }

    private void setCurrency(String currency) {
        this.currency = currency;
    }
}
