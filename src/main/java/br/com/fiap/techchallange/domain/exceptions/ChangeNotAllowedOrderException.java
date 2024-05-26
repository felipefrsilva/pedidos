package br.com.fiap.techchallange.domain.exceptions;

public class ChangeNotAllowedOrderException extends RuntimeException {

        public ChangeNotAllowedOrderException(String mensagem) {
            super(mensagem);
        }
}
