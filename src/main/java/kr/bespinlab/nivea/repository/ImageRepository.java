package kr.bespinlab.nivea.repository;

import kr.bespinlab.nivea.domain.Image;
import kr.bespinlab.nivea.parameter.ImageUpdateParam;
import kr.bespinlab.nivea.parameter.ThumbnailUpdateParam;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ImageRepository {
	int save(ImageUpdateParam param);
	List<Image> getList(String refId);
	int count(int fileSeq);
	Image findByFileSeq(int fileSeq);
	int updateThumbnail(ThumbnailUpdateParam thumbnailParam);
	void delete(int fileSeq);
}
