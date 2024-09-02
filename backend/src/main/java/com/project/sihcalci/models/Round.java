package com.project.sihcalci.models;

import javax.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table
public class Round {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="round_id")
    private Long id;

    @Column(name = "isActive")
    private boolean isActive;
}
