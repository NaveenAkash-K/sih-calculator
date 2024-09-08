package com.project.sihcalci.query;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.project.sihcalci.models.Parameter;
import com.project.sihcalci.models.Round;
import com.project.sihcalci.response.ReviewResponse;
import com.project.sihcalci.response.TeamResponse;
import com.project.sihcalci.service.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class Query implements GraphQLQueryResolver {

    private final AuthService authService;

    private final ParameterService parameterService;
    private final RoundService roundService;
    private final ReviewService reviewService;
    private final TeamService teamService;

    public String firstQuery(){
        return authService.firstQuery();
    }

    public List<Parameter> getParameters() {
        return parameterService.getAParameters();
    }

    public List<Round> getRounds() {
        return roundService.getRounds();
    }

    public List<ReviewResponse> getReviews() {
        return reviewService.getReviews();
    }

    public List<TeamResponse> getTeams() {
        return teamService.getTeams();
    }

}
