package br.com.fiap.techchallange.application.ports.in.http;

import br.com.fiap.techchallange.application.dto.CodeProcessingDTO;
import com.google.zxing.WriterException;

import java.io.IOException;

public interface IPaymentOrder {
    void initializePayment(String idOrder) throws IOException, WriterException;
    void processingPayment(CodeProcessingDTO codeProcessing) throws IOException, WriterException;
}
