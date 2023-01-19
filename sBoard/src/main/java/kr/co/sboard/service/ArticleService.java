package kr.co.sboard.service;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import kr.co.sboard.dao.ArticleDAO;
import kr.co.sboard.vo.ArticleVO;
import kr.co.sboard.vo.FileVO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class ArticleService{

	@Autowired
	private ArticleDAO dao;
	
	public int insertArticle(ArticleVO vo) {
		
		int result = 0;
		MultipartFile file = vo.getFname();
		log.info(file.getOriginalFilename());
		
		if(file.isEmpty()) {
			// 파일 첨부 n
			log.info("here1");
			
			vo.setFile(0);
			result = dao.insertArticle(vo);
			
			
		}else {
			// 파일 첨부 y
			
			log.info("here2");
			vo.setFile(1);
			// DB 글 insert
			result = dao.insertArticle(vo);
			
			// DB 파일 등록
			FileVO fvo = new FileVO();
			fvo.setParent(vo.getNo());
			
			// 파일 업로드
			fileUpload(file, fvo);
			
			dao.insertFile(fvo);
		}
		
		
		
		
		return result;
	}

	public ArticleVO selectArticle(int no) {
		return dao.selectArticle(no);
	}

	public List<ArticleVO> selectArticles() {
		return dao.selectArticles();
	}

	public int updateArticle(ArticleVO vo) {
		return dao.updateArticle(vo);
	}

	public int deleteArticle(int no) {
		return dao.deleteArticle(no);
	}

	// 파일 업로드
	@Value("${spring.servlet.multipart.location}")
	private String uploadPath;
	
	
	public void fileUpload(MultipartFile file, FileVO fvo) {
		String path = new File(uploadPath).getAbsolutePath();
		// 기존 파일 이름 가져오기
		String oName = file.getOriginalFilename();
		// 기존 파일 확장자 가져오기
		String ext = oName.substring(oName.lastIndexOf("."));
		// 새로운 파일 이름
		String nName = UUID.randomUUID().toString() + ext;
		// 파일 저장
		try {
			file.transferTo(new File(path, nName));
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		fvo.setOriName(oName);
		fvo.setNewName(nName);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
