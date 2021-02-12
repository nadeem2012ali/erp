package com.javainuse.springbootsecurity.repository;

import com.javainuse.springbootsecurity.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    Product findByName(String name);
    Product findByProdCode(String prodCode);
}
