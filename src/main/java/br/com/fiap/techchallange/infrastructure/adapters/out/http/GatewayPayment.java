package br.com.fiap.techchallange.infrastructure.adapters.out.http;

import br.com.fiap.techchallange.application.ports.out.api.IGatewayPayment;
import com.google.zxing.WriterException;

import java.io.IOException;

public class GatewayPayment implements IGatewayPayment {
    @Override
    public String getCodeReading(float value) throws IOException, WriterException {
        return "";
    }
}
