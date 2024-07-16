package br.com.fiap.techchallange.infrastructure.http;

import br.com.fiap.techchallange.infrastructure.dto.TrackerOrderDTO;

public interface ITrackOrder {

    TrackerOrderDTO getTracker(String orderId);
    void prepareFood(String orderId);
    void finishPreparation(String orderId);
    void deliverFood(String orderId);
}
