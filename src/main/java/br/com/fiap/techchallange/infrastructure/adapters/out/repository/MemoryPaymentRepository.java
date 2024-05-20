package br.com.fiap.techchallange.infrastructure.adapters.out.repository;

import br.com.fiap.techchallange.application.ports.out.repository.IPaymentRepository;
import br.com.fiap.techchallange.domain.entity.Payment;


import java.util.ArrayList;
import java.util.List;

public class MemoryPaymentRepository implements IPaymentRepository {

    private final List<Payment> payments;

    public MemoryPaymentRepository(){
        payments =  new ArrayList<Payment>();
    }

    @Override
    public void addPayment(Payment payment) {
        payments.add(payment);
    }

    @Override
    public Payment getPayment(String id) {
        for (Payment payment : payments) {
            if (payment.getId().equals(id)) {
                return payment;
            }
        }
        return null;
    }
}
