package com.company.service.controller;

import com.company.service.entity.Device;
import com.company.service.entity.DeviceStatus;
import com.company.service.entity.DeviceType;
import com.company.service.entity.Param;
import com.company.service.service.DeviceService;
import com.company.service.service.ParamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/device")
public class DeviceController {

    @Autowired
    DeviceService deviceService;
    @Autowired
    ParamService paramService;


    @GetMapping("/add")
    public String addDevice(Model model){
        Device device = new Device();
        //to be added later- to choose what category of device we want to add
//        String[] enumValues =  Arrays.toString(DeviceType.values()).replaceAll("^.|.$", "").split(", ");
//        List<String> enumValuesList = Arrays.asList(enumValues);
//        model.addAttribute("enums", enumValuesList);
        model.addAttribute("device", device);
        return "DeviceAddForm";
    }

    @PostMapping("/add")
    public String addDevice(Device device){
        //setting the inital status
        device.setDeviceStatus(DeviceStatus.UP_AND_RUNNING);
        //checking if all the form inputs were filled
        List<Param> formParams = device.getParamList();
        List<Param> correctParams = new ArrayList<>();
        for(Param p : formParams){
            if(!p.getParamName().equals("") || !p.getParamValue().equals("") ){
                correctParams.add(p);
            }
        }
        device.setParamList(correctParams);
        paramService.saveAllParams(correctParams);
        deviceService.saveDevice(device);
        return "Home";
    }

    @GetMapping("/show/all")
    public String showAllDevices(Model model){
        List<Device> devices = deviceService.findAllDevices();
        model.addAttribute("devices", devices );
        return "Devices";
    }

    @GetMapping("/show/broken")
    public String showBrokenDevices(Model model){
        List<Device> allDevices = deviceService.findAllDevices();
        List<Device> brokenDevices = new ArrayList<>();
        for(Device d : allDevices){
            if(d.getDeviceStatus()==DeviceStatus.BROKEN || d.getDeviceStatus()==DeviceStatus.BEING_REPAIRED){
                brokenDevices.add(d);
            }
        }
        model.addAttribute("devices", brokenDevices);
        return "Devices";
    }

    @GetMapping("/setStatus/broken/{deviceId}")
    public String setDeviceStatusAsBroken(@PathVariable Long deviceId){
        Device device = deviceService.findDeviceById(deviceId);
        device.setDeviceStatus(DeviceStatus.BROKEN);
        deviceService.saveDevice(device);
        return "Home";
    }

    @GetMapping("/details/{deviceId}")
    public String showDetails(@PathVariable Long deviceId, Model model){
        Device device = deviceService.findDeviceById(deviceId);
        model.addAttribute("device", device);
        return "DeviceDetails";
    }




}
