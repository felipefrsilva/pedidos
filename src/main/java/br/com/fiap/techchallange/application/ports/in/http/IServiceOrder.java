package br.com.fiap.techchallange.application.ports.in.http;

import br.com.fiap.techchallange.application.dto.OrderDTO;
import com.google.zxing.WriterException;

import java.io.IOException;

public interface IServiceOrder {

    String initializeService();
    OrderDTO getOrder(String idOrder);
    void addProductToOrder(String idOrder, String sku, Integer qtd);
    void removeProductToOrder(String idOrder, String sku);
}
