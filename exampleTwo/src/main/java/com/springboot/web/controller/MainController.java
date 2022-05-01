/**
 * 
 */
package com.springboot.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author 0010IT744
 *
 */
@Controller
public class MainController {
	
	@RequestMapping("/")
	public String home() {
		System.out.print("this is home page") ;
		return "home"; //Return view page name
	}
	
	@RequestMapping("/contact")
	public String contact() {
		System.out.print("this is contact page") ;
		return "contact"; //Return view page name
	}

}
