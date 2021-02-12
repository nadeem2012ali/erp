package com.javainuse.springbootsecurity.service;

import com.javainuse.springbootsecurity.model.Category;
import com.javainuse.springbootsecurity.model.dto.CategoryBean;
import com.javainuse.springbootsecurity.repository.CategoryRepository;
import com.javainuse.springbootsecurity.responses.ResponseStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class ICategoryService implements CategoryService{
    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public void saveCategory(CategoryBean bean, ResponseStatus status) {

        Category category = categoryRepository.findByName(bean.getName());
        if(category != null){
            status.setMsg(category.getName()+" already exists.");
            return;
        }else {
            category = new Category();
        }

        category.setCreatedOn(LocalDateTime.now());
        category.setName(bean.getName());
        category.setDescriptions(bean.getDescriptions());
        categoryRepository.save(category);
    }

    @Override
    public List<CategoryBean> getAllCategories() {
        List<CategoryBean> categoryBeans = new ArrayList<>();
        for(Category category : categoryRepository.findAll()){
            CategoryBean bean = new CategoryBean();
            bean.setId(category.getId());
            bean.setName(category.getName());
            bean.setDescriptions(category.getDescriptions());
            categoryBeans.add(bean);
        }
        return categoryBeans;
    }
}
