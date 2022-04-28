package kr.bespinlab.nivea.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import kr.bespinlab.nivea.comm.BaseException;
import kr.bespinlab.nivea.comm.BaseResponse;
import kr.bespinlab.nivea.comm.BaseResponseCode;
import kr.bespinlab.nivea.domain.Celeb;
import kr.bespinlab.nivea.domain.ImageFile;
import kr.bespinlab.nivea.parameter.CelebPageParam;
import kr.bespinlab.nivea.parameter.CelebSearchParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Controller
@Api(value = "이미지 파일 APIs")
@RequestMapping("/image")
public class ImageFileController {

    @PostMapping("/save/{refId}")
    @ApiOperation(value = "이미지 파일 저장", notes = "")
    @ResponseBody
    public BaseResponse<Boolean> save(
            @PathVariable("refId") String refId,
            @RequestParam("imageFile") MultipartFile multipartFile) {
        log.debug("refId: {}", refId);
        log.debug("multipartFile: {}", multipartFile);

        if (multipartFile == null || multipartFile.isEmpty()) {
            throw new BaseException(BaseResponseCode.NO_FILE, new String[]{"업로드 이미지 파일"});
        }

        return new BaseResponse<Boolean>(true);
    }

    @ApiOperation(value = "셀럽 검색", notes = "셀럽 목록 조회")
    @GetMapping("/list/json")
    @ResponseBody
    public List<ImageFile> searchJson(String refId) {
        log.debug(">>>> ImageFileController | searchJson | refId: {}", refId);

//        List<ImageFile> imageFileList = imageFileService.search(refId);

        List<ImageFile> imageFileList = new ArrayList<>();
        ImageFile image1 = new ImageFile();
        image1.setUpload_file_name("https://img3.daumcdn.net/thumb/R658x0.q70/?fname=https://t1.daumcdn.net/news/202201/17/starnews/20220117092036776ccys.jpg");
        imageFileList.add(image1);
        ImageFile image2 = new ImageFile();
        image2.setUpload_file_name("https://img2.daumcdn.net/thumb/R658x0.q70/?fname=https://t1.daumcdn.net/news/202201/09/elle/20220109063045333ecjw.jpg");
        imageFileList.add(image2);

        return imageFileList;
    }
}


