package kr.co.farmstory.entity;


import kr.co.farmstory.dto.ArticleDTO;
import kr.co.farmstory.dto.UserDTO;
import lombok.*;

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
    private int hit;
    private String regip;
    private LocalDateTime rdate;

    @ManyToOne(targetEntity = UserEntity.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "uid")
    private UserEntity user;




}