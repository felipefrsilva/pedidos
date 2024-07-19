package br.com.fiap.techchallange.core.usecase.outputboundary.presenters;

import br.com.fiap.techchallange.core.usecase.dto.orderpayment.OutputDataPaymentDTO;

public interface IOrderPaymentPresenter {
    OrderPaymentResponseModel present(OutputDataPaymentDTO outputDataPaymentDTO);

    class OrderPaymentResponseModel {
        private String orderId;
        private String codePayment;
        private float paymentAmount;

        public  OrderPaymentResponseModel(OutputDataPaymentDTO outputDataPaymentDTO) {
            this.setOrderId(outputDataPaymentDTO.getOrderId());
            this.setCodePayment(outputDataPaymentDTO.getReadingCode());
            this.setPaymentAmount(outputDataPaymentDTO.getMonetaryValue());
        }

        public String getOrderId() {
            return orderId;
        }

        public void setOrderId(String orderId) {
            this.orderId = orderId;
        }

        public String getCodePayment() {
            return codePayment;
        }

        public void setCodePayment(String codePayment) {
            this.codePayment = codePayment;
        }

        public float getPaymentAmount() {
            return paymentAmount;
        }

        public void setPaymentAmount(float paymentAmount) {
            this.paymentAmount = paymentAmount;
        }
    }

}
