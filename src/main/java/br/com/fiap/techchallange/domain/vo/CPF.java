package br.com.fiap.techchallange.domain.vo;

public class CPF {
    private String cpfValue;

    public CPF(String cpfValue) {
        this.validaCPF(cpfValue);
    }

    public void validaCPF(String cpfValue) {
        if (cpfValue != null) {
            if (cpfValue.equals("00000000000") || cpfValue.equals("11111111111") ||
                    cpfValue.equals("22222222222") || cpfValue.equals("33333333333") ||
                    cpfValue.equals("44444444444") || cpfValue.equals("55555555555") ||
                    cpfValue.equals("66666666666") || cpfValue.equals("77777777777") ||
                    cpfValue.equals("88888888888") || cpfValue.equals("99999999999") ||
                    (cpfValue.length() != 11)) {

                cpfValue = null;
            }
            else if (!cpfValue.matches("\\d{11}")) {
                cpfValue = null;
            }
        }

        if (cpfValue == null) {
            throw new IllegalArgumentException();
        }
        this.cpfValue = cpfValue;
    }

    public String getCpfValue() {
        return cpfValue;
    }
}
