package br.com.fiap.techchallange.infrastructure.config.controller.ordercreation;

import br.com.fiap.techchallange.adapters.controllers.ordercreation.FinishOrderSelectionController;
import br.com.fiap.techchallange.adapters.controllers.ordercreation.IFinishOrderSelectionController;
import br.com.fiap.techchallange.core.usecase.inputboundary.ordercreation.IFinishOrderSelectionUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FinishOrderSelectionControllerConfig {

    @Bean
    public IFinishOrderSelectionController getinstanceFinishOrderController(IFinishOrderSelectionUseCase finishOrderSelectionUseCase){
        return new FinishOrderSelectionController(finishOrderSelectionUseCase);
    }

}
