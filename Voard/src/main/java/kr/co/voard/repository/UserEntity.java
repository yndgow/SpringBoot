package kr.co.voard.repository;

import java.time.LocalDateTime;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "board_user")
@EntityListeners(AuditingEntityListener.class)
public class UserEntity {
	
	@Id
	private String uid;
	private String pass;
	private String name;
	private String nick;
	private String email;
	private String hp;
	private int grade;
	private String zip;
	private String addr1;
	private String addr2;
	private String regip;
	@CreatedDate
	private LocalDateTime rdate;
	private LocalDateTime wdate;
}
