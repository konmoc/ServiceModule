package com.company.service.service;

import com.company.service.entity.*;
import com.company.service.service.DeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * This service contains scheaduled methods
 */

@Service
public class ScheaduledService {

    @Autowired
    DeviceService deviceService;
    @Autowired
    UserService userService;
    @Autowired
            RepairService repairService;

    Random rand = new Random();

    /**
     * This method breaks random device
     */

    @Scheduled(fixedDelay = 10000)
    public void breakDevices(){
        try {
            TimeUnit.SECONDS.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        List<Device> devicesToBeBroken = deviceService.findAllDevices();
        Device randomDevice = devicesToBeBroken.get(rand.nextInt(devicesToBeBroken.size()));
        if(randomDevice.getDeviceStatus().equals(DeviceStatus.UP_AND_RUNNING)){
            randomDevice.setDeviceStatus(DeviceStatus.BROKEN);
        }
        deviceService.saveDevice(randomDevice);
        System.out.println("Device broken!");
    }

    /**
     * this method assigns serviceman to random broken device
     */

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

    /**
     * this method checks if the repair is finished and if it is it sets device status to "UP_AND_RUNNING"
     */

    @Scheduled(fixedDelay = 10000)
    public void checkIfRepairsAreFinished(){
        List<Repair> repairs = repairService.findAllRepairs();
        for(Repair repair : repairs){
            if(repair.getRepairStatus().equals(RepairStatus.REPAIRED)){
                Device repairedDevice = repair.getDeviceToBeRepaired();
                repairedDevice.setDeviceStatus(DeviceStatus.UP_AND_RUNNING);
                deviceService.saveDevice(repairedDevice);
            }
        }
    }

}
