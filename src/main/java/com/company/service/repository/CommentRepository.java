package com.company.service.repository;

import com.company.service.entity.Comment;
import com.company.service.entity.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentRepository extends JpaRepository<Comment,Long> {
    Comment findCommentById(Long id);
    void deleteCommentById(Long id);
}
