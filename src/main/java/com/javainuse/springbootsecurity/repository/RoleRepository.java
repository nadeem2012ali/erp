package com.javainuse.springbootsecurity.repository;

import com.javainuse.springbootsecurity.model.DAORole;
import com.javainuse.springbootsecurity.model.DAOUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<DAORole, Long> {
    DAORole findByName(String name);
}
