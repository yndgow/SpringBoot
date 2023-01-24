package kr.co.iBoard.service;

import kr.co.iBoard.dao.ArticleDAO;
import kr.co.iBoard.entity.ArticleEntity;
import kr.co.iBoard.repository.ArticleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleService {

    @Autowired
    private ArticleDAO dao;
    @Autowired
    private ArticleRepo repo;

    public List<ArticleEntity> selectArticles() {
        return dao.selectList();
    }

    public ArticleEntity selectArticle(int no) {
        return null;
    }

    public void insertArticle(ArticleEntity article) {

    }

    public void updateArticle(ArticleEntity article) {

    }

    public void deleteArticle(int no) {

    }
}
