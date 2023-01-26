package kr.co.farmstory.service;

import kr.co.farmstory.entity.ArticleEntity;
import kr.co.farmstory.repo.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleService {
    private final ArticleRepository repo;

    public ArticleService(ArticleRepository repo) {
        this.repo = repo;
    }

    public List<ArticleEntity> boardList(String cate, Pageable pageable){

//        return repo.findByCateOrderByNoDesc(cate, Pageable.ofSize(10));
        return repo.findCustom(cate, pageable);
    }

}
