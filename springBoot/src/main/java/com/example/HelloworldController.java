package com.example;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.scheduling.annotation.Scheduled;


/**
 * The class is flagged as a @RestController, meaning it’s ready for use by Spring MVC to handle web requests.
 *
 * @RequestMapping maps / to the index() method. When invoked from a browser or using curl on the command line,
 * the method returns pure text. That’s because @RestController combines @Controller and @ResponseBody,
 * two annotations that results in web requests returning data rather than a view.
 */
@Controller
public class HelloworldController {

	private static final Logger log = LoggerFactory.getLogger(HelloworldController.class);
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");


    @RequestMapping("/")
	public String root() {
		return "redirect:/index";
	}

	@RequestMapping("/index")
	public String index() {
		log.info("This is a general page");
		return "index";
	}

	@RequestMapping("/user/index")
	public String userIndex() {
		log.warn("This is a secured page");
		return "user/index";
	}

	@RequestMapping("/login")
	public String login() {
		log.info("This is a the login page");
		return "login";
	}

	@RequestMapping("/login-error")
	public String loginError(Model model) {
		log.error("This is an error message");
		model.addAttribute("loginError", true);
		return "login";
	}
}
