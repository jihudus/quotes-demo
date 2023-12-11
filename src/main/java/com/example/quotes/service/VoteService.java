package com.example.quotes.service;

import com.example.quotes.entity.Member;
import com.example.quotes.entity.Quote;
import com.example.quotes.entity.Vote;

public interface VoteService {

    Vote createNewVote(Quote quote, Member member, Boolean positive);
}
