package br.com.fiap.techchallange.adapters.gateways.service;

import java.io.IOException;

public interface IGatewayPayment {

    public String getCodeReading(float value) throws IOException;

}
