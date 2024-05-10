package Domain.Entities;

import Domain.ValueObjects.MetodoPagamentoVO;
import Domain.ValueObjects.ValorVO;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Pagamento {
    private ValorVO valor;
    private MetodoPagamentoVO metodo;
    private String status;
    private LocalDateTime dataHora;
}
