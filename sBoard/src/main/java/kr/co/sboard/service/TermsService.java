package kr.co.sboard.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.sboard.repository.TermsRepo;
import kr.co.sboard.vo.TermsVO;

@Service
public class TermsService {

	@Autowired
	private TermsRepo repo;
	
	public List<TermsVO> selectTerms() {
		return repo.findAll();
	}
	
}
