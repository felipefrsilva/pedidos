package br.com.fiap.techchallange.infrastructure.service.mock;

import br.com.fiap.techchallange.adapters.gateways.service.IGenerateNumberOrder;

public class GenerateNumberOrderMock implements IGenerateNumberOrder {

    private Integer number = 1;

    @Override
    public Integer generate() {
       return SequentialNumberGenerator.getInstance().generateNextNumber();
    }
}
