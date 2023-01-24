package kr.co.iBoard.repository;

import kr.co.iBoard.entity.ArticleEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleRepo extends JpaRepository<ArticleEntity, String> {
}
