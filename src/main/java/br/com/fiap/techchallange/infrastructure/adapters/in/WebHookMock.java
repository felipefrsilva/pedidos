package br.com.fiap.techchallange.infrastructure.adapters.in;

import br.com.fiap.techchallange.application.OrderApplication;
import br.com.fiap.techchallange.application.dto.CodeProcessingDTO;
import br.com.fiap.techchallange.application.ports.in.http.IWebHook;
import br.com.fiap.techchallange.infrastructure.factory.FactoryOrderApplication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/webhookmock")
@Component
public class WebHookMock implements IWebHook {

    private OrderApplication orderApplication;
    FactoryOrderApplication factory;

    @Autowired
    public void setFactory(FactoryOrderApplication factory) {
        this.factory = factory;
        this.orderApplication = factory.createOrderApplication();
    }

    @PostMapping("/ordersmanagement/order/processingPayment")
    public ResponseEntity<Map<String, String>> processingPaymentResponse(@RequestBody CodeProcessingDTO codeProcessing) {
        processingPayment(codeProcessing);
        Map<String, String> response = new HashMap<>();
        response.put("status", "Pagamento registrado com sucesso!");
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @Override
    public void processingPayment(CodeProcessingDTO codeProcessing) {
        orderApplication.processPayment(codeProcessing);
    }
}
