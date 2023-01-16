package kr.co.ch09.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import kr.co.ch09.repository.MemberRepo;
import kr.co.ch09.vo.MemberVO;

@Service
public class MemberService {
	
	@Autowired
	MemberRepo repo;
	
	public List<MemberVO> selectMembers(){
		return repo.findAll();
	}
	
	public MemberVO selectMember(@PathVariable("uid") String uid) {
		return repo.findById(uid).get();
	}
	
	public List<MemberVO> insertMember(MemberVO vo) {
		repo.save(vo);
		return repo.findAll();
	}
	
	public List<MemberVO> updateMember(MemberVO vo){
		repo.save(vo);
		return repo.findAll();
	}
	
	public List<MemberVO> deleteMember(@PathVariable("uid") String uid){
		repo.deleteById(uid);
		return repo.findAll();
	}
	
	
}
