package br.com.fiap.techchallange.infrastructure;

public class ErrorReturn {

    private Integer code;
    private String message;

    public ErrorReturn(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
