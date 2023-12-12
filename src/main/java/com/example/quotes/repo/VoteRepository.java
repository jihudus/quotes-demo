package com.example.quotes.repo;

import com.example.quotes.entity.Vote;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VoteRepository extends JpaRepository<Vote, Long> {

    List<Vote> findByQuote_IdAllIgnoreCaseOrderByCreationTimeAsc(Long id);
}