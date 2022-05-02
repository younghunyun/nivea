package kr.bespinlab.nivea.service;

import kr.bespinlab.nivea.comm.BaseException;
import kr.bespinlab.nivea.comm.BaseResponseCode;
import kr.bespinlab.nivea.domain.Celeb;
import kr.bespinlab.nivea.parameter.CelebPageParam;
import kr.bespinlab.nivea.parameter.CelebUpdateParam;
import kr.bespinlab.nivea.parameter.CelebSearchParam;
import kr.bespinlab.nivea.repository.CelebRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class CelebService {

	@Autowired
	private CelebRepository repository;

	public int register(CelebUpdateParam param) {
		if (param.getBirthDate().isEmpty()) {
			param.setBirthDate(null);
		}
		return repository.save(param);
	}

	public List<Celeb> search(CelebPageParam<CelebSearchParam> celebPageParam) {
		return repository.search(celebPageParam);
	}

	public int count(CelebSearchParam celebSearchParam) {
		return repository.count(celebSearchParam);
	}

	public Optional<Celeb> findBySeq(int celebSeq) {
		return repository.findBySeq(celebSeq);
	}

	public Optional<Celeb> findByStageName(String stageName) {
		return repository.findByStageName(stageName);
	}

	public Optional<Celeb> findByRealName(String realName) {
		return repository.findByRealName(realName);
	}

	public int update(CelebUpdateParam param) {
		if (param.getBirthDate().isEmpty()) {
			param.setBirthDate(null);
		}
		return repository.update(param);
	}

	public boolean delete(int celebSeq) {
		repository.delete(celebSeq);
		return true;
	}

}
