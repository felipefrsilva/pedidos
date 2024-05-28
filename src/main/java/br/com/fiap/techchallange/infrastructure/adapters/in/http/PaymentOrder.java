package br.com.fiap.techchallange.infrastructure.adapters.in.http;

import br.com.fiap.techchallange.application.dto.CodeProcessingDTO;
import br.com.fiap.techchallange.application.dto.OrderDTO;
import br.com.fiap.techchallange.application.ports.in.http.IPaymentOrder;
import br.com.fiap.techchallange.application.usecases.ServiceOrderApplication;
import br.com.fiap.techchallange.domain.exceptions.ChangeNotAllowedOrderException;
import br.com.fiap.techchallange.infrastructure.exceptions.ErrorReturn;
import br.com.fiap.techchallange.infrastructure.factory.FactoryOrderApplication;
import com.google.zxing.WriterException;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/v1/payments")
@Tag(name = "4. Payment Order", description = "Endpoints para pagamento do pedido.")
public class PaymentOrder implements IPaymentOrder {

    ServiceOrderApplication serviceOrder;
    FactoryOrderApplication factory;

    @Autowired
    public void setFactory(FactoryOrderApplication factory) {
        this.factory = factory;
        this.serviceOrder = factory.createOrderApplication();
    }

    @PostMapping("/initialize")
    @Operation(summary = "Inicializa o processo de pagamento obtendo o código de leitura para pagamento")
    public ResponseEntity<Map<String, String>> finalizeServiceResponse(@RequestBody OrderDTO order) {
        try {
            initializePayment(order.getId());
        }catch (WriterException | IOException e){
            Map<String, String> response = new HashMap<>();
            response.put("status", "Ocorreu um erro na finalização do pedido. Erro=" + e.toString());
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }

        Map<String, String> response = new HashMap<>();
        response.put("status", "Código de leitura gerado para pagamento.");
        return new ResponseEntity<>(response, HttpStatus.ACCEPTED);
    }

    @PostMapping("/processing")
    @Operation(summary = "Registar o pagamento processado pelo Gateway de pagamento")
    public ResponseEntity<Map<String, String>> processingPaymentResponse(@RequestBody CodeProcessingDTO codeProcessing){
        processingPayment(codeProcessing);
        Map<String, String> response = new HashMap<>();
        response.put("status", "Pagamento registrado com sucesso!");
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @ExceptionHandler(ChangeNotAllowedOrderException.class)
    public ResponseEntity<ErrorReturn> handleChangeNotAllowedOrderException(ChangeNotAllowedOrderException ex) {
        ErrorReturn error = new ErrorReturn(3256, ex.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
    }

    @Override
    public void initializePayment(String idOrder) throws IOException, WriterException {
        serviceOrder.initializePayment(idOrder);
    }

    @Override
    public void processingPayment(CodeProcessingDTO codeProcessing) {
        serviceOrder.processPayment(codeProcessing);
    }
}
