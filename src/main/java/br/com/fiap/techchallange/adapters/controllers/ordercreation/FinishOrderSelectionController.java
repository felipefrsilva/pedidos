package br.com.fiap.techchallange.adapters.controllers.ordercreation;

import br.com.fiap.techchallange.core.usecase.dto.order.InputDataOrderDTO;
import br.com.fiap.techchallange.core.usecase.inputboundary.ordercreation.IFinishOrderSelectionUseCase;

public class FinishOrderSelectionController implements IFinishOrderSelectionController {

    public IFinishOrderSelectionUseCase finishOrderSelectionUseCase;

    public FinishOrderSelectionController(IFinishOrderSelectionUseCase finishOrderSelectionUseCase) {
        this.finishOrderSelectionUseCase = finishOrderSelectionUseCase;
    }

    @Override
    public void registerOrder(InputDataOrderDTO inputDataOrderDTO) {
        this.finishOrderSelectionUseCase.registerOrder(inputDataOrderDTO);
    }
}
