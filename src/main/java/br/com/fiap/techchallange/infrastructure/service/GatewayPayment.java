package br.com.fiap.techchallange.infrastructure.service;

import br.com.fiap.techchallange.adapters.gateways.service.IGatewayPayment;


import java.io.IOException;

public class GatewayPayment implements IGatewayPayment {
    @Override
    public String getCodeReading(float value) throws IOException {
            return "";
    }
}
