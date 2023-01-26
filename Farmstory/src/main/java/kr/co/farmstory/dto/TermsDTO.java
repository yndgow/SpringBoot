package kr.co.farmstory.dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class TermsDTO {
    private String terms;
    private String privacy;
}

