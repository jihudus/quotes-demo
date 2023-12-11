package com.example.quotes.dto;

import com.example.quotes.entity.Quote;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class QuoteDTO {

    private Long id;

    private Long member;

    private List<VoteDTO> votes;

    private String content;

    public static QuoteDTO fromQuote(Quote quote) {
        return builder()
                .id(quote.getId())
                .content(quote.getContent())
                .member(quote.getMember().getId())
                .votes(quote.getVotes().stream().map(VoteDTO::fromVote).toList())
                .build();
    }
}
