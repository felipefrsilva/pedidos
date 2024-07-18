package br.com.fiap.techchallange.adapters.controllers.ordercreation;

import br.com.fiap.techchallange.core.usecase.dto.order.InputDataOrderDTO;

public interface IFinishOrderSelectionController {
    public void registerOrder(InputDataOrderDTO inputDataOrderDTO);
}
