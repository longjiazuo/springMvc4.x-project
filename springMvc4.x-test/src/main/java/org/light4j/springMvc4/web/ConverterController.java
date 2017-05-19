package org.light4j.springMvc4.web;

import org.light4j.springMvc4.domain.DemoObj;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ConverterController {
	
	@RequestMapping(value = "/convert", produces = { "application/x-longjiazuo" }) //①
    public @ResponseBody DemoObj convert(@RequestBody DemoObj demoObj) {
		
        return demoObj;
    }
}
