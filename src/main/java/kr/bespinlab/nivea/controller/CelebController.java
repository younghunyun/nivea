package kr.bespinlab.nivea.controller;

import io.swagger.annotations.*;
import kr.bespinlab.nivea.domain.Celeb;
import kr.bespinlab.nivea.parameter.CelebPageParam;
import kr.bespinlab.nivea.parameter.CelebSearchParam;
import kr.bespinlab.nivea.parameter.MySqlPageNavParam;
import kr.bespinlab.nivea.parameter.MySqlPageRequest;
import kr.bespinlab.nivea.service.CelebService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Slf4j
@Controller
@Api(value = "셀럽 APIs")
@RequestMapping("/celeb")
public class CelebController {

	@Autowired
	private CelebService celebService;

	@GetMapping({"", "/list"})
	public String search(MySqlPageRequest pageRequest, CelebSearchParam searchParam, Model model) {
		List<Celeb> celebList = searchJson(pageRequest, searchParam);
		model.addAttribute("celebList", celebList);

		int totalContents = countJson(searchParam);
		MySqlPageNavParam pageNavParam = new MySqlPageNavParam(pageRequest.getPage(), pageRequest.getSize(), totalContents);
		model.addAttribute("pageNavParam", pageNavParam);
		return "/celeb/list";
	}

	@ApiOperation(value = "셀럽 검색", notes = "셀럽 목록 조회")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "page", value = "조회할 페이지 값", example = "1", dataType = "int"),
			@ApiImplicitParam(name = "size", value = "페이지에 포함될 데이터 수", example = "10", dataType = "int"),
			@ApiImplicitParam(name = "field", value = "검색조건 필드", example = "stage_name", defaultValue = "stage_name"),
			@ApiImplicitParam(name = "keyword", value = "검색조건 값",  example = "권나라"),
	})
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
	@ApiImplicitParams({
			@ApiImplicitParam(name = "field", value = "검색조건 필드", defaultValue = "stage_name"),
			@ApiImplicitParam(name = "keyword", value = "검색조건 값",  example = "권나라"),
	})
	@GetMapping("/count/json")
	@ResponseBody
	public int countJson(CelebSearchParam celebSearchParam) {
		log.debug("celebSearchParam: {}", celebSearchParam);

		int totalContents = celebService.count(celebSearchParam);
		return totalContents;
	}
}
