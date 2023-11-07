package com.campusdual.appmazing.service;
import com.campusdual.appmazing.api.IProductService;
import com.campusdual.appmazing.model.Products;
import com.campusdual.appmazing.model.dao.ProductDao;
import com.campusdual.appmazing.model.dto.ProductsDTO;
import com.campusdual.appmazing.model.dto.dtomapper.ProductsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service("ProductService")
@Lazy
public class ProductService implements IProductService {
    @Autowired
    private ProductDao productDao;

    @Override
    public ProductsDTO queryProducts(ProductsDTO productDTO) {

        Products product = ProductsMapper.INSTANCE.toEntity(productDTO);
        Products productFinal = this.productDao.getReferenceById(product.getId());
        ProductsDTO dto = ProductsMapper.INSTANCE.toDto(productFinal);
        return dto;
    }

    @Override
    public List<ProductsDTO> queryAllProducts() {
        return ProductsMapper.INSTANCE.toDTOList(this.productDao.findAll());

    }

    @Override
    public int insertProduct(ProductsDTO productDTO) {
        Products product = ProductsMapper.INSTANCE.toEntity(productDTO);
        Products product1 = this.productDao.saveAndFlush(product);
        return product1.getId();
    }

    @Override
    public int updateProduct(ProductsDTO productDTO) {
        return this.insertProduct(productDTO);
    }

    @Override
    public int deleteProduct(ProductsDTO productDTO) {
        int id = productDTO.getId();
        Products product = ProductsMapper.INSTANCE.toEntity(productDTO);
        productDao.delete(product);
        return id;
    }

   @Override
    public int buyProduct (ProductsDTO product, int quantity) {
        ProductsDTO productToBuy = this.queryProducts(product);
        if (productToBuy.isActive() && quantity <= productToBuy.getStock()){
            productToBuy.setStock(productToBuy.getStock() + quantity);
            this.updateProduct(productToBuy);
    }
        return productToBuy.getStock();
    }


    @Override
   public BigDecimal totalPrice(ProductsDTO product, BigDecimal quantity) {
        BigDecimal priceBD = product.getPrice();
        return priceBD.multiply(quantity);
    }

}


