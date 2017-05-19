package org.light4j.springMvc4.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
// ①
public class HelloController {

	@RequestMapping("/index")
	// ②
	public String hello() {

		return "index";
	}
}
