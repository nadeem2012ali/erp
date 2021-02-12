package com.javainuse.springbootsecurity.service;

import com.javainuse.springbootsecurity.model.dto.PersonBean;
import com.javainuse.springbootsecurity.responses.ResponseStatus;

import java.util.List;

public interface PersonService {
    public void savePerson(PersonBean bean, ResponseStatus status);
    public List<PersonBean> getAllPerson();
    public List<PersonBean> getAllPersonByType(String personType,ResponseStatus status);
}
