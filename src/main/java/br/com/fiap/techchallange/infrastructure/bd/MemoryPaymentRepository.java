package br.com.fiap.techchallange.infrastructure.bd;

import br.com.fiap.techchallange.adapters.gateways.repository.IPaymentRepository;
import br.com.fiap.techchallange.core.entity.Payment;


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
