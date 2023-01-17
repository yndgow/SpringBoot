package kr.co.ch09.vo;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@Service
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class BookVO {
	private String title;
	private String link;
	private String image;
	private String author;
	private String discount;
	private String publisher;
	private String pubdate;
	private String isbn;
	private String description; 
}
