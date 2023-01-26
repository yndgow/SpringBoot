package kr.co.farmstory.DAO;

import kr.co.farmstory.dto.TermsDTO;
import kr.co.farmstory.vo.TermsVO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface TermsDAO {
    public TermsDTO selectTerms();
}
