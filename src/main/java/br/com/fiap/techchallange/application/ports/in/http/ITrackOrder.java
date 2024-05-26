package br.com.fiap.techchallange.application.ports.in.http;

import br.com.fiap.techchallange.application.dto.TrackerOrderDTO;

public interface ITrackOrder {

    TrackerOrderDTO getTracker(String orderId);
    void prepareFood(String orderId);
    void finishPreparation(String orderId);
    void deliverFood(String orderId);
}
