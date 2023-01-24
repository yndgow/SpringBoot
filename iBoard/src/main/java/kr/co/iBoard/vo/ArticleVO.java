package kr.co.iBoard.vo;


import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class ArticleVO {
    private int no;
    private int parent;
    private int comment;
    private String title;
    private String content;
    private int file;
    private int hit;
    private String uid;
    private String regip;
    private String rdate;
}
