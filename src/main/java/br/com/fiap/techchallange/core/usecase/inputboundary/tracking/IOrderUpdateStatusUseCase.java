package br.com.fiap.techchallange.core.usecase.inputboundary.tracking;

import br.com.fiap.techchallange.core.usecase.tracking.EventOrder;

public interface IOrderUpdateStatusUseCase {

    public void invoke(EventOrder eventOrder);
}
