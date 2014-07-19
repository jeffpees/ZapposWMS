package main.java.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: annaleis
 * Date: 7/16/14
 * Time: 10:16 AM
 * To change this template use File | Settings | File Templates.
 */


@Controller
public class WebController {

    @RequestMapping("/")
    public String welcome(Model model) {
        model.addAttribute("greeting", "Welcome to Web Store!");
        model.addAttribute("tagline", "The one and only amazing webstore");

        return "welcome";
    }
}