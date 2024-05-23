package br.com.fiap.techchallange.application.ports.out.repository;

import br.com.fiap.techchallange.domain.entity.Payment;

public interface IPaymentRepository {

    public void addPayment(Payment payment);
    public Payment getPayment(String id);
}
