package com.project.sihcalci.models;

import javax.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
@Table
public class Review {
    @Id
    @Column(name="review_id")
    private String id;

    @ManyToOne(cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.REFRESH})
    @JoinColumn(name="user_id")
    private User user;

    @ManyToOne(cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.REFRESH})
    @JoinColumn(name="team_id")
    private Team team;

    @Column(name = "round")
    private int round;

    @OneToMany(mappedBy = "review",cascade = CascadeType.ALL)
    List<Score> scores;

}
