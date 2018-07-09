package com.company.service.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

/**
 * This entity represents device. Each single device has:
 * -id
 * -it's name
 * -it's status - broken, working, etc.
 * -list of params
 * -list of comments written by users to describe the device
 */

@Entity
@Table(name = "devices")
@Data
public class Device {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String deviceName;
    @Enumerated(EnumType.STRING)
    DeviceStatus deviceStatus;
    @ManyToMany
    List<Param> paramList;
    @OneToMany(mappedBy = "device", cascade = CascadeType.ALL)
    List<Comment> comments;



}
