package com.project.sihcalci.request;


import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class CreateReviewRequest {
    private String userId;
    private String teamId;
    private Integer round;
    private List<ScoreRequest> scoreRequests;

}


