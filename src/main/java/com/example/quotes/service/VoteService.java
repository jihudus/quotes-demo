package com.example.quotes.service;

import com.example.quotes.entity.Member;
import com.example.quotes.entity.Quote;
import com.example.quotes.entity.Vote;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

public interface VoteService {

    Vote createNewVote(Quote quote, Member member, Boolean positive);

    Map<LocalDate, List<Integer>> readVotesGraph(Long quoteId);
}
