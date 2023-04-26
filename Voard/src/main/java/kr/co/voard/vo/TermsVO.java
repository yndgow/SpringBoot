package kr.co.voard.vo;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
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
