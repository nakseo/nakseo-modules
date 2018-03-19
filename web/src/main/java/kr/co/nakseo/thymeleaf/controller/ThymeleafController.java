package kr.co.nakseo.thymeleaf.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ThymeleafController {

	@GetMapping("/thymeleaf/index")
	public String thymeleafIndex(Map<String, Object> model) {
		model.put("title", "thymeleaf");
		model.put("message", "thymeleaf index page");
		return "thymeleaf/index";
	}
	
}
