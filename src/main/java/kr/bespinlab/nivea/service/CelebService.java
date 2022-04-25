package kr.bespinlab.nivea.service;

import kr.bespinlab.nivea.domain.Celeb;
import kr.bespinlab.nivea.temp.CelebSearchRequest000;
import kr.bespinlab.nivea.parameter.CelebSearchRequest;
import kr.bespinlab.nivea.parameter.CelebSearchParameter;
import kr.bespinlab.nivea.repository.CelebRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CelebService {

	@Autowired
	private CelebRepository repository;

	public int register(Celeb celeb) {
		// 같은 이름의 셀럽 중복 저장 X
		validateDuplicatedCeleb(celeb, "이미 존재하는 셀럽입니다.");

		repository.save(celeb);
		return celeb.getCelebId();
	}

	private void validateDuplicatedCeleb(Celeb celeb, String errorMessage) {
		Optional<Celeb> result = repository.findByName(celeb.getStageName(), celeb.getRealName());
		if (result.isPresent()) {
			throw new IllegalStateException(errorMessage);
		}
	}

	public Optional<Celeb> findById(Long celebId) {
		return repository.findById(celebId);
	}

	public Optional<Celeb> findByStageName(String stageName) {
		return repository.findByStageName(stageName);
	}

	public Optional<Celeb> findByRealName(String realName) {
		return repository.findByRealName(realName);
	}

	public List<Celeb> search(CelebSearchParameter<CelebSearchRequest> celebSearchParameter) {
		return repository.search(celebSearchParameter);
	}

}
