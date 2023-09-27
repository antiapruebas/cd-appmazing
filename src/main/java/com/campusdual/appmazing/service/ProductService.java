package com.campusdual.appmazing.service;
import com.campusdual.appmazing.api.IProductService;
import com.campusdual.appmazing.model.Products;
import com.campusdual.appmazing.model.dao.ProductDao;
import com.campusdual.appmazing.model.dto.ProductsDTO;
import com.campusdual.appmazing.model.dto.dtomapper.ProductsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

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
        return null;
    }

    @Override
    public int insertProduct(ProductsDTO product) {
        return 0;
    }

    @Override
    public int updateProduct(ProductsDTO product) {
        return 0;
    }

    @Override
    public int deleteProduct(ProductsDTO product) {
        return 0;
    }
}
