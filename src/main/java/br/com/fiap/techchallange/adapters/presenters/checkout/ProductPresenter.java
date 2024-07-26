package br.com.fiap.techchallange.adapters.presenters.checkout;

import br.com.fiap.techchallange.core.usecase.dto.product.OutputDataProductDTO;
import br.com.fiap.techchallange.core.usecase.outputboundary.presenters.checkout.IProductPresenter;

import java.util.ArrayList;
import java.util.List;

public class ProductPresenter implements IProductPresenter {


    @Override
    public List<ProductResponseModel> present(List<OutputDataProductDTO> productsDTO) {

        List<ProductResponseModel> viewProducts = new ArrayList<>();

        for(OutputDataProductDTO product: productsDTO){
            viewProducts.add(new ProductResponseModel(product));
        }

        return viewProducts;
    }
}


