package kr.co.sboard.vo;

import java.time.LocalDateTime;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
public class ArticleVO {
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
	private LocalDateTime rdate;
}
