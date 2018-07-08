package com.company.service.repository;

import com.company.service.entity.Device;
import com.company.service.entity.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParamRepository extends JpaRepository<Param,Long> {
    Param findParamById(Long id);
    void deleteParamById(Long id);

}
