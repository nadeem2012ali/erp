package com.javainuse.springbootsecurity.service;

import com.javainuse.springbootsecurity.model.Category;
import com.javainuse.springbootsecurity.model.dto.ProductBean;
import com.javainuse.springbootsecurity.model.Product;
import com.javainuse.springbootsecurity.repository.CategoryRepository;
import com.javainuse.springbootsecurity.repository.ProductRepository;
import com.javainuse.springbootsecurity.responses.ResponseStatus;
import com.javainuse.springbootsecurity.util.CommonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class IProductService implements ProductService{

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public void saveProduct(ProductBean bean, ResponseStatus status) {

        Optional<Category> category = categoryRepository.findById(bean.getCategoryId());
        if(!category.isPresent()){
            status.setMsg("Invalid category id.");
            return;
        }
        Product product = productRepository.findByName(bean.getName());
        if(product != null){
            if(product.getCategory().getId() == bean.getCategoryId()){
                status.setMsg("Product already exists with categoryId.");
                return;
            }
        }else {
            product = new Product();
        }
        product.setProdCode(CommonUtil.autoGenProdCode());
        product.setCategory(category.get());
        product.setName(bean.getName());
        product.setDescriptions(bean.getDescriptions());
        product.setCreatedOn(LocalDateTime.now());
        productRepository.save(product);
    }

    @Override
    public List<ProductBean> getProducts() {
       List<ProductBean> beans = new ArrayList<>();
        for(Product product:productRepository.findAll()){
            ProductBean bean = new ProductBean();
            bean.setId(product.getId());
            bean.setProdCode(product.getProdCode());
            bean.setName(product.getName());
            bean.setDescriptions(product.getDescriptions());
            bean.setCategoryId(product.getCategory().getId());
            beans.add(bean);
        }
        return beans;
    }

    @Override
    public ProductBean getProductByName(String name, ResponseStatus status) {

        Product product = productRepository.findByName(name);
        if(product != null){
            ProductBean bean = new ProductBean();
            bean.setId(product.getId());
            bean.setCategoryId(product.getCategory().getId());
            bean.setName(product.getName());
            bean.setProdCode(product.getProdCode());
            bean.setDescriptions(product.getDescriptions());
            return bean;
        }else {
            status.setMsg("Product not found.");
            return null;
        }
    }

    @Override
    public ProductBean getProductByProdCode(String prodCode, ResponseStatus status) {
        Product product = productRepository.findByProdCode(prodCode);
        if(product != null){
            ProductBean bean = new ProductBean();
            bean.setId(product.getId());
            bean.setCategoryId(product.getCategory().getId());
            bean.setName(product.getName());
            bean.setProdCode(product.getProdCode());
            bean.setDescriptions(product.getDescriptions());
            return bean;
        }else {
            status.setMsg("Product not found.");
            return null;
        }
    }
}
