package com.project.sihcalci.response;

import com.project.sihcalci.enums.Category;
import com.project.sihcalci.models.Review;
import com.project.sihcalci.models.Team;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TeamResponse {
    private String id;
    private String teamName;
    private Category category;
    private ReviewResponse reviews;

    public TeamResponse(Team team){
        this.id = team.getTeamId();
        this.category = team.getCategory();
        this.teamName = team.getTeamName();
        for(Review review : team.getReviews()){
            this.reviews = new ReviewResponse(review);
        }
    }
}
