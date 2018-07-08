package com.company.service.service;

import com.company.service.entity.Repair;
import com.company.service.repository.RepairRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RepairService {

    @Autowired
    RepairRepository repairRepository;

    Repair findRepairById(Long id){return repairRepository.findRepairById(id);}
    List<Repair> findAllRepairs(){return repairRepository.findAll();}
    void deleteRepairById(Long id){repairRepository.deleteRepairById(id);}
    void save(Repair repair){repairRepository.save(repair);}



}
