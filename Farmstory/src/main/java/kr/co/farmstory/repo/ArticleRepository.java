package kr.co.farmstory.repo;

import kr.co.farmstory.dto.ArticleDTO;
import kr.co.farmstory.entity.ArticleEntity;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ArticleRepository extends JpaRepository<ArticleEntity, Integer> {

    @Query(value = "SELECT b, b.user.nick FROM ArticleEntity b JOIN FETCH b.user WHERE b.cate = ?1")
    public List<ArticleEntity> findCustom(String cate, Pageable pageable);

}