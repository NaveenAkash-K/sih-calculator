package com.project.sihcalci.request;

import com.project.sihcalci.models.Review;
import com.project.sihcalci.models.Score;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ScoreRequest {
    private String parameter;
    private Integer mark;
}
