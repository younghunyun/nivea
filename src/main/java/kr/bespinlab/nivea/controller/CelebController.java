package kr.bespinlab.nivea.controller;

import io.swagger.annotations.*;
import kr.bespinlab.nivea.domain.Celeb;
import kr.bespinlab.nivea.parameter.CelebSearchParameter;
import kr.bespinlab.nivea.parameter.MySqlPageRequest;
import kr.bespinlab.nivea.parameter.PageRequestParameter;
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
	public String search(MySqlPageRequest pageRequest, CelebSearchParameter parameter, Model model) {
		log.debug("Request Paging {}", pageRequest);
		List<Celeb> celebList = searchJson(pageRequest, parameter);
		model.addAttribute("celebList", celebList);
		return "/celeb/list";
	}

	@ApiOperation(value = "셀럽 검색", notes = "셀럽 목록 조회")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "page", value = "검색결과 페이지 값", example = "1", dataType = "int"),
			@ApiImplicitParam(name = "size", value = "1개 페이지에 포함될 검색결과 수", example = "10", dataType = "int"),
			@ApiImplicitParam(name = "searchField", value = "검색조건 필드", example = "stage_name", defaultValue = "stage_name"),
			@ApiImplicitParam(name = "searchKeyword", value = "검색조건 값",  example = "권나라"),
	})
	@GetMapping("/list/json")
	@ResponseBody
	public List<Celeb> searchJson(MySqlPageRequest pageRequest, CelebSearchParameter parameter) {
		PageRequestParameter<CelebSearchParameter> pageRequestParameter = new PageRequestParameter<>(pageRequest, parameter);
		List<Celeb> celebList = celebService.search(pageRequestParameter);
		return celebList;
	}
}
