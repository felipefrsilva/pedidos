package br.com.fiap.techchallange.infrastructure.adapters.out.http;

import br.com.fiap.techchallange.application.ports.out.api.IGenerateNumberOrder;

public class GenerateNumberOrderMock implements IGenerateNumberOrder {

    private Integer number = 1;

    @Override
    public Integer generate() {
       return SequentialNumberGenerator.getInstance().generateNextNumber();
    }
}
