package com.javainuse.springbootsecurity.service;

import com.javainuse.springbootsecurity.model.dto.PersonBean;
import com.javainuse.springbootsecurity.repository.PersonRepository;
import com.javainuse.springbootsecurity.responses.ResponseStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IPersonService implements PersonService{

    @Autowired
    private PersonRepository personRepository;

    @Override
    public void savePerson(PersonBean bean, ResponseStatus status) {

    }

    @Override
    public List<PersonBean> getAllPerson() {
        return null;
    }

    @Override
    public List<PersonBean> getAllPersonByType(String personType, ResponseStatus status) {
        return null;
    }
}
