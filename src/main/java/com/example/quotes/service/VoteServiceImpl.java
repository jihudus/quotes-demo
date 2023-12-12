package com.example.quotes.service;

import com.example.quotes.entity.Member;
import com.example.quotes.entity.Quote;
import com.example.quotes.entity.Vote;
import com.example.quotes.repo.VoteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;

@Service
@RequiredArgsConstructor
public class VoteServiceImpl implements VoteService {

    private final VoteRepository voteRepository;

    @Override
    public Vote createNewVote(Quote quote, Member member, Boolean positive) {
        return Vote.builder()
                .creationTime(LocalDateTime.now())
                .quote(quote)
                .owner(member)
                .evaluation(Boolean.TRUE.equals(positive) ? Vote.Evaluation.POSITIVE : Vote.Evaluation.NEGATIVE)
                .build();
    }

    @Transactional
    @Override
    public Map<LocalDate, List<Integer>> readVotesGraph(Long quoteId) {
        List<Vote> votes = voteRepository.findByQuote_IdAllIgnoreCaseOrderByCreationTimeAsc(quoteId);
        Map<LocalDate, List<Integer>> history = new LinkedHashMap<>();
        for (Vote vote : votes) {
            LocalDate localDate = vote.getCreationTime().toLocalDate();
            int increment = vote.getEvaluation() == Vote.Evaluation.POSITIVE ? 0 : 1;
            List<Integer> likes = history.getOrDefault(localDate, Arrays.asList(0, 0));
            likes.set(increment, likes.get(increment)+1);
            history.put(localDate, likes);
        }
        return history;
    }
}
