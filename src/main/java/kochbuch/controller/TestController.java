package kochbuch.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Annika on 16.10.2017.
 */
@RestController
public class TestController {

    @GetMapping("/test")
    public String test(){
        return "App is working";
    }
}
