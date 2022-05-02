package kr.bespinlab.nivea.service;

import kr.bespinlab.nivea.comm.BaseException;
import kr.bespinlab.nivea.comm.BaseResponseCode;
import kr.bespinlab.nivea.config.PropertyConfiguration;
import kr.bespinlab.nivea.domain.Image;
import kr.bespinlab.nivea.parameter.ImageUpdateParam;
import kr.bespinlab.nivea.parameter.ThumbnailUpdateParam;
import kr.bespinlab.nivea.repository.ImageRepository;
import lombok.extern.slf4j.Slf4j;
import net.coobird.thumbnailator.Thumbnails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;

@Slf4j
@Service
public class ImageService {

	@Autowired
	private PropertyConfiguration props;

	@Autowired
	private ImageRepository repository;

	public boolean saveImages(String refId, MultipartFile[] multipartFiles) {
		boolean result = true;

		String thumbnailFileEnabled = props.getThumbnailFileEnabled();
		boolean isMakeThumbnail = thumbnailFileEnabled.equalsIgnoreCase("true");

		for(MultipartFile multipartFile: multipartFiles) {
			if (saveImage(refId, multipartFile, isMakeThumbnail) != 1) {
				throw new BaseException(BaseResponseCode.FAIL, new String[]{"업로드 실패"});
			}
		}

		return result;
	}

	private int saveImage(String refId, MultipartFile multipartFile, boolean isMakeThumbnail) {
		//String currentDate = new SimpleDateFormat("yyyyMMdd").format(Calendar.getInstance().getTime());
		String currentYyyyMm = new SimpleDateFormat("yyyyMM").format(Calendar.getInstance().getTime());

		// (local) uploadFile.prefix = nivea_<TimeMillis>
		String newFilenamePrefix = props.getUploadFilePrefix() + System.currentTimeMillis() + "_";
		// (local) uploadFile.serverPath = C:/works/spring/nivea/data/
		String uploadPath = props.getUploadServerPath() + "celeb_images/" + currentYyyyMm + "/";
		// (local) uploadFile.resourcePath = /upload/
		String resourcePath = props.getUploadResourcePath() +  "celeb_images/" + currentYyyyMm + "/";

		// 업로드 폴더가 없는 경우 생성
		File uploadFolder = new File(uploadPath);
		if (!uploadFolder.isDirectory()) {
			uploadFolder.mkdirs();
		}

		String newFilename = newFilenamePrefix + multipartFile.getOriginalFilename();
//		String uploadPathFilename = uploadPath + newFilename;
//		String resourcePathFilename = resourcePath + newFilename;

		File uploadFile = new File(uploadPath + newFilename);

		try {
			multipartFile.transferTo(uploadFile);

			ImageUpdateParam param = new ImageUpdateParam();
			// 레퍼런스 ID
			param.setRefId(refId);
			// 원본 파일이름
			param.setOriginalFilename(multipartFile.getOriginalFilename());
			// 업로드 파일이름: 유니크한 이름
			param.setUploadFilename(newFilename);
			// 업로드 경로와 파일이름
			param.setUploadPath(uploadPath);
			// 리소스 경로와 파일이름
			param.setResourcePath(resourcePath);
			// 파일 크기 - 바이트
			param.setSizeByte((int)multipartFile.getSize());
			// 컨텐츠 종류
			param.setContentType(multipartFile.getContentType());

			int countSaveRow = repository.save(param);
			if (countSaveRow == 1 && isMakeThumbnail) {
				Image uploadImage = findByFileSeq(param.getFileSeq());
				boolean result = makeThumbnail(uploadImage, "0");
				if (!result) {
					log.debug("thumbnail creation fail | image file: {}", newFilename);
				}
			}

			return countSaveRow;

		} catch (IOException e) {
			e.printStackTrace();
			return 0;
		}
	}

	public List<Image> getList(String refId) {
		return repository.getList(refId);
	}

	public Image findByFileSeq(int fileSeq) {
		return repository.findByFileSeq(fileSeq);
	}

	public int updateThumbnail(ThumbnailUpdateParam thumbnailParam) {
		return repository.updateThumbnail(thumbnailParam);
	}

	public boolean deleteImage(int fileSeq) {
		int countImages = repository.count(fileSeq);

		if (countImages != 1) {
			return false;
		} else {
			repository.delete(fileSeq);
			return true;
		}
	}

	public boolean makeThumbnail(Image uploadImage, String size) {
		int thumbnailSize =64;
		if (size != null && size.matches("[+-]?\\d*(\\.\\d+)?")) {
			thumbnailSize = (Integer.parseInt(size) <= 64) ? 64 : Integer.parseInt(size);
		}

		String imageFilePath = uploadImage.getUploadPath();
		String imageFilename = uploadImage.getUploadFilename();

		String currentYyyyMm = new SimpleDateFormat("yyyyMM").format(Calendar.getInstance().getTime());
		String thumbnailFilePath = props.getUploadServerPath() + "celeb_thumbnails/" + currentYyyyMm + "/";
		int indexExt = imageFilename.lastIndexOf(".");
		String thumbnailFilename = imageFilename.substring(0, indexExt)+"_"+thumbnailSize+"x"+thumbnailSize;
		thumbnailFilename = thumbnailFilename.replace(".", "_");

		File thumbnailFolder = new File(thumbnailFilePath);
		if (!thumbnailFolder.isDirectory()) {
			thumbnailFolder.mkdirs();
		}

		File imageFile = new File(imageFilePath+imageFilename);
		if (!imageFile.isFile()) {
			throw new BaseException(BaseResponseCode.NO_FILE, new String[]{"이미지 파일 SEQ="+uploadImage.getFileSeq()});
		}

		try {
			File thumbnailFile = new File(thumbnailFilePath+thumbnailFilename);
			if (!thumbnailFile.isFile()) {
				Thumbnails.of(imageFilePath+imageFilename)
						.size(thumbnailSize, thumbnailSize)
						.toFile(thumbnailFilePath+thumbnailFilename);
			}

			log.debug("Thumbnail created: {}", thumbnailFilePath+thumbnailFilename);

			String thumbnailFilenameWithExt = "";
			if (imageFilename.toLowerCase().endsWith("png")) {
				thumbnailFilenameWithExt = thumbnailFilename + ".png";
			} else {
				thumbnailFilenameWithExt = thumbnailFilename + ".JPEG";
			}

			ThumbnailUpdateParam thumbnailParam = new ThumbnailUpdateParam();
			thumbnailParam.setFileSeq(uploadImage.getFileSeq());
			thumbnailParam.setThumbnailFilename(thumbnailFilenameWithExt);
			thumbnailParam.setThumbnailPath(thumbnailFilePath);
			int countUpdateRow = updateThumbnail(thumbnailParam);
			if (countUpdateRow != 1) {
				throw new BaseException(BaseResponseCode.FAIL, new String[]{"썸네일 업데이트 오류"});
			}

		} catch (IOException e) {
			e.printStackTrace();
			throw new BaseException(BaseResponseCode.FAIL, new String[]{"썸네일 변환처리 오류"});
		}

		return true;
	}
}
