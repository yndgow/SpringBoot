package kr.co.voard.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import kr.co.voard.vo.TermsVO;


public interface TermsRepo extends JpaRepository<TermsVO, String>{

}
