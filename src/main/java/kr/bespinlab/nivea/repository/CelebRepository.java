package kr.bespinlab.nivea.repository;

import kr.bespinlab.nivea.domain.Celeb;
import kr.bespinlab.nivea.parameter.CelebSearchRequest;
import kr.bespinlab.nivea.parameter.CelebSearchParameter;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CelebRepository {
	Celeb save(Celeb celeb);
	Optional<Celeb> findById(Long celebId);
	Optional<Celeb> findByStageName(String stageName);
	Optional<Celeb> findByRealName(String realName);
	Optional<Celeb> findByName(String stageName, String realName);
	List<Celeb> search(CelebSearchParameter<CelebSearchRequest> celebSearchParameter);
}
