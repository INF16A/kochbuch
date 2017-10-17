package de.dhbw.mosbach.inf16a.kochbuch.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

/**
 * Created by Annika on 17.10.2017.
 */
@RestController
public class SocialController {

    @GetMapping("/user")
    public Principal user(Principal principal) {
        return principal;
    }
}
