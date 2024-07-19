package br.com.fiap.techchallange.core.usecase.inputboundary.orderpayment;

import java.io.IOException;

public interface IPaymentGetReadingCodeUseCase {
    String getReadingCode(String idOrder) throws IOException;
}
