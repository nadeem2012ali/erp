package com.javainuse.springbootsecurity.repository;

import com.javainuse.springbootsecurity.model.Category;
import com.javainuse.springbootsecurity.model.DAORole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
    Category findByName(String name);
}
