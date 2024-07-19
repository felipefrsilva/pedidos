package br.com.fiap.techchallange.core.usecase.inputboundary.tracking;

import br.com.fiap.techchallange.core.usecase.dto.order.OutputDataOrderDTO;

import java.util.List;

public interface IOrderListingUseCase {

    public List<OutputDataOrderDTO> invoke();
}
