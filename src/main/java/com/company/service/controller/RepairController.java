package com.company.service.controller;

import com.company.service.entity.Repair;
import com.company.service.entity.RepairStatus;
import com.company.service.entity.User;
import com.company.service.service.RepairService;
import com.company.service.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/repair")
public class RepairController {

    @Autowired
    UserService userService;
    @Autowired
    RepairService repairService;

    @GetMapping("/assignedToUser")
    public String showServicemanRepairs(Model model){
        User user = userService.findByUserName(SecurityContextHolder.getContext().getAuthentication().getName());
        List<Repair> userRepairs = repairService.findRepairsByUserAssigned(user);
        model.addAttribute("repairs",userRepairs);
        return "UserRepairs";
    }

    @GetMapping("/all")
    public String allRepairs(Model model){
        List<Repair> repairs = repairService.findAllRepairs();
        model.addAttribute("repairs",repairs);
        return "AllRepairs";
    }

    @GetMapping("/{repairId}")
    public String makeTeamBet(@PathVariable Long repairId) {
        Repair repair = repairService.findRepairById(repairId);
        repair.setRepairStatus(RepairStatus.REPAIRED);
        repairService.save(repair);
        return "Home";
    }






}
