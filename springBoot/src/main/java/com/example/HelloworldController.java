package com.example;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.scheduling.annotation.Scheduled;


/**
 * The class is flagged as a @RestController, meaning it’s ready for use by Spring MVC to handle web requests.
 *
 * @RequestMapping maps / to the index() method. When invoked from a browser or using curl on the command line,
 * the method returns pure text. That’s because @RestController combines @Controller and @ResponseBody,
 * two annotations that results in web requests returning data rather than a view.
 */
@RestController
public class HelloworldController {

	private static final Logger log = LoggerFactory.getLogger(HelloworldController.class);
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");


    @RequestMapping("/")
    public String hello() {
        return "Greetings from Spring Boot!\n\n";
    }

    @Scheduled(fixedRate = 5000)
    public void reportCurrentTime() {
        log.info("This is an info message: The time is now {}", dateFormat.format(new Date()));
        log.warn("This is an warn message: The time is now {}", dateFormat.format(new Date()));
        log.error("This is an error message: The time is now {}", dateFormat.format(new Date()));
    }
}
