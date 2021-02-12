package com.javainuse.springbootsecurity.service;

import com.javainuse.springbootsecurity.model.DAORole;
import com.javainuse.springbootsecurity.model.dto.RoleBean;
import com.javainuse.springbootsecurity.repository.RoleRepository;
import com.javainuse.springbootsecurity.responses.ResponseStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class IRoleService implements RoleService{

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public DAORole saveRole(RoleBean role, ResponseStatus status) {
        DAORole daoRole = roleRepository.findByName(role.getName());
        if(daoRole != null){
            status.setMsg(role.getName()+" is already exists.");
            return null;
        }else {
            daoRole = new DAORole();
        }

        daoRole.setName(role.getName().substring(0,1).toUpperCase() + role.getName().substring(1).toLowerCase());
        daoRole.setStatus(role.getStatus());
        daoRole.setCreateOn(LocalDateTime.now());
        return roleRepository.save(daoRole);
    }

    @Override
    public DAORole updateRole(RoleBean role, ResponseStatus status) {
        DAORole daoRole = roleRepository.findById(role.getId()).get();
        if(daoRole != null){
            DAORole daoRoleTemp = roleRepository.findByName(role.getName());
            if(daoRoleTemp != null){
                status.setMsg(daoRoleTemp.getName()+" is already exists.");
                return null;
            }
            daoRole.setName(role.getName());
            daoRole.setStatus(role.getStatus());
            roleRepository.save(daoRole);
        }else {
            status.setMsg("Invalid role id.");
            return null;
        }
        return null;
    }


    @Override
    public List<RoleBean> getAllRoles() {
        List<RoleBean> roleBeans = new ArrayList<>();
        for(DAORole role : roleRepository.findAll()){
            RoleBean dto = new RoleBean();
            dto.setId(role.getId());
            dto.setName(role.getName());
            dto.setStatus(role.getStatus());
            roleBeans.add(dto);
        }
        return roleBeans;
    }
}
