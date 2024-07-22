package br.com.fiap.techchallange.infrastructure.api;

import br.com.fiap.techchallange.adapters.controllers.orderpayment.*;
import br.com.fiap.techchallange.core.usecase.dto.orderpayment.OutputDataPaymentDTO;
import br.com.fiap.techchallange.core.usecase.outputboundary.presenters.IOrderPaymentPresenter;
import br.com.fiap.techchallange.infrastructure.dto.CodeProcessingDTO;
import br.com.fiap.techchallange.infrastructure.dto.OrderIdDTO;
import br.com.fiap.techchallange.core.entity.exceptions.ChangeNotAllowedOrderException;
import br.com.fiap.techchallange.infrastructure.ErrorReturn;
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
@Tag(name = "4. Payment Order", description = "Endpoints para pagamento do pedido.")
public class OrderPayment {
    PaymentInitializeController paymentInitializeController;
    PaymentProcessingController paymentProcessingController;
    PaymentCheckStatusController paymentCheckStatusController;
    PaymentGetReadingCodeController paymentGetReadingCodeController;
    GetOrderPaymentController getOrderPaymentController;
    IOrderPaymentPresenter orderPaymentPresenter;

    public OrderPayment(
            PaymentInitializeController paymentInitializeController,
            PaymentProcessingController paymentProcessingController,
            PaymentCheckStatusController paymentCheckStatusController,
            PaymentGetReadingCodeController paymentGetReadingCodeController,
            GetOrderPaymentController getOrderPaymentController,
            IOrderPaymentPresenter orderPaymentPresenter
    ) {
        this.paymentInitializeController = paymentInitializeController;
        this.paymentProcessingController = paymentProcessingController;
        this.paymentCheckStatusController = paymentCheckStatusController;
        this.paymentGetReadingCodeController = paymentGetReadingCodeController;
        this.getOrderPaymentController = getOrderPaymentController;
        this.orderPaymentPresenter = orderPaymentPresenter;
    }

    @PostMapping("{orderId}/initialize")
    @Operation(summary = "Inicializa o processo de pagamento obtendo o código de leitura para pagamento")
    public ResponseEntity<?> finalizeServiceResponse(@PathVariable String orderId) {
        try {
            paymentInitializeController.initializePayment(orderId);
            OutputDataPaymentDTO outputDataPaymentDTO = getOrderPaymentController.getOrderPayment(orderId);
            IOrderPaymentPresenter.OrderPaymentResponseModel response = orderPaymentPresenter.present(outputDataPaymentDTO);
            return new ResponseEntity<>(response, HttpStatus.ACCEPTED);
        } catch (IOException | IllegalArgumentException e){
            Map<String, String> response = new HashMap<>();
            response.put("status", "Ocorreu um erro na finalização do pedido. Erro=" + e.toString());
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
    }

    @Operation(summary = "Obter status do pagamento do pedido")
    @GetMapping("/{idOrder}/status")
    public ResponseEntity<Map<String, String>> getOrderPaymentStatus(@PathVariable String idOrder) {
        try {
            String paymentStatus = this.paymentCheckStatusController.checkStatus(idOrder);
            Map<String, String> response = new HashMap<>();
            response.put("status", paymentStatus);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (IOException e) {
            Map<String, String> response = new HashMap<>();
            response.put("status", "Ocorreu um erro na finalização do pedido. Erro=" + e.toString());
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
    }

    @Operation(summary = "Obter QRCode para pagamento do pedido")
    @GetMapping("/{idOrder}/qrcode")
    public ResponseEntity<?> getOrderPaymentGetReadingCode(@PathVariable String idOrder) {
        try {
            OutputDataPaymentDTO outputDataPaymentDTO = getOrderPaymentController.getOrderPayment(idOrder);
            IOrderPaymentPresenter.OrderPaymentResponseModel response = orderPaymentPresenter.present(outputDataPaymentDTO);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (IOException e) {
            Map<String, String> response = new HashMap<>();
            response.put("status", "Ocorreu um erro na finalização do pedido. Erro=" + e.toString());
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }

    }

    @PostMapping("/processing")
    @Operation(summary = "Registar o pagamento processado pelo Gateway de pagamento")
    public ResponseEntity<Map<String, String>> processingPaymentResponse(@RequestBody CodeProcessingDTO codeProcessing){
        try {
            this.paymentProcessingController.processPayment(codeProcessing.getIdOrder(), codeProcessing.getCode(), codeProcessing.getStatusPayment());
            Map<String, String> response = new HashMap<>();
            response.put("status", "Pagamento registrado com sucesso!");
            return new ResponseEntity<>(response, HttpStatus.CREATED);
        } catch (IOException | IllegalArgumentException e) {
            Map<String, String> response = new HashMap<>();
            response.put("status", "Ocorreu um erro na finalização do pedido. Erro=" + e.toString());
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
    }

    @ExceptionHandler(ChangeNotAllowedOrderException.class)
    public ResponseEntity<ErrorReturn> handleChangeNotAllowedOrderException(ChangeNotAllowedOrderException ex) {
        ErrorReturn error = new ErrorReturn(3256, ex.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
    }

}
