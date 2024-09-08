package com.project.sihcalci.models;

import javax.persistence.*;

import com.project.sihcalci.request.ScoreRequest;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@Entity
@Table
@NoArgsConstructor
public class Score {
    @Id
    @Column(name = "score_id")
    private String scoreId;

    @ManyToOne(cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.REFRESH,CascadeType.PERSIST})
    @JoinColumn(name = "review_id")
    private Review review;

    @Column(name = "parameter")
    private String parameter;

    @Column(name = "mark")
    private int mark;

    public Score(ScoreRequest scoreRequest,Review review) {
        UUID uuid = UUID.randomUUID();
        this.scoreId = uuid.toString();
        this.review = review;
        this.parameter = scoreRequest.getParameter();
        this.mark = scoreRequest.getMark();
    }
}
