package kr.co.farmstory.mapper;

import kr.co.farmstory.dto.ArticleDTO;
import kr.co.farmstory.entity.ArticleEntity;

public class ArticleMapper {
    public static ArticleDTO toDto(ArticleEntity entity){
        return new ArticleDTO(entity.getNo(), entity.getParent(), entity.getComment(), entity.getCate(), entity.getTitle(), entity.getContent(), entity.getFile(), entity.getHit(), entity.getRegip(), entity.getRdate());
    }
}
