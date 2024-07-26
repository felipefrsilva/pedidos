package br.com.fiap.techchallange.core.usecase.inputboundary.checkout;

import br.com.fiap.techchallange.core.usecase.dto.order.InputDataOrderDTO;
import br.com.fiap.techchallange.core.usecase.dto.order.OutputDataOrderDTO;

public interface IFinishOrderSelectionUseCase {
    public OutputDataOrderDTO invoke(InputDataOrderDTO inputDataOrderDTO);
}
