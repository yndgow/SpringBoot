package kr.co.voard.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import kr.co.voard.entity.ArticleEntity;

public interface ArticleRepo extends JpaRepository<ArticleEntity, Integer>{

}
