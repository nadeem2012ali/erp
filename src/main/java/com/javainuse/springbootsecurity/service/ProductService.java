package com.javainuse.springbootsecurity.service;

import com.javainuse.springbootsecurity.model.dto.ProductBean;
import com.javainuse.springbootsecurity.responses.ResponseStatus;

import java.util.List;

public interface ProductService {
    public void saveProduct(ProductBean bean, ResponseStatus status);
    public ProductBean getProductByName(String name, ResponseStatus status);
    public ProductBean getProductByProdCode(String prodCode, ResponseStatus status);
    public List<ProductBean> getProducts ();
}
