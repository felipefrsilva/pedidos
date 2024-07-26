package br.com.fiap.techchallange.infrastructure.service;

import br.com.fiap.techchallange.adapters.controllers.tracking.IGetLatestOrderNumberController;
import br.com.fiap.techchallange.adapters.gateways.service.IGenerateNumberOrder;

public class GenerateNumberOrder implements IGenerateNumberOrder {

    private final IGetLatestOrderNumberController getLatestOrderNumberController;

    public GenerateNumberOrder(IGetLatestOrderNumberController getLatestOrderNumberController) {
        this.getLatestOrderNumberController = getLatestOrderNumberController;
    }

    @Override
    public Integer generate() {
        return getLatestOrderNumberController.getLastNumber() + 1;
    }
}
