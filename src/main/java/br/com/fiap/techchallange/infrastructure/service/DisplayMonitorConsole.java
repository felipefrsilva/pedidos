package br.com.fiap.techchallange.infrastructure.service;

import br.com.fiap.techchallange.adapters.gateways.service.IDisplayMonitor;
import br.com.fiap.techchallange.adapters.presenters.viewmodel.OrderViewModel;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Component
public class DisplayMonitorConsole implements IDisplayMonitor {

    @Override
    public void display(OrderViewModel orderView) {
        Logger logger = Logger.getLogger("DisplayMonitorConsole");
        logger.log(java.util.logging.Level.INFO, "Order: " + orderView.number_order() + " Status: " + orderView.status());
    }
}
