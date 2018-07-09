package com.company.service.entity;

import lombok.Data;

import javax.persistence.*;

/**
    Entity describing Repair
    Repair is created after device is broken and has to be fixed.
 */

@Entity
@Table(name = "repairs")
@Data
public class Repair {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne
    private Device deviceToBeRepaired;
    @ManyToOne
    User assignedUser;
    @Enumerated(EnumType.ORDINAL)
    RepairStatus repairStatus;

}
