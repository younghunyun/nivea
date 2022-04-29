package kr.bespinlab.nivea.repository;

import kr.bespinlab.nivea.domain.Image;
import kr.bespinlab.nivea.parameter.ImageUpdateParam;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ImageRepository {
	int save(ImageUpdateParam param);
	List<Image> getList(String refId);
}
