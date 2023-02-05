package kr.co.farmstory.dto;

import kr.co.farmstory.entity.ArticleEntity;
import kr.co.farmstory.entity.UserEntity;
import lombok.*;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class ArticleDTO {

    private int no;
    private int parent;
    private int comment;
    private String cate;
    private String title;
    private String content;
    private int file;
    private String fname;
    private int hit;
    private String uid;
    private String regip;
    private LocalDateTime rdate;

    public ArticleDTO(int no, int parent, int comment, String cate, String title, String content, int file, int hit, String regip, LocalDateTime rdate, String fname) {
        this.no = no;
        this.parent = parent;
        this.comment = comment;
        this.cate = cate;
        this.title = title;
        this.content = content;
        this.file = file;
        this.hit = hit;
        this.regip = regip;
        this.rdate = rdate;
        this.fname = fname;
    }

}
