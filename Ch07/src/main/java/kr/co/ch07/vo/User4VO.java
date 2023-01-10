package kr.co.ch07.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class User4VO {
	private int seq;
	private String name;
	private int gender;
	private int age;
	private String addr;
}
