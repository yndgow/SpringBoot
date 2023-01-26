package kr.co.farmstory.service;

import kr.co.farmstory.entity.TermsEntity;
import kr.co.farmstory.repo.TermsRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TermsService {
    private final TermsRepository repo;

    public TermsService(TermsRepository repo){
        this.repo = repo;
    }

    public List<TermsEntity> selectTerms(){
        return repo.findAll();
    }
}
