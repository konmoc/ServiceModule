package com.company.service.repository;

import com.company.service.entity.Device;
import com.company.service.entity.Repair;
import com.company.service.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RepairRepository extends JpaRepository<Repair, Long> {
    Repair findRepairById(Long id);
    Repair findRepairByDeviceToBeRepaired(Device device);
    void deleteRepairById(Long id);
    List<Repair> findRepairsByAssignedUser(User user);
}
