package br.com.fiap.techchallange.domain.vo;

public class ProcessingCodePayment {

    private String code;

    public ProcessingCodePayment(String code) {
        this.setCode(code);
    }

    private void setCode(String code) {

        if (code == null){
            throw new IllegalArgumentException(
                    "Processing Code Payment cannot be empty"
            );
        }

        this.code = code;
    }

    public String getCode() {
        return code;
    }
}
