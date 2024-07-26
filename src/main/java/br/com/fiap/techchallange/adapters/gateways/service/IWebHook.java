package br.com.fiap.techchallange.adapters.gateways.service;

import br.com.fiap.techchallange.infrastructure.dto.CodeProcessingRequestDTO;

public interface IWebHook {
    public void processingPayment(CodeProcessingRequestDTO codeProcessing);
}
