package kr.bespinlab.nivea.repository;

import kr.bespinlab.nivea.domain.Celeb;
import kr.bespinlab.nivea.parameter.CelebSearchParam;
import kr.bespinlab.nivea.parameter.CelebPageParam;
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
	List<Celeb> search(CelebPageParam<CelebSearchParam> celebPageParam);
	int count(CelebSearchParam searchParam);
}
