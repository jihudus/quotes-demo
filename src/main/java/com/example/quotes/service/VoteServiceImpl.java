package com.example.quotes.service;

import com.example.quotes.entity.Member;
import com.example.quotes.entity.Quote;
import com.example.quotes.entity.Vote;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class VoteServiceImpl implements VoteService {

    @Override
    public Vote createNewVote(Quote quote, Member member, Boolean positive) {
        return Vote.builder()
                .creationTime(LocalDateTime.now())
                .quote(quote)
                .owner(member)
                .evaluation(Boolean.TRUE.equals(positive) ? Vote.Evaluation.POSITIVE : Vote.Evaluation.NEGATIVE)
                .build();
    }
}
