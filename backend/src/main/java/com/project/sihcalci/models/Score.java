package com.project.sihcalci.models;

import javax.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table
public class Score {
    @Id
    @Column(name = "score_id")
    private String scoreId;

    @ManyToOne(cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.REFRESH})
    @JoinColumn(name = "review_id")
    private Review review;

    @Column(name = "parameter")
    private String parameter;

    @Column(name = "mark")
    private int mark;
}
