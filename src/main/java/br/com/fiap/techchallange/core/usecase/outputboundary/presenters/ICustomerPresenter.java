package br.com.fiap.techchallange.core.usecase.outputboundary.presenters;

import br.com.fiap.techchallange.core.usecase.dto.customer.OutputDataCustomerDTO;

public interface ICustomerPresenter {
    CustomerResponseModel present(OutputDataCustomerDTO customerDTO);

    class CustomerResponseModel {
        private String cpf;
        private String name;
        private String email;

        public CustomerResponseModel(OutputDataCustomerDTO customerDTO){
            this.setCpf(customerDTO.cpf());
            this.setName(customerDTO.name());
            this.setEmail(customerDTO.email());
        }

        private void setCpf(String cpf) {
            this.cpf = cpf;
        }

        private void setName(String name) {
            this.name = name;
        }

        private void setEmail(String email) {
            this.email = email;
        }

        public String getCpf() {
            return cpf;
        }

        public String getName() {
            return name;
        }

        public String getEmail() {
            return email;
        }
    }

    public class ErrorResponseModel {
        private String errorMessage;

        public ErrorResponseModel(String errorMessage) {
            this.errorMessage = errorMessage;
        }

        public String getErrorMessage() {
            return errorMessage;
        }

        public void setErrorMessage(String errorMessage) {
            this.errorMessage = errorMessage;
        }
    }
}
