package com.javainuse.springbootsecurity.service;

import com.javainuse.springbootsecurity.model.DAORole;
import com.javainuse.springbootsecurity.model.dto.RoleBean;
import com.javainuse.springbootsecurity.responses.ResponseStatus;

import java.util.List;

public interface RoleService {
    public DAORole saveRole(RoleBean role, ResponseStatus resStatus);
    public DAORole updateRole(RoleBean role, ResponseStatus resStatus);
    public List<RoleBean> getAllRoles();
}
