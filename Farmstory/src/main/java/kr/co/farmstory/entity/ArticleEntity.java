package kr.co.farmstory.entity;


import kr.co.farmstory.dto.ArticleDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "board_article")
public class ArticleEntity {

    @Id
    private int no;
    private int parent;
    private int comment;
    private String cate;
    private String title;
    private String content;
    private int file;
    private String fname;
    private int hit;
    private String regip;
    private LocalDateTime rdate;

    @ManyToOne(targetEntity = UserEntity.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "uid")
    private UserEntity user;

    public ArticleEntity(ArticleDTO dto) {
        this.no = dto.getNo();
        this.parent = dto.getParent();
        this.comment = dto.getComment();
        this.cate = dto.getCate();
        this.title = dto.getTitle();
        this.content = dto.getContent();
        this.file = dto.getFile();
        this.fname = dto.getFname();
        this.hit = dto.getHit();
        this.regip = dto.getRegip();
        this.rdate = dto.getRdate();
    }
}