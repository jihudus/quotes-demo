package com.example.quotes.service;

import com.example.quotes.dto.QuoteDTO;
import org.springframework.security.core.Authentication;

import java.util.List;

public interface QuoteService {

    QuoteDTO createNewQuote(Authentication auth, String content);

    QuoteDTO updateQuote(Long quoteId, String content);

    void deleteQuote(Long quoteId);

    QuoteDTO updateQuoteAddVote(Long quoteId, Boolean positive, Authentication auth);

    QuoteDTO readRandomQuote();

    List<QuoteDTO> readBest10();

    List<QuoteDTO> readWorst10();

    QuoteDTO readQuote(Long quoteId);
}
