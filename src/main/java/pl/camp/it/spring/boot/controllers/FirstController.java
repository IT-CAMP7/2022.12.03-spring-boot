package pl.camp.it.spring.boot.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class FirstController {

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public String cos() {
        System.out.println("Działa !!!");
        System.out.println("Przyszło zadanie HTTP !!");

        return "main";
    }

    @RequestMapping(value = "/test2", method = RequestMethod.GET)
    public String test2() {
        System.out.println("meotda 2 !!");
        System.out.println("zadzialalo !!!");

        return "szablon2";
    }
}
