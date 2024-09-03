package com.project.sihcalci.service;

import com.project.sihcalci.models.Review;
import com.project.sihcalci.models.Score;
import com.project.sihcalci.models.Team;
import com.project.sihcalci.models.User;
import com.project.sihcalci.repositories.ReviewRepository;
import com.project.sihcalci.repositories.ScoreRepository;
import com.project.sihcalci.repositories.TeamRepository;
import com.project.sihcalci.repositories.UserRepository;
import com.project.sihcalci.request.CreateReviewRequest;
import com.project.sihcalci.request.ScoreRequest;
import com.project.sihcalci.response.ReviewResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ReviewService {
    private final ReviewRepository reviewRepository;
    private final UserRepository userRepository;
    private final TeamRepository teamRepository;
    private final ScoreRepository scoreRepository;

    public List<ReviewResponse> getReviews(){
        List<Review> reviews = reviewRepository.findAll();
        List<ReviewResponse> reviewResponses = new ArrayList<>();
        for(Review review : reviews){
            reviewResponses.add(new ReviewResponse(review));
        }
        return reviewResponses;
    }

    public ReviewResponse postReview(CreateReviewRequest createReviewRequest){
        Review review = new Review();
        UUID uuid = UUID.randomUUID();
        review.setId(uuid.toString());
        User user = userRepository.findById(createReviewRequest.getUserId()).orElseThrow(() -> new UsernameNotFoundException("User not found "));
        Team team = teamRepository.findById(createReviewRequest.getTeamId()).orElseThrow(() -> new UsernameNotFoundException("Team not found "));
        review.setUser(user);
        review.setTeam(team);
        review.setRound(createReviewRequest.getRound());
        List<Score> scores = new ArrayList<>();
        for(ScoreRequest scoreRequest : createReviewRequest.getScoreRequests()){
            scores.add(new Score(scoreRequest,review));
        }
        review.setScores(scores);
        reviewRepository.save(review);
        return new ReviewResponse(review);
    }
}
