package com.company.service.entity;

import lombok.Data;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.List;
import java.util.Set;

/**
 * This entity describes user who uses our application.
 * He/She is described by:
 *  -username(String username)
 *  -first name(String firstName)
 *  -last name(String lastName)
 *  -encoded password(String password)
 *  -enabled status(int enabled).
 * EACH USER:
 *  -can have many sent messages(List<Message> messagesSent)-not yet implemented
 *  -can have many received messages(List<Message> messagesReceived-not yet implemented
 *  -can have many roles(Set<Role> roles)
 */

@Entity
@Table(name = "users")
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    @Size(min = 4, max = 20, message = "Username should be at least 4 characters long. Maximal length is 20.")
    private String username;
    @NotBlank(message = "This field cannot be left empty!")
    private String password;
    @NotBlank(message = "This field cannot be left empty!")
    private String firstName;
    @NotBlank(message = "This field cannot be left empty!")
    private String lastName;
    private int enabled;

    @ManyToMany(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    @JoinTable(name = "users_roles", joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles;




//    @LazyCollection(LazyCollectionOption.FALSE)
//    @OneToMany(cascade = CascadeType.ALL)
//    private List<Message> messagesSent;
//
//    @LazyCollection(LazyCollectionOption.FALSE)
//    @ManyToMany(cascade = CascadeType.ALL)
//    private List<Message> messagesReceived;


}
