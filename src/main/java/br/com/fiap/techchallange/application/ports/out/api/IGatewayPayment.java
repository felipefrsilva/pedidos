package br.com.fiap.techchallange.application.ports.out.api;

import com.google.zxing.WriterException;

import java.io.IOException;

public interface IGatewayPayment {

    public String getCodeReading(float value) throws IOException, WriterException;

}
