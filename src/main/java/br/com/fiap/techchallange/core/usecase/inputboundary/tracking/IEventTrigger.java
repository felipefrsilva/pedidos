package br.com.fiap.techchallange.core.usecase.inputboundary.tracking;

import br.com.fiap.techchallange.core.usecase.dto.order.EventOrder;

public interface IEventTrigger {
    public void event(EventOrder eventOrder);
}
