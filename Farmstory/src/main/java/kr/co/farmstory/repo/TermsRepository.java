package kr.co.farmstory.repo;

import kr.co.farmstory.entity.TermsEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TermsRepository extends JpaRepository<TermsEntity, String> {
}
