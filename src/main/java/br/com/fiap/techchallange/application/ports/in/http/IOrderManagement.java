package br.com.fiap.techchallange.application.ports.in.http;

import br.com.fiap.techchallange.application.dto.CodeProcessingDTO;
import br.com.fiap.techchallange.application.dto.OrderDTO;
import com.google.zxing.WriterException;

import java.io.IOException;

public interface IOrderManagement {

    String initializeService();
    void addProductToOrder(String idOrder, String sku, Integer qtd);
    void removeProductToOrder(String idOrder, String sku);
    void finalizeService(String idOrder) throws IOException, WriterException;
    OrderDTO getOrder(String idOrder);
}
