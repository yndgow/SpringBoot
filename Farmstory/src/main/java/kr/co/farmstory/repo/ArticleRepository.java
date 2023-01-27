package kr.co.farmstory.repo;

import kr.co.farmstory.entity.ArticleEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ArticleRepository extends JpaRepository<ArticleEntity, Integer> {

    @Query(value = "SELECT b FROM ArticleEntity b JOIN FETCH b.user WHERE b.cate = ?1",
            countQuery = "select count(b) FROM ArticleEntity b JOIN b.user WHERE b.cate = ?1")
    Page<ArticleEntity> findCustom(String cate, Pageable pageable);

}