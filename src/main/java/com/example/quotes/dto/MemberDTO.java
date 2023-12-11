package com.example.quotes.dto;

import com.example.quotes.entity.Member;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
public class MemberDTO {

    private Long id;

    private String email;

    private String name;

    private List<QuoteDTO> quotes;

    private LocalDateTime created;

    public static MemberDTO fromMember(Member member) {
        List<QuoteDTO> quoteDTOs = member.getQuotes().stream().map(QuoteDTO::fromQuote).toList();
        return builder()
                .id(member.getId())
                .name(member.getName())
                .email(member.getEmail())
                .quotes(quoteDTOs)
                .created(member.getCreationTime())
                .build();
    }

}
