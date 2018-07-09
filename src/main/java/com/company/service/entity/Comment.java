package com.company.service.entity;

import lombok.Data;

import javax.persistence.*;

/**
 * This entity represents comment. Each game result has:
 * -id
 * -it's content
 * -it's author
 * -device which the comment corresponds to
 */

@Data
@Entity
@Table(name = "comments")
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String content;
    @ManyToOne
    private User author;
    @ManyToOne
    Device device;

}
