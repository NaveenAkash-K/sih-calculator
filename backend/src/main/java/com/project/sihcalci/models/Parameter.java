package com.project.sihcalci.models;

import javax.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table
public class Parameter {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="param_id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name="max_marks")
    private int maxMarks;
}
