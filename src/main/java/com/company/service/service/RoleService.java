package com.company.service.service;

import com.company.service.entity.Role;
import com.company.service.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class RoleService {

    @Autowired
    RoleRepository roleRepository;

    public void saveRole(Role role){
        roleRepository.save(role);
    }

    public Role findRoleById(Long id){
        return  roleRepository.findRoleById(id);
    }
    public void deleteRoleWithId(Long id){
        roleRepository.deleteRoleById(id);
    }
    public Role findRoleByName(String name){return roleRepository.findRoleByName(name);}
}
