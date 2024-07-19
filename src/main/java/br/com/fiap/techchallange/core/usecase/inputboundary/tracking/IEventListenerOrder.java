package br.com.fiap.techchallange.core.usecase.inputboundary.tracking;

import br.com.fiap.techchallange.core.usecase.dto.EventOrder;

public interface IEventListenerOrder {
    void onEvent(EventOrder eventOrder);
}
