package io.mirko.controllers.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Date;
import java.util.Map;

@Controller
public class MainController {
    @GetMapping("/")
    public String mainPage(Map<String, Object> model) {
        System.out.println("Dino************************************");
        model.put("time", new Date());
        model.put("message", "This is a test message");
        return "index";
    }
}
