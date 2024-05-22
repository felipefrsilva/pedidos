package br.com.fiap.techchallange.domain.vo;

public class ReadingCodePayment {

    private String code;

    public ReadingCodePayment(String code) {
        this.setCode(code);
    }

    public String getCode() {
        return code;
    }

    private void setCode(String code) {

        if (code == null){
            throw new IllegalArgumentException(
                    "Processing Code Reading cannot be empty"
            );
        }

        this.code = code;
    }
}
