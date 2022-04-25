package kr.bespinlab.nivea.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Slf4j
@Controller
public class IndexController {

	@GetMapping("/")
	public String index(Model model) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss.SSS");
		model.addAttribute("serviceTime", LocalDateTime.now().format(formatter));
		return "index";
	}

}
