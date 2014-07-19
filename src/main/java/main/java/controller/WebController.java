package main.java.controller;

import main.java.Packager;
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
        model.addAttribute("greeting", "ZWMS");
        model.addAttribute("tagline", "Let's package this order!");

        return "welcome";
    }

    /* @RequestMapping(value = "/test", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Integer> test(@RequestBody Map<String, Integer> arguments) {
        System.out.println(arguments);
        return arguments;
    }

    @RequestMapping("/package")
    public String list(Model model) {
        model.addAttribute("order", Packager.());
        return "order";
    }     */
}