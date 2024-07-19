package br.com.fiap.techchallange.infrastructure.service;

import br.com.fiap.techchallange.adapters.gateways.service.IDisplayMonitor;
import br.com.fiap.techchallange.adapters.presenters.viewmodel.OrderViewModel;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class DisplayMonitorWeb implements IDisplayMonitor {

    @Override
    public void display(OrderViewModel orderView) {

        RestTemplate restTemplate = new RestTemplate();
        String monitorUrl = "http://localhost:8081/notify";
        OrderNotification order = new OrderNotification(orderView.number_order(), orderView.status());
        restTemplate.postForEntity(monitorUrl,  order, Void.class);
    }

    public record OrderNotification(int orderId, String status){}
}
