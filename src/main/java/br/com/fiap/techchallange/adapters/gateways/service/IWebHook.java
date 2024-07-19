package br.com.fiap.techchallange.adapters.gateways.service;

import br.com.fiap.techchallange.infrastructure.dto.CodeProcessingDTO;

public interface IWebHook {
    public void processingPayment(CodeProcessingDTO codeProcessing);
}
