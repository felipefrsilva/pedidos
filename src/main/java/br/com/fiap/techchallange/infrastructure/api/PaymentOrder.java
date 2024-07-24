package br.com.fiap.techchallange.infrastructure.api;

import br.com.fiap.techchallange.adapters.presenters.viewmodel.ErrorViewModel;
import br.com.fiap.techchallange.infrastructure.dto.CodeProcessingRequestDTO;
import br.com.fiap.techchallange.infrastructure.dto.OrderIdRequestDTO;
import br.com.fiap.techchallange.core.entity.exceptions.ChangeNotAllowedOrderException;
import com.google.zxing.WriterException;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/v1/payments")
@Tag(name = "3. Payment Order", description = "Endpoints para pagamento do pedido.")
public class PaymentOrder {


    @PostMapping("/initialize")
    @Operation(summary = "Inicializa o processo de pagamento obtendo o código de leitura para pagamento")
    public ResponseEntity<Map<String, String>> finalizeServiceResponse(@RequestBody OrderIdRequestDTO order) {
        try {
            initializePayment(order.getOrderId());
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
    public ResponseEntity<Map<String, String>> processingPaymentResponse(@RequestBody CodeProcessingRequestDTO codeProcessing){
        processingPayment(codeProcessing);
        Map<String, String> response = new HashMap<>();
        response.put("status", "Pagamento registrado com sucesso!");
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @ExceptionHandler(ChangeNotAllowedOrderException.class)
    public ResponseEntity<ErrorViewModel> handleChangeNotAllowedOrderException(ChangeNotAllowedOrderException ex) {
        ErrorViewModel error = new ErrorViewModel(3256, ex.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
    }

    public void initializePayment(String idOrder) throws IOException, WriterException {

    }


    public void processingPayment(CodeProcessingRequestDTO codeProcessing) {

    }
}
