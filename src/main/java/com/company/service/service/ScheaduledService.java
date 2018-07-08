package com.company.service.service;

import com.company.service.entity.*;
import com.company.service.service.DeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;
@Service
public class ScheaduledService {

    @Autowired
    DeviceService deviceService;
    @Autowired
    UserService userService;
    @Autowired
            RepairService repairService;

    Random rand = new Random();

    @Scheduled(fixedDelay = 20000)
    public void breakDevices(){
        List<Device> devicesToBeBroken = deviceService.findAllDevices();
        devicesToBeBroken.get(rand.nextInt(devicesToBeBroken.size())).setDeviceStatus(DeviceStatus.BROKEN);
        deviceService.saveAllDevices(devicesToBeBroken);
        System.out.println("Device broken!");
    }

    @Scheduled(fixedDelay = 50000)
    public void assignServicemanToRepair(){
        List<Device> devices = deviceService.findAllDevices();
        for(Device d : devices){
            if(d.getDeviceStatus().equals(DeviceStatus.BROKEN)){
                //we change status of the device
                d.setDeviceStatus(DeviceStatus.BEING_REPAIRED);
                deviceService.saveDevice(d);
                Repair repair = new Repair();
                //we randomly choose serviceman from list
                List<User> servicemen = userService.findAllServicemen();
                User serviceman = servicemen.get(rand.nextInt(servicemen.size()));
                //we set repairman
                repair.setAssignedUser(serviceman);
                //we set device
                repair.setDeviceToBeRepaired(d);
                repair.setRepairStatus(RepairStatus.IN_REPAIR);
                repairService.save(repair);
                System.out.println("Servicemen assigned!");
            }
        }
    }

}
