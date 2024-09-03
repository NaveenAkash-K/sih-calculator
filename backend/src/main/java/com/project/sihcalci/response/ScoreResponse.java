package com.project.sihcalci.response;

import com.project.sihcalci.models.Score;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ScoreResponse {
    private String scoreId;
    private String reviewId;
    private String parameter;
    private int mark;

    public ScoreResponse(Score score) {
        this.scoreId = score.getScoreId();
        this.reviewId = score.getReview().getId();
        this.parameter = score.getParameter();
        this.mark = score.getMark();
    }
}
