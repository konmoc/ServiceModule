package com.company.service.service;

import com.company.service.entity.Repair;
import com.company.service.entity.User;
import com.company.service.repository.RepairRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RepairService {

    @Autowired
    RepairRepository repairRepository;

    public Repair findRepairById(Long id){return repairRepository.findRepairById(id);}
    public List<Repair> findAllRepairs(){return repairRepository.findAll();}
    public void deleteRepairById(Long id){repairRepository.deleteRepairById(id);}
    public void save(Repair repair){repairRepository.save(repair);}
    public List<Repair> findRepairsByUserAssigned(User user){return repairRepository.findRepairsByAssignedUser(user);}



}
