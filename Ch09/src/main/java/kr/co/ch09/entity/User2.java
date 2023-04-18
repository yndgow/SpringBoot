package kr.co.ch09.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;


@Data
@Table(name = "user2")
@Entity
public class User2 {

	@Id
	private String uid;
	private String pass;
	private String name;
	private String hp;
	private int age;
	private String rdate;
}
