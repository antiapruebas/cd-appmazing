package com.campusdual.appmazing.controller;
import com.campusdual.appmazing.api.IProductService;
import com.campusdual.appmazing.model.dto.ProductsDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping ("/products")
public class ProductController {

    @Autowired
    private  IProductService productService;

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

    @PutMapping(value="/buy5")
    public int buyFiveProduct(@RequestBody ProductsDTO productDTO) {
        return this.productService.buyProduct(productDTO,5);
    }

    @PostMapping(value="/totalBuy5")
    public BigDecimal buyProduct(@RequestBody ProductsDTO productDTO) {
        int  quantity =5;
        this.productService.buyProduct(productDTO, quantity);
        BigDecimal quantityBD = new BigDecimal(quantity);
        return productService.totalPrice(productDTO, quantityBD);
    }

    @PostMapping (value="/buy")
    public int buyProduct (@RequestBody Map<String, Integer> body ){
        ProductsDTO product = new ProductsDTO();
        int quantity =body.get("quantity");
        product.setId(body.get("id"));
        return this.productService.buyProduct(product, quantity);
    }



    /*
    @PutMapping(value="/buy")
    public BigDecimal buyProduct(@RequestBody ProductsDTO productDTO, @RequestBody int quantity) {
         this.productService.buyProduct(productDTO, quantity);
         BigDecimal quantityBD = new BigDecimal(quantity);
         return productService.totalPrice(productDTO, quantityBD);*/
    }





