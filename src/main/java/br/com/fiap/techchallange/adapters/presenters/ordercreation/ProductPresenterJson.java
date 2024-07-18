package br.com.fiap.techchallange.adapters.presenters.ordercreation;

import br.com.fiap.techchallange.core.usecase.dto.product.OutputDataProductDTO;
import br.com.fiap.techchallange.core.usecase.outputboundary.presenters.IProductPresenter;

import java.util.ArrayList;
import java.util.List;

public class ProductPresenterJson implements IProductPresenter {


    @Override
    public List<ProductResponseModel> present(List<OutputDataProductDTO> productsDTO) {

        List<ProductResponseModel> viewProducts = new ArrayList<>();

        for(OutputDataProductDTO product: productsDTO){
            viewProducts.add(new ProductResponseModel(product));
        }

        return viewProducts;
    }
}


