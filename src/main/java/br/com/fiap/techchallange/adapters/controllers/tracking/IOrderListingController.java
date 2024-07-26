package br.com.fiap.techchallange.adapters.controllers.tracking;

import br.com.fiap.techchallange.core.usecase.dto.order.OutputDataOrderDTO;

import java.util.List;

public interface IOrderListingController {
    public List<OutputDataOrderDTO> invoke();
}
