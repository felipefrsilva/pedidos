package br.com.fiap.techchallange.adapters.controllers.tracking;

import br.com.fiap.techchallange.core.usecase.inputboundary.tracking.IGetLatestOrderNumberUseCase;

public class GetLatestOrderNumberController implements IGetLatestOrderNumberController{

    private final IGetLatestOrderNumberUseCase getLatestOrderNumberUseCase;

    public GetLatestOrderNumberController(IGetLatestOrderNumberUseCase getLatestOrderNumberUseCase){
        this.getLatestOrderNumberUseCase = getLatestOrderNumberUseCase;
    }

    @Override
    public int getLastNumber() {
        return getLatestOrderNumberUseCase.getLastNumber();
    }
}
