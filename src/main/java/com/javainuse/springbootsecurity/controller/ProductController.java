package com.javainuse.springbootsecurity.controller;


import com.javainuse.springbootsecurity.model.dto.ProductBean;
import com.javainuse.springbootsecurity.responses.ResponseStatus;
import com.javainuse.springbootsecurity.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping()
    public ResponseEntity<ResponseStatus> saveProduct(@RequestBody ProductBean bean) throws Exception {
        ResponseStatus status = new ResponseStatus();
        productService.saveProduct(bean, status);
        if (status.getMsg() == null) {
            status.setCode(1);
            status.setMsg("Product saved.");
        }
        return ResponseEntity.ok(status);
    }

    @GetMapping()
    public ResponseEntity<ResponseStatus> getProducts() throws Exception {
        ResponseStatus status = new ResponseStatus();
        List<ProductBean> products = productService.getProducts();
        if (status.getMsg() == null) {
            status.setCode(1);
            status.setMsg("Products");
            status.setData(products);
        }
        return ResponseEntity.ok(status);
    }

    @RequestMapping(path="/{name}",method = RequestMethod.GET)
    public ResponseEntity<ResponseStatus> getProductByName(@PathVariable("name") String name) throws Exception {
        ResponseStatus status = new ResponseStatus();
        ProductBean product = productService.getProductByName(name,status);
        if (status.getMsg() == null) {
            status.setCode(1);
            status.setMsg("Product.");
            status.setData(product);
        }
        return ResponseEntity.ok(status);
    }

    @RequestMapping(path="/code/{prodCode}",method = RequestMethod.GET)
    public ResponseEntity<ResponseStatus> getProductByProdCode(@PathVariable("prodCode") String prodCode) throws Exception {
        ResponseStatus status = new ResponseStatus();
        ProductBean product = productService.getProductByProdCode(prodCode,status);
        if (status.getMsg() == null) {
            status.setCode(1);
            status.setMsg("Product.");
            status.setData(product);
        }
        return ResponseEntity.ok(status);
    }
}
