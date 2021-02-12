package com.javainuse.springbootsecurity.service;

import com.javainuse.springbootsecurity.model.dto.CategoryBean;
import com.javainuse.springbootsecurity.responses.ResponseStatus;

import java.util.List;

public interface CategoryService {
    public void saveCategory(CategoryBean bean, ResponseStatus status);
    public List<CategoryBean>  getAllCategories();
}
