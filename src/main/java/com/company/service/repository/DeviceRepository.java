package com.company.service.repository;

import com.company.service.entity.Device;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface DeviceRepository extends JpaRepository<Device, Long> {
    Device findDeviceById(Long id);
    void deleteDeviceById(Long id);
}
