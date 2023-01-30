package kr.co.farmstory.service;

import kr.co.farmstory.entity.ArticleEntity;
import kr.co.farmstory.repo.ArticleRepository;
import kr.co.farmstory.vo.PageVO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class ArticleService {
    private final ArticleRepository repo;

    public ArticleService(ArticleRepository repo) {
        this.repo = repo;
    }

    private final int PAGE_POST_COUNT = 10;

    public Page<ArticleEntity> boardList(String cate, int pg){
        Pageable pageable = PageRequest.of(pg, PAGE_POST_COUNT, Sort.by(Sort.Direction.DESC, "no"));
        return repo.findCustom(cate, pageable);
    }

    public PageVO getPageInfo(Page<ArticleEntity> postPageList, int pg) {
        int totalPage = postPageList.getTotalPages();

        // 현재 페이지를 통해 현재 페이지 그룹의 시작 페이지를 구함
        double v = (Math.floor(pg / PAGE_POST_COUNT) * PAGE_POST_COUNT) + 1;
        int startNumber = (int)(v <= totalPage ? v : totalPage);

        // 전체 페이지 수와 현재 페이지 그룹의 시작 페이지를 통해 현재 페이지 그룹의 마지막 페이지를 구함
        int endNumber = (Math.min(startNumber + PAGE_POST_COUNT - 1, totalPage));
        boolean hasPrev = postPageList.hasPrevious();
        boolean hasNext = postPageList.hasNext();

        /* 화면에는 원래 페이지 인덱스+1 로 출력됨을 주의 */
        int prevIndex = postPageList.previousOrFirstPageable().getPageNumber()+1;
        int nextIndex = postPageList.nextOrLastPageable().getPageNumber()+1;

        long totalCount = postPageList.getTotalElements() - (long) pg * PAGE_POST_COUNT;

        return new PageVO(totalPage, startNumber, endNumber, hasPrev, hasNext, prevIndex, nextIndex, totalCount);
    }

    public ArticleEntity selectArticle(String no){
        return repo.findById(Integer.parseInt(no)).get();
    }

}
