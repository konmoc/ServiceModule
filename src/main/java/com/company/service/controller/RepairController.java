package com.company.service.controller;

import com.company.service.entity.User;
import com.company.service.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;

@Controller
@RequestMapping("/repair")
public class RepairController {

    @Autowired
    UserService userService;

    @GetMapping("/user")
    public String showServicemanRepairs(){
        User user = userService.findByUserName(SecurityContextHolder.getContext().getAuthentication().getName());
    }

//    @GetMapping("/userAccount")
//    public String showUserAccount(Model model){
//        User user = userService.findByUserName(SecurityContextHolder.getContext().getAuthentication().getName());
//        List<Bet> userBets = betService.findBetsByUser(user);
//        List<Bet> user1v1Bets = new ArrayList<>();
//        List<Bet> userTeamBets = new ArrayList<>();
//        for(Bet bet : userBets){
//            if(bet.getGame().getPlayersInGame().size()>0){
//                user1v1Bets.add(bet);
//            }else{
//                userTeamBets.add(bet);
//            }
//        }
//        model.addAttribute("user", user);
//        model.addAttribute("playerBets",user1v1Bets);
//        model.addAttribute("teamBets",userTeamBets);
//        return "UserAccount";
//    }
//    @GetMapping("/userMessages")
//    public String showUserMessages(Model model){
//        User user = userService.findByUserName(SecurityContextHolder.getContext().getAuthentication().getName());
//        List<Message> receivedMessages = user.getMessagesReceived();
//        model.addAttribute("messages", receivedMessages);
//        return "Mailbox";
//    }


}
