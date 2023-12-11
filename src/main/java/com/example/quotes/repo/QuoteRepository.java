package com.example.quotes.repo;

import com.example.quotes.entity.Quote;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface QuoteRepository extends JpaRepository<Quote, Long> {

    @Query(nativeQuery = true, value = "SELECT * FROM quote ORDER BY RANDOM() LIMIT 1")
    Optional<Quote> selectRandomQuote();

    @Query(nativeQuery = true,
            value = """
                WITH pos AS (SELECT q.*, count(v.id) cnt FROM quote q 
                    LEFT JOIN vote v 
                    ON q.id = v.quote_id 
                    WHERE evaluation = 'POSITIVE' 
                    GROUP BY q.id), 
                neg AS (SELECT q.*, count(v.id) cnt FROM quote q 
                    LEFT JOIN vote v 
                    ON q.id = v.quote_id 
                    WHERE evaluation = 'NEGATIVE' 
                    GROUP BY q.id) 
                SELECT pos.id, pos.created, pos.modified, pos.member_id, pos.content, 
                    coalesce(pos.cnt, 0) - coalesce(neg.cnt, 0) res 
                    FROM pos LEFT JOIN neg on pos.id = neg.id 
                    UNION ALL 
                    SELECT neg.id, neg.created, neg.modified, neg.member_id, neg.content, pos.cnt - neg.cnt res 
                        FROM pos RIGHT JOIN neg on pos.id = neg.id WHERE pos.id IS NULL 
                    ORDER BY res DESC 
                    LIMIT 10;""")
    List<Quote> selectBest();

    @Query(nativeQuery = true,
            value = """
                WITH pos AS (SELECT q.*, count(v.id) cnt FROM quote q 
                    LEFT JOIN vote v 
                    ON q.id = v.quote_id 
                    WHERE evaluation = 'POSITIVE' 
                    GROUP BY q.id), 
                neg AS (SELECT q.*, count(v.id) cnt FROM quote q 
                    LEFT JOIN vote v 
                    ON q.id = v.quote_id 
                    WHERE evaluation = 'NEGATIVE' 
                    GROUP BY q.id) 
                SELECT pos.id, pos.created, pos.modified, pos.member_id, pos.content, 
                    coalesce(pos.cnt, 0) - coalesce(neg.cnt, 0) res 
                    FROM pos LEFT JOIN neg on pos.id = neg.id 
                    UNION ALL 
                    SELECT neg.id, neg.created, neg.modified, neg.member_id, neg.content, pos.cnt - neg.cnt res 
                        FROM pos RIGHT JOIN neg on pos.id = neg.id WHERE pos.id IS NULL 
                    ORDER BY res ASC 
                    LIMIT 10;""")
    List<Quote> selectWorst();
}