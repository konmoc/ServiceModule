package com.company.service.service;

import com.company.service.entity.*;
import com.github.javafaker.Faker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class StartAppService {

    @Autowired
    RoleService roleService;
    @Autowired
    UserService userService;
    @Autowired
    DeviceService deviceService;
    @Autowired
            ParamService paramService;

    Faker faker = new Faker();

    Random random = new Random();

    /**
     * This method creates application starting data like Players, Video Games Genres, Video Games, etc.
     * It is only used while application is started for the first time.
     */

    public void startApp() {

        if(userService.countAllPlayers()==0){
        //1)we create roles -  for admin, serviceman and user:

        Role userRole = new Role();
        Role adminRole = new Role();
        Role serviceManRole = new Role();
        userRole.setName("ROLE_USER");
        adminRole.setName("ROLE_ADMIN");
        serviceManRole.setName("ROLE_SERVICEMAN");
        roleService.saveRole(userRole);
        roleService.saveRole(adminRole);
        roleService.saveRole(serviceManRole);

            //we create 20 users
            for(int i=0;i<20;i++){
                User user = new User();
                user.setUsername("userNo"+i);
                user.setFirstName(faker.name().firstName());
                user.setLastName(faker.name().lastName());
                user.setPassword("user");
                Role role = roleService.findRoleById(1L);
                Set<Role> roles = new HashSet<>();
                roles.add(role);
                user.setRoles(roles);
                userService.saveUser(user);

            }
            //we create 3 servicemen
            for(int i=0;i<3;i++){
                User user = new User();
                user.setUsername("serviceManNo"+i);
                user.setFirstName(faker.name().firstName());
                user.setLastName(faker.name().lastName());
                user.setPassword("serviceman");
                userService.saveUser(user);

            }
            //we create admin
                User user = new User();
                user.setUsername("admin");
                user.setFirstName(faker.name().firstName());
                user.setLastName(faker.name().lastName());
                user.setPassword("admin");
                userService.saveUser(user);

//            //we create 20 random params(colors here)
//            for(int i=0;i<20;i++){
//                Param param = new Param();
//                param.setParamName("Color" + i);
//                param.setParamValue(faker.color().name());
//                paramService.saveParam(param);
//            }
//            //we create 20 random params(ids here)
//            for(int i=0;i<20;i++){
//                Param param = new Param();
//                param.setParamName("IdNumber" + i);
//                param.setParamValue(faker.idNumber().valid());
//                paramService.saveParam(param);
//            }

            //we create 10 random fridges
            for(int i=0;i<10;i++){
                Fridge fridge = new Fridge();
                fridge.setDeviceName("Fridge model" + i);
                fridge.setDeviceStatus(DeviceStatus.UP_AND_RUNNING);
                deviceService.saveDevice(fridge);
            }

            //we create 10 random personal computers
            for(int i=0;i<10;i++){
                PersonalComputer pc = new PersonalComputer();
                pc.setDeviceName("PersonalComputer" + i);
                pc.setDeviceStatus(DeviceStatus.UP_AND_RUNNING);
                deviceService.saveDevice(pc);
            }


            System.out.println("STARTING DATA INITIALIZED");
    }else{
            System.out.println("STARTING DATA ALREADY INITIALIZED");
        }
    }

}
