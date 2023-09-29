package com.campusdual.appmazing.controller;

import com.campusdual.appmazing.api.IProductService;
import com.campusdual.appmazing.model.dto.ProductsDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping ("/products")
public class ProductController {

    @Autowired
    IProductService productService;

    @GetMapping
    public String testController() {
    return "Product controller works!";
    }

    @PostMapping
    public String testController(@RequestBody String name){
        return "Product controller works " + name + "!";
    }

    @GetMapping (value="/testMethod")
    public String testControllerMethod() {
        return  "ProductController method works!";
    }

    @PostMapping(value="/get")
    public ProductsDTO queryProduct(@RequestBody ProductsDTO product){
        return this.productService.queryProducts(product);
    }

    @GetMapping (value="/getAll")
    public List<ProductsDTO> queryAllProducts() {
    return this.productService.queryAllProducts();
    }

@PostMapping (value="/add")
public int insertProduct (@RequestBody ProductsDTO product) {
        return this.productService.insertProduct(product);
    }
    @PutMapping (value="/update")
    public int updateProduct (@RequestBody ProductsDTO product) {
        return this.productService.updateProduct(product);
}
@DeleteMapping(value="/delete")
public int deleteProduct (@RequestBody ProductsDTO product) {
        return this.productService.deleteProduct(product);
}
}