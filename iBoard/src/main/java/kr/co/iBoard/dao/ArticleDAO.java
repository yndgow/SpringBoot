package kr.co.iBoard.dao;

import kr.co.iBoard.entity.ArticleEntity;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
@Mapper
@Repository
public interface ArticleDAO {

    public List<ArticleEntity> selectList();
    public ArticleEntity selectArticle(int no);
    public void insertArticle(ArticleEntity article);
    public void updateArticle(ArticleEntity article);
    public void deleteArticle(int no);
}
