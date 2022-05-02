package kr.bespinlab.nivea.controller;

import io.swagger.annotations.*;
import kr.bespinlab.nivea.comm.BaseException;
import kr.bespinlab.nivea.comm.BaseResponse;
import kr.bespinlab.nivea.comm.BaseResponseCode;
import kr.bespinlab.nivea.domain.Celeb;
import kr.bespinlab.nivea.parameter.*;
import kr.bespinlab.nivea.service.CelebService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import java.util.List;

@Slf4j
@Controller
@Api(value = "셀럽 APIs")
@RequestMapping("/celeb")
public class CelebController {

	@Autowired
	private CelebService celebService;

	@GetMapping("/test")
	public String test() {
		return "/celeb/test";
	}

	@ApiOperation(value = "셀럽 등록", notes = "셀럽 신규 등록")
	@PostMapping("/register/json")
	@ResponseBody
	public BaseResponse<Integer> register(CelebUpdateParam param) {
		log.debug(">>>> CelebController | register | CelebUpdateParam: {}", param);

		// 셀럽코드 유무 체크
		if (param.getCelebCode() == null || param.getCelebCode().isEmpty()) {
			throw new BaseException(BaseResponseCode.NO_REQUIRED_PARAM, new String[]{"celebCode", "셀럽코드"});
		}

		// 활동이름 유무 체크
		if (param.getStageName() == null || param.getStageName().isEmpty()) {
			throw new BaseException(BaseResponseCode.NO_REQUIRED_PARAM, new String[]{"stageName", "활동이름"});
		}

		int updatedRows = 0;
		try {
			updatedRows = celebService.register(param);
		} catch (Exception e){
			throw new BaseException(BaseResponseCode.FAIL, new String[]{e.getMessage()});
		}

		if (updatedRows != 1) {
			throw new BaseException(BaseResponseCode.FAIL);
		} else {
			log.debug(">>>> CelebController | register | Completed, celebSeq: {}", param.getCelebSeq());
			return new BaseResponse<>(param.getCelebSeq());
		}
	}

	@GetMapping({"", "/list"})
	public String search(MySqlPageRequest pageRequest, CelebSearchParam searchParam, Model model) {
		List<Celeb> celebList = searchJson(pageRequest, searchParam);
		model.addAttribute("celebList", celebList);

		int totalContents = countJson(searchParam);
		MySqlPageNavParam pageNavParam = new MySqlPageNavParam(pageRequest.getPage(), pageRequest.getSize(), totalContents);
		model.addAttribute("pageNavParam", pageNavParam);
		model.addAttribute("searchParam", searchParam);
		return "/celeb/list";
	}

	@ApiOperation(value = "셀럽 검색", notes = "셀럽 목록 조회")
	@GetMapping("/list/json")
	@ResponseBody
	public List<Celeb> searchJson(MySqlPageRequest mySqlPageRequest, CelebSearchParam celebSearchParam) {
		log.debug("mySqlPageParam: {}", mySqlPageRequest);
		log.debug("celebSearchParam: {}", celebSearchParam);

		CelebPageParam<CelebSearchParam> celebPageParam = new CelebPageParam<>(mySqlPageRequest, celebSearchParam);
		List<Celeb> celebList = celebService.search(celebPageParam);
		return celebList;
	}

	@ApiOperation(value = "셀럽 수 조회", notes = "셀럽 수 조회")
	@GetMapping("/count/json")
	@ResponseBody
	public int countJson(CelebSearchParam celebSearchParam) {
		log.debug("celebSearchParam: {}", celebSearchParam);

		int totalContents = celebService.count(celebSearchParam);
		return totalContents;
	}

	@ApiOperation(value = "셀럽 변경", notes = "셀럽정보 업데이트")
	@PostMapping("/update/json")
	@ResponseBody
	public BaseResponse<Integer> update(CelebUpdateParam param) {
		log.debug(">>>> CelebController | update | CelebUpdateParam: {}", param);

		int updatedRows = 0;
		try {
			updatedRows = celebService.update(param);
		} catch (Exception e){
			throw new BaseException(BaseResponseCode.FAIL, new String[]{e.getMessage()});
		}

		if (updatedRows != 1) {
			throw new BaseException(BaseResponseCode.FAIL);
		} else {
			log.debug(">>>> CelebController | update | Completed, celebSeq: {}", param.getCelebSeq());
			return new BaseResponse<>(param.getCelebSeq());
		}
	}

	@DeleteMapping("/delete/{celebSeq}")
	@ResponseBody
	public BaseResponse<Boolean> delete(@PathVariable("celebSeq") int celebSeq){
		log.debug(">>>> CelebController | delete | celebSeq: {}", celebSeq);

		try {
			celebService.delete(celebSeq);
			return new BaseResponse<Boolean>(true);

		} catch (Exception e){
			throw new BaseException(BaseResponseCode.FAIL, new String[]{e.getMessage()});

		}
	}

}
