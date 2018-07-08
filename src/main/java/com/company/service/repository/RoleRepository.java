package com.company.service.repository;

import com.company.service.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findRoleById(Long id);
    Role findByName(String name);
    List<Role> findAll();
    void deleteRoleById(Long id);
    Role findRoleByName(String name);
}
