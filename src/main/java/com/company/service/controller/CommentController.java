package com.company.service.controller;

import com.company.service.entity.Comment;
import com.company.service.service.CommentService;
import com.company.service.service.DeviceService;
import com.company.service.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/comment")
public class CommentController {

    @Autowired
    DeviceService deviceService;
    @Autowired
    UserService userService;
    @Autowired
    CommentService commentService;

    @GetMapping("/add/{deviceId}")
    public String addComment(@PathVariable Long deviceId, Model model){
        //we create comment
        Comment comment = new Comment();
        comment.setAuthor(userService.findByUserName(SecurityContextHolder.getContext().getAuthentication().getName()));
        comment.setDevice(deviceService.findDeviceById(deviceId));
        model.addAttribute("comment", comment);
        return "AddCommentForm";
    }

    @PostMapping("/add")
    public String addComment(@ModelAttribute Comment comment){
        commentService.saveComment(comment);
        return "Home";
    }
}
