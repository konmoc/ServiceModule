package com.company.service.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

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



}
