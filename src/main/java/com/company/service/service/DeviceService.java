package com.company.service.service;

import com.company.service.entity.Device;
import com.company.service.repository.DeviceRepository;
import com.company.service.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeviceService {

    @Autowired
    DeviceRepository deviceRepository;

    public void saveDevice(Device device){deviceRepository.save(device);}
    public Device findDeviceById(Long id){return deviceRepository.findDeviceById(id);}
    public void deleteDeviceById(Long id){deviceRepository.deleteDeviceById(id);}
    public List<Device> findAllDevices(){return deviceRepository.findAll();}
    public void saveAllDevices(List<Device> devices){deviceRepository.saveAll(devices);}




}
