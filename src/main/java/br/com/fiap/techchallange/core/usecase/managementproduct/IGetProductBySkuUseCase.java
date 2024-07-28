package br.com.fiap.techchallange.core.usecase.managementproduct;

import br.com.fiap.techchallange.core.usecase.dto.product.OutputDataProductDTO;

public interface IGetProductBySkuUseCase {
    OutputDataProductDTO get(String sku);
}
