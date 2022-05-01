package com.sts;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller


public class TestCintroller {
	@ResponseBody
	@RequestMapping("/test")
	public String firstHandler() {
		return "hello again";
	}
}
