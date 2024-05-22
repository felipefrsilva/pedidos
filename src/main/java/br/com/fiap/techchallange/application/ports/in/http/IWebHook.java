package br.com.fiap.techchallange.application.ports.in.http;

import br.com.fiap.techchallange.application.dto.CodeProcessingDTO;

public interface IWebHook {

    public void processingPayment(CodeProcessingDTO codeProcessing);

}
