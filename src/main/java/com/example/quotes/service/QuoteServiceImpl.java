package com.example.quotes.service;

import com.example.quotes.dto.QuoteDTO;
import com.example.quotes.entity.Member;
import com.example.quotes.entity.Quote;
import com.example.quotes.entity.Vote;
import com.example.quotes.repo.QuoteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class QuoteServiceImpl implements QuoteService {

    private final QuoteRepository quoteRepository;

    private final MemberService memberService;

    private final VoteService voteService;

    @Transactional
    @Override
    public QuoteDTO createNewQuote(Authentication auth, String content) {
        Member author = memberService.readMemberByEmail(auth.getName());
        Quote quote = Quote.builder()
                .member(author)
                .content(content)
                .build();
        Quote saved = quoteRepository.save(quote);
        return QuoteDTO.fromQuote(saved);
    }

    @Transactional
    @Override
    public QuoteDTO updateQuote(Long quoteId, String content) {
        Quote quote = quoteRepository.findById(quoteId).orElseThrow();
        quote.setContent(content);
        quote.setModified(LocalDateTime.now());
        return QuoteDTO.fromQuote(quoteRepository.save(quote));
    }

    @Transactional
    @Override
    public void deleteQuote(Long quoteId) {
        quoteRepository.deleteById(quoteId);
    }

    @Transactional
    @Override
    public QuoteDTO updateQuoteAddVote(Long quoteId, Boolean positive, Authentication auth) {
        Quote quote = quoteRepository.findById(quoteId).orElseThrow();
        Member member = memberService.readMemberByEmail(auth.getName());
        Vote vote = voteService.createNewVote(quote, member, positive);
        quote.getVotes().add(vote);
        return QuoteDTO.fromQuote(quoteRepository.save(quote));
    }

    @Transactional
    @Override
    public QuoteDTO readRandomQuote() {
        Quote quote = quoteRepository.selectRandomQuote().orElseThrow();
        return QuoteDTO.fromQuote(quote);
    }

    @Transactional
    @Override
    public List<QuoteDTO> readBest10() {
        return quoteRepository.selectBest()
                .stream()
                .map(QuoteDTO::fromQuote)
                .toList();
    }

    @Transactional
    @Override
    public List<QuoteDTO> readWorst10() {
        return quoteRepository.selectWorst()
                .stream()
                .map(QuoteDTO::fromQuote)
                .toList();
    }

    @Transactional
    @Override
    public QuoteDTO readQuote(Long quoteId) {
        return QuoteDTO.fromQuote(quoteRepository.getReferenceById(quoteId));
    }
}
