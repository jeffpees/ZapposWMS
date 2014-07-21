package main.java.controller;

import main.java.TestOrder;
import main.java.Packager;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


/**
 * Created with IntelliJ IDEA.
 * User: annaleis
 * Date: 7/16/14
 * Time: 10:16 AM
 * To change this template use File | Settings | File Templates.
 */


@RestController
public class WebController {

    @RequestMapping(value = "/test")
    @ResponseBody
    public TestOrder test() {
        TestOrder t = new TestOrder(1, "test", 3, 4);
        return t;

    }
}











    /* @RequestMapping(value = "/test", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Integer> test(@RequestBody Map<String, Integer> arguments) {
        System.out.println(arguments);
        return arguments;
    }       */
