package br.com.fiap.techchallange.core.usecase.tracking;

public record EventOrder(int number_order, String process) {

    public enum TypeEventOrder {
        PAYMENT("Payment"), PREPARATIONFOOD("preparationFood"), FOODDONE("foodDone"), DELIVERYFOOD("deliveryFood");

        private final String value;

        TypeEventOrder(String typeEventOrder) {
            value = typeEventOrder;
        }

        public String getValue() {
            return value;
        }

        public static TypeEventOrder fromValue(String value) {
            for (TypeEventOrder type : TypeEventOrder.values()) {
                if (type.getValue().equals(value)) {
                    return type;
                }
            }
            throw new IllegalArgumentException("Valor inválido: " + value);
        }
    }
}


