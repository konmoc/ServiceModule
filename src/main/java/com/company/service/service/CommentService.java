package com.company.service.service;

import com.company.service.entity.Comment;
import com.company.service.entity.Device;
import com.company.service.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentService {

    @Autowired
    CommentRepository commentRepository;

    public void saveComment(Comment comment){commentRepository.save(comment);}
    public Comment findCommentById(Long id){return commentRepository.findCommentById(id);}
    public void deleteCommentById(Long id){commentRepository.deleteCommentById(id);}
}
