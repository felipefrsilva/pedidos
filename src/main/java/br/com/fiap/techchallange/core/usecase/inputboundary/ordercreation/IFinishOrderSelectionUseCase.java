package br.com.fiap.techchallange.core.usecase.inputboundary.ordercreation;

import br.com.fiap.techchallange.core.usecase.dto.order.InputDataOrderDTO;

public interface IFinishOrderSelectionUseCase {
    public void registerOrder(InputDataOrderDTO inputDataOrderDTO);
}
