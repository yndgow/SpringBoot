package kr.co.ch09.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;


@Data
@Table(name = "user3")
@Entity
public class User3 {

	@Id
	private String uid;
	private String name;
	private String hp;
	private int age;
}
