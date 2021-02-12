package com.javainuse.springbootsecurity.controller;

import com.javainuse.springbootsecurity.model.dto.PersonBean;
import com.javainuse.springbootsecurity.responses.ResponseStatus;
import com.javainuse.springbootsecurity.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("person")
public class PersonController {

    @Autowired
    private PersonService personService;

    @PostMapping()
    public ResponseEntity<ResponseStatus> savePerson(@RequestBody PersonBean bean) throws Exception {
        ResponseStatus status = new ResponseStatus();
        personService.savePerson(bean, status);
        if (status.getMsg() == null) {
            status.setCode(1);
            status.setMsg(bean.getPersonType()+" saved.");
        }
        return ResponseEntity.ok(status);
    }


    @GetMapping()
    public ResponseEntity<ResponseStatus> getAllPerson() throws Exception {
        ResponseStatus status = new ResponseStatus();
        List<PersonBean> beans = personService.getAllPerson();
        if (status.getMsg() == null) {
            status.setCode(1);
            status.setMsg("Person List");
            status.setData(beans);
        }
        return ResponseEntity.ok(status);
    }

    @RequestMapping(path = "/{personType}", method = RequestMethod.GET)
    public ResponseEntity<ResponseStatus> getAllPersonByType(@PathVariable("personType") String personType) throws Exception {
        ResponseStatus status = new ResponseStatus();
        List<PersonBean> beans = personService.getAllPersonByType(personType, status);
        if (status.getMsg() == null) {
            status.setCode(1);
            status.setMsg(personType+" List");
            status.setData(beans);
        }
        return ResponseEntity.ok(status);
    }

}
