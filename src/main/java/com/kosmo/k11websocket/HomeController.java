package com.kosmo.k11websocket;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {
	
	
	@RequestMapping(value = "/Notification/01WebNot1.do", method = RequestMethod.GET)
	public String webNoti() {
		
		return "02Notification/01WebNoti";
	}
	
}
