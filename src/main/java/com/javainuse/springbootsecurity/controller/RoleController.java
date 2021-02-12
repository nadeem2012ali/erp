package com.javainuse.springbootsecurity.controller;

import com.javainuse.springbootsecurity.model.dto.RoleBean;
import com.javainuse.springbootsecurity.responses.ResponseStatus;
import com.javainuse.springbootsecurity.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("roles")
public class RoleController {

    @Autowired
    private RoleService roleService;

    @PostMapping()
    public ResponseEntity<ResponseStatus> saveRole(@RequestBody RoleBean role) throws Exception {
        ResponseStatus status = new ResponseStatus();
        roleService.saveRole(role, status);
        if (status.getMsg() == null) {
            status.setCode(1);
            status.setMsg("Role saved.");
        }
        return ResponseEntity.ok(status);
    }

    @PutMapping()
    public ResponseEntity<ResponseStatus> updateRole(@RequestBody RoleBean role) throws Exception {
        ResponseStatus status = new ResponseStatus();
        roleService.updateRole(role, status);
        if (status.getMsg() == null) {
            status.setCode(1);
            status.setMsg("Role updated.");
        }
        return ResponseEntity.ok(status);
    }

    @GetMapping()
    public ResponseEntity<ResponseStatus> getRole(@RequestBody RoleBean user) throws Exception {
        ResponseStatus status = new ResponseStatus();
        List<RoleBean> dtoList = roleService.getAllRoles();
        if (status.getMsg() == null) {
            status.setCode(1);
            status.setMsg("Roles");
            status.setData(dtoList);
        }
        return ResponseEntity.ok(status);
    }
}
