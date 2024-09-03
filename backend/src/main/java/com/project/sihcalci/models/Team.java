package com.project.sihcalci.models;

import com.project.sihcalci.enums.Category;
import javax.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
@Table
public class Team {
    @Id
    @Column(name="team_id")
    private String teamId;

    @Enumerated(EnumType.STRING)
    @Column(name="category")
    private Category category;

    @Column(name = "team_name")
    private String teamName;

    @OneToMany(mappedBy = "team",cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.REFRESH},fetch = FetchType.EAGER)
    List<Review> reviews;
}
