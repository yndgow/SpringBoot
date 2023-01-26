package kr.co.farmstory.vo;

import lombok.Getter;

import java.time.LocalDateTime;
import java.util.Objects;

@Getter
public class ArticleVO {
    private int no;
    private int parent;
    private int comment;
    private String cate;
    private String title;
    private String content;
    private int file;
    private int hit;
    private String uid;
    private String regip;
    private LocalDateTime rdate;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ArticleVO articleVO = (ArticleVO) o;
        return no == articleVO.no && parent == articleVO.parent && comment == articleVO.comment && file == articleVO.file && hit == articleVO.hit && Objects.equals(cate, articleVO.cate) && Objects.equals(title, articleVO.title) && Objects.equals(content, articleVO.content) && Objects.equals(uid, articleVO.uid) && Objects.equals(regip, articleVO.regip) && Objects.equals(rdate, articleVO.rdate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(no, parent, comment, cate, title, content, file, hit, uid, regip, rdate);
    }
}
