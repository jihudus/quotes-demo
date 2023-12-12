package com.example.quotes.dto;

import com.example.quotes.entity.Quote;
import com.example.quotes.entity.Vote;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class QuoteDTO {

    private Long id;

    private Long member;

    private Long likes;

    private Long dislikes;

    private String content;

    public static QuoteDTO fromQuote(Quote quote) {
        return builder()
                .id(quote.getId())
                .content(quote.getContent())
                .member(quote.getMember().getId())
                .likes(quote.getVotes().stream().filter(v -> v.getEvaluation().equals(Vote.Evaluation.POSITIVE)).count())
                .dislikes(quote.getVotes().stream().filter(v -> v.getEvaluation().equals(Vote.Evaluation.NEGATIVE)).count())
                .build();
    }
}
