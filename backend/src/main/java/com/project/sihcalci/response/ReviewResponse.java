package com.project.sihcalci.response;

import com.project.sihcalci.models.Review;
import com.project.sihcalci.models.Score;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class ReviewResponse {
    private String id;
    private String judgeId;
    private String judgeName;
    private String teamId;
    private String teamName;
    private Integer round;
    private List<ScoreResponse> scores;

    public ReviewResponse(Review review) {
        this.id = review.getId();
        this.judgeId = review.getUser().getUid();
        this.judgeName = review.getUser().getUsername();
        this.teamId = review.getTeam().getTeamId();
        this.teamName = review.getTeam().getTeamName();
        this.round = review.getRound();
        this.scores = new ArrayList<>();
        for(Score score : review.getScores()) {
            scores.add(new ScoreResponse(score));
        }
    }
}
