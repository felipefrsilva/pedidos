package br.com.fiap.techchallange.core.usecase.managementproduct;

import br.com.fiap.techchallange.core.usecase.dto.product.InputDataProductDTO;

public interface IRegisterProductUseCase {
    void invoke(InputDataProductDTO inputDataProductDTO);
}
