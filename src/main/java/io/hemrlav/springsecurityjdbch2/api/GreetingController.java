package io.hemrlav.springsecurityjdbch2.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/greet")
public class GreetingController {

    @GetMapping("/citizen")
    public String greetCitizen() {
        return "<h1>Hello, Citizen!</h1>";
    }

    @GetMapping("/avenger")
    public String greetAvenger() {
        return "<h1>Hello, Avenger!</h1>";
    }

    @GetMapping("/director")
    public String greetDirector() {
        return "<h1>Hello, Director!</h1>";
    }

}
