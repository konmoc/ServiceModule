package com.company.service.entity;

import lombok.Data;

import javax.persistence.*;

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
