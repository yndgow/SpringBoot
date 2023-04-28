package kr.co.voard.entity;


import org.springframework.web.multipart.MultipartFile;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

@Data
//@Entity
//@Table(name = "board_article")
public class ArticleEntity {
	private int no;
	private int parent;
	private int comment;
	private String cate;
	private String title;
	private String content;
	private MultipartFile fname;
	private int file;
	private int hit;
	private String uid;
	private String regip;
	private String rdate;
	
	public String getRdate() {
		return rdate.substring(2,10);
	}
	
	
}
