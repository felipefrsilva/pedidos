package br.com.fiap.techchallange.adapters.presenters.managementproduct;

import br.com.fiap.techchallange.core.usecase.dto.product.OutputDataProductDTO;
import br.com.fiap.techchallange.core.usecase.outputboundary.presenters.managementproduct.IProductManagementPresenter;

import java.util.ArrayList;
import java.util.List;

public class ProductManagementPresenter implements IProductManagementPresenter {
    @Override
    public List<ProductResponseModel> presentList(List<OutputDataProductDTO> productDTO) {
        List<ProductResponseModel> viewProducts = new ArrayList();

        for(OutputDataProductDTO product: productDTO){
            viewProducts.add(new ProductResponseModel(product));
        }
        return viewProducts;
    }

    @Override
    public ProductResponseModel present(OutputDataProductDTO productDTO) {
        return new ProductResponseModel(productDTO);
    }
}
