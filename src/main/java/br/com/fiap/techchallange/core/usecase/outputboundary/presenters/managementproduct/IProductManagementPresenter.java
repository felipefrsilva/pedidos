package br.com.fiap.techchallange.core.usecase.outputboundary.presenters.managementproduct;

import br.com.fiap.techchallange.core.usecase.dto.product.OutputDataProductDTO;

import java.util.List;

public interface IProductManagementPresenter {
    List<ProductResponseModel> presentList(List<OutputDataProductDTO> productDTO);
    ProductResponseModel present(OutputDataProductDTO productDTO);

    class ProductResponseModel{
        private String sku;
        private String name;
        private String description;
        private float value;

        public ProductResponseModel(OutputDataProductDTO productDTO) {
            this.setSku(productDTO.getSku());
            this.setName(productDTO.getName());
            this.setDescription(productDTO.getDescription());
            this.setValue(productDTO.getValue());
        }

        private void setSku(String sku) {
            this.sku = sku;
        }

        private void setName(String name) {
            this.name = name;
        }

        private void setDescription(String description) {
            this.description = description;
        }

        private void setValue(float value) {
            this.value = value;
        }

        public String getSku() {
            return sku;
        }

        public String getName() {
            return name;
        }

        public String getDescription() {
            return description;
        }

        public float getValue() {
            return value;
        }

    }
}
