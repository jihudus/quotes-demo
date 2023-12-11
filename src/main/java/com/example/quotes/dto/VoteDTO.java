package com.example.quotes.dto;

import com.example.quotes.entity.Vote;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class VoteDTO {

    private Vote.Evaluation evaluation;

    private LocalDateTime time;

    public static VoteDTO fromVote(Vote vote) {
        return builder()
                .evaluation(vote.getEvaluation())
                .time(vote.getCreationTime())
                .build();
    }
}
