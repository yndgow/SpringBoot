package kr.co.farmstory.service;

import kr.co.farmstory.DAO.TermsDAO;
import kr.co.farmstory.dto.TermsDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TermsService {

    private final TermsDAO dao;

    public TermsService(TermsDAO dao) {
        this.dao = dao;
    }

    public TermsDTO selectTerms(){
        return dao.selectTerms();
    }
}
