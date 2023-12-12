package com.example.quotes.controller;

import com.example.quotes.dto.QuoteDTO;
import com.example.quotes.service.QuoteService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/quotes")
public class QuoteController {

    private final QuoteService quoteService;

    @PostMapping
    public QuoteDTO postNewQuote(Authentication auth, @RequestBody String content) {
        return quoteService.createNewQuote(auth, content);
    }

    @PutMapping("/{quoteId}")
    public QuoteDTO putNewContentOnQuote(@PathVariable Long quoteId, @RequestBody String content) {
        return quoteService.updateQuote(quoteId, content);
    }

    @DeleteMapping("/{quoteId}")
    public String deleteQuote(@PathVariable Long quoteId) {
        try {
            quoteService.deleteQuote(quoteId);
            return String.format("Quote %d successfully deleted", quoteId);
        } catch (Exception e) {
            return String.format("There is an error on deleting process: %s", e.getMessage());
        }
    }

    @PutMapping("/{quoteId}/like")
    public QuoteDTO putNewLikeOnQuote(@PathVariable Long quoteId, Authentication auth) {
        return quoteService.updateQuoteAddVote(quoteId, true, auth);
    }

    @PutMapping("/{quoteId}/dislike")
    public QuoteDTO putNewDislikeOnQuote(@PathVariable Long quoteId, Authentication auth) {
        return quoteService.updateQuoteAddVote(quoteId, false, auth);
    }

    @GetMapping("/random")
    public QuoteDTO getRandomQuote() {
        return quoteService.readRandomQuote();
    }

    @GetMapping("/best")
    public List<QuoteDTO> getBest10() {
        return quoteService.readBest10();
    }

    @GetMapping("/worst")
    public List<QuoteDTO> getWorst10() {
        return quoteService.readWorst10();
    }

    @GetMapping("/{quoteId}")
    public QuoteDTO getQuote(@PathVariable Long quoteId) {
        return quoteService.readQuote(quoteId);
    }
}
