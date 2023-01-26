package kr.co.farmstory.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "board_terms")
public class TermsEntity{
    @Id
    private String terms;
    private String privacy;
}