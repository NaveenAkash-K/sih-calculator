package com.project.sihcalci.mutation;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.project.sihcalci.models.Parameter;
import com.project.sihcalci.request.CreateReviewRequest;
import com.project.sihcalci.response.ReviewResponse;
import com.project.sihcalci.service.ParameterService;
import com.project.sihcalci.service.ReviewService;
import com.project.sihcalci.service.RoundService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class Mutation implements GraphQLMutationResolver {

    private final ParameterService parameterService;

    private final RoundService roundService;
    private final ReviewService reviewService;

    public Parameter addParameter(Parameter parameter) {
        return parameterService.addParameter(parameter);
    }

    public String deleteParameter(Long id) {
        return parameterService.deleteParameter(id);
    }

    public String toggleRound(Long id) {
        roundService.toggleRound(id);
        return "Round toggled successfully";
    }

    public ReviewResponse postReview(CreateReviewRequest createReviewRequest) {
        return reviewService.postReview(createReviewRequest);
    }
}
