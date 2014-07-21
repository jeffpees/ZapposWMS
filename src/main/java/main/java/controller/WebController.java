package main.java.controller;

import main.java.TestOrder;
import main.java.Packager;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created with IntelliJ IDEA.
 * User: annaleis
 * Date: 7/16/14
 * Time: 10:16 AM
 * To change this template use File | Settings | File Templates.
 */


@Controller
public class WebController {

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    @ResponseBody
    public String display(Model model) {
        TestOrder tOrder = new TestOrder(1, "pants", 99, 88);
        model.addAttribute("welcome", tOrder);


        return("welcome");
    }
}











    /* @RequestMapping(value = "/test", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Integer> test(@RequestBody Map<String, Integer> arguments) {
        System.out.println(arguments);
        return arguments;
    }       */
