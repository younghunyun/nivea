package kr.bespinlab.nivea.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import kr.bespinlab.nivea.comm.BaseException;
import kr.bespinlab.nivea.comm.BaseResponse;
import kr.bespinlab.nivea.comm.BaseResponseCode;
import kr.bespinlab.nivea.domain.Image;
import kr.bespinlab.nivea.service.ImageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Slf4j
@Controller
@Api(value = "이미지 파일 APIs")
@RequestMapping("/image")
public class ImageController {

    @Autowired
    private ImageService imageService;

    @PostMapping("/save/{refId}")
    @ResponseBody
    public BaseResponse<Boolean> save(
            @PathVariable("refId") String refId, @RequestParam("uploadFiles") MultipartFile[] multipartFiles) {
        log.debug(">>>> refId: {}", refId);
        log.debug(">>>> multipartFile: {}", multipartFiles);

        // 파일이 NULL인 경우 오류 메시지 리턴
        if (multipartFiles == null || multipartFiles.length == 0) {
            throw new BaseException(BaseResponseCode.NO_FILE, new String[]{"이미지 파일"});
        }

        boolean result = imageService.saveImages(refId, multipartFiles);

        return new BaseResponse<Boolean>(result);
    }

    @ApiOperation(value = "셀럽 검색", notes = "셀럽 목록 조회")
    @GetMapping("/list/json")
    @ResponseBody
    public List<Image> searchJson(@RequestParam("refId") String refId) {
        //log.debug(">>>> ImageFileController | searchJson | refId: {}", refId);
        List<Image> imageList = imageService.getList(refId);
        log.debug(">>>> ImageFileController | searchJson | imageList: {}", imageList.size());
        return imageList;
    }

    @DeleteMapping("/delete/{fileSeq}")
    @ResponseBody
    public BaseResponse<Boolean> delete(@PathVariable("fileSeq") int fileSeq){
        log.debug(">>>> ImageFileController | delete | fileSeq: {}", fileSeq);

        boolean result = imageService.deleteImage(fileSeq);

        return new BaseResponse<Boolean>(result);
    }

    @GetMapping("/thumbnail/make/{fileSeq}")
    @ResponseBody
    public BaseResponse<Boolean> makeThumbnail(
            @PathVariable int fileSeq
            , @RequestParam(required = false) String size
            , HttpServletResponse response) {

        Image uploadImage = imageService.findByFileSeq(fileSeq);

        if (uploadImage == null) {
            throw new BaseException(BaseResponseCode.NO_FILE, new String[]{"이미지 파일 SEQ="+fileSeq});
        } else {
            boolean result = imageService.makeThumbnail(uploadImage, size);
            return new BaseResponse<Boolean>(result);
        }
    }

}


