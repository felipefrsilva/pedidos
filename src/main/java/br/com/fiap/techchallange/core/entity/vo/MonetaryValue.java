package br.com.fiap.techchallange.core.entity.vo;

import java.io.Serializable;
import java.math.BigDecimal;

public class MonetaryValue implements Serializable {
    private BigDecimal value;
    private String currency;

    public MonetaryValue(BigDecimal amount) {
        this.setValue(amount);
        this.setCurrency("BRL");
    }

    public MonetaryValue(BigDecimal amount, String currency) {
        this.setValue(amount);
        this.setCurrency(currency);
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
