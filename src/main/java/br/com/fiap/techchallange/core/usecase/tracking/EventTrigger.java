package br.com.fiap.techchallange.core.usecase.tracking;

public class EventTrigger implements IEventTrigger {
    private final IEventListenerOrder eventListener;

    public EventTrigger(IEventListenerOrder eventListener) {
        this.eventListener = eventListener;
    }

    public void event(EventOrder eventOrder) {
        eventListener.onEvent(eventOrder);
    }
}
