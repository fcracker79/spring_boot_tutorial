package io.mirko.controllers.mvc;

import io.mirko.model.SpaturnoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Date;
import java.util.Map;

@Controller
public class MainController {
    @Autowired
    private SpaturnoRepository spaturnoRepository;

    @SuppressWarnings("unused")
    @GetMapping("/")
    public String mainPage(Map<String, Object> model) {
        model.put("time", new Date());
        model.put("message", "This is a test message " + spaturnoRepository);
        return "index";
    }
}
