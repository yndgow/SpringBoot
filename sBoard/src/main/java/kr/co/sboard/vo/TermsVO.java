package kr.co.sboard.vo;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity
@Table(name = "board_terms")
public class TermsVO {
	@Id
	private String terms;
	private String privacy;
	
}
