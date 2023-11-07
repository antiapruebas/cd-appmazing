package com.campusdual.appmazing.api;

import com.campusdual.appmazing.model.dto.ProductsDTO;

import java.math.BigDecimal;
import java.util.List;

public interface IProductService {
    ProductsDTO queryProducts(ProductsDTO productDTO);
    List<ProductsDTO> queryAllProducts();

    int insertProduct(ProductsDTO productDTO);
    int updateProduct(ProductsDTO productDTO);

    int deleteProduct(ProductsDTO productDTO);

    int buyProduct(ProductsDTO productDTO, int quantity);

    BigDecimal totalPrice(ProductsDTO productDTO, BigDecimal quantity);
}
