package kr.bespinlab.nivea.service;

import kr.bespinlab.nivea.config.PropertyConfiguration;
import kr.bespinlab.nivea.domain.Image;
import kr.bespinlab.nivea.parameter.ImageUpdateParam;
import kr.bespinlab.nivea.repository.ImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.UUID;

@Service
public class ImageService {

	@Autowired
	private PropertyConfiguration props;

	@Autowired
	private ImageRepository repository;

	public boolean saveImages(String refId, MultipartFile[] multipartFiles) {
		boolean result = true;

		for(MultipartFile multipartFile: multipartFiles) {
			if (saveImage(refId, multipartFile) != 1) {
				result = false;
			}
		}

		return result;
	}

	public int saveImage(String refId, MultipartFile multipartFile) {
		String currentDate = new SimpleDateFormat("yyyyMMdd").format(Calendar.getInstance().getTime());

		// (local) uploadFile.prefix = nivea_
		String newFilenamePrefix = props.getUploadFilePrefix() + UUID.randomUUID() + "_";
		// (local) uploadFile.serverPath = C:/works/spring/nivea/data/
		String uploadPath = props.getUploadServerPath() + "celeb/" + currentDate + "/";
		// (local) uploadFile.resourcePath = /upload/
		String resourcePath = props.getUploadResourcePath() +  "celeb/" + currentDate + "/";

		// 업로드 폴더가 없는 경우 생성
		File uploadFolder = new File(uploadPath);
		if (!uploadFolder.isDirectory()) {
			uploadFolder.mkdirs();
		}

		String newFilename = newFilenamePrefix + multipartFile.getOriginalFilename();
		String uploadPathFilename = uploadPath + newFilename;
		String resourcePathFilename = resourcePath + newFilename;

		File uploadFile = new File(uploadPathFilename);

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
			param.setUploadPathFilename(uploadPathFilename);
			// 리소스 경로와 파일이름
			param.setResourcePathFilename(resourcePathFilename);
			// 파일 크기 - 바이트
			param.setSizeByte((int)multipartFile.getSize());
			// 컨텐츠 종류
			param.setContentType(multipartFile.getContentType());

			return repository.save(param);

		} catch (IOException e) {
			e.printStackTrace();
			return 0;
		}
	}

	public List<Image> getList(String refId) {
		return repository.getList(refId);
	}
}
