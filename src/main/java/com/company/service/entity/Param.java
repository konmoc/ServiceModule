package com.company.service.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

/**
    Params/Parameters
    it just describes the device
 */

@Entity
@Table(name = "params")
@Data
public class Param {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String paramName;
    private String paramValue;

}
