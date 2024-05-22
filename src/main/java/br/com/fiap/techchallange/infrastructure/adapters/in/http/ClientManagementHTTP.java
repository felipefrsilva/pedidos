package br.com.fiap.techchallange.infrastructure.adapters.in.http;

import br.com.fiap.techchallange.application.ClientApplication;
import br.com.fiap.techchallange.infrastructure.ports.in.http.ClientManagement;
import br.com.fiap.techchallange.orders.domain.entity.Client;
import br.com.fiap.techchallange.orders.domain.entity.Product;
import br.com.fiap.techchallange.orders.domain.vo.CPF;
import br.com.fiap.techchallange.orders.domain.vo.MonetaryValue;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/clients")
public class ClientManagementHTTP implements ClientManagement {
    private final ClientApplication clientApplication;

    public ClientManagementHTTP() {
         clientApplication = new ClientApplication();
    }

    @Override
    @PostMapping("/client/add")
    public Client addClient(String cpf, String name, String email) {
        return clientApplication.addCLient(cpf, name, email);
    }

    @PostMapping("/client/add")
    public ResponseEntity<ClientRequestDTO> addClientHTTP(@RequestBody ClientRequestDTO clientDeserializer) {
        CPF cpf = new CPF(String.valueOf(clientDeserializer.cpf()));
        Client client = new Client(
                cpf, clientDeserializer.name(), clientDeserializer.email()
        );
        this.addClient(client);
        return ResponseEntity.status(HttpStatus.CREATED).body(new ClientRequestDTO(client));

    }

    @PutMapping("/product/{sku}/update")
    public ResponseEntity<ProductRequestDTO> updateProductHTTP(@PathVariable String sku, @RequestBody ProductRequestDTO productDeserializer) {
        MonetaryValue monetaryValue = new MonetaryValue(BigDecimal.valueOf(productDeserializer.monetaryValue()));
        Product newProduct = new Product(
                productDeserializer.sku(), productDeserializer.name(), productDeserializer.description(), monetaryValue, productDeserializer.category()
        );
        this.updateProduct(sku, newProduct);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(new ProductRequestDTO(newProduct));
    }

    @Override
    @GetMapping("/client/all")
    public List<Client> getClients() {
        return clientApplication.getClients();
    }

}
