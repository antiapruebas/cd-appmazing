package com.campusdual.appmazing.model.dto.dtomapper;

import com.campusdual.appmazing.model.Products;
import com.campusdual.appmazing.model.dto.ProductsDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;
@Mapper
public interface ProductsMapper {
    ProductsMapper INSTANCE = Mappers.getMapper(ProductsMapper.class);

    ProductsDTO productToProductDto(Products product);
    List<ProductsDTO> toDTOList(List<Products> products);
    Products  toEntity(ProductsDTO productDTO);
}
