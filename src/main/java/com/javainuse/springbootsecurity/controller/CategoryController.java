package com.javainuse.springbootsecurity.controller;

import com.javainuse.springbootsecurity.model.dto.CategoryBean;
import com.javainuse.springbootsecurity.responses.ResponseStatus;
import com.javainuse.springbootsecurity.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
@RequestMapping("categories")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @PostMapping()
    public ResponseEntity<ResponseStatus> saveRole(@RequestBody CategoryBean bean) throws Exception {
        ResponseStatus status = new ResponseStatus();
        categoryService.saveCategory(bean, status);
        if (status.getMsg() == null) {
            status.setCode(1);
            status.setMsg("Category saved.");
        }
        return ResponseEntity.ok(status);
    }

    @GetMapping()
    public ResponseEntity<ResponseStatus> getCategories() throws Exception {
        ResponseStatus status = new ResponseStatus();
       List<CategoryBean>  beans = categoryService.getAllCategories();
        if (status.getMsg() == null) {
            status.setCode(1);
            status.setMsg("Categories");
            status.setData(beans);
        }
        return ResponseEntity.ok(status);
    }

}
