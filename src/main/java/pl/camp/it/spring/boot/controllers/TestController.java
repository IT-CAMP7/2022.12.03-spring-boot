package pl.camp.it.spring.boot.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.camp.it.spring.boot.model.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Controller
public class TestController {

    @RequestMapping(value = "/parametry/test/{cos}/{name}/{surname}/{id}",
            method = RequestMethod.GET)
    public String test(@PathVariable String name,
                       @PathVariable String surname,
                       @PathVariable int id,
                       @PathVariable int cos) {
        System.out.println(cos);
        System.out.println(name);
        System.out.println(surname);
        System.out.println(id);

        return "main";
    }

    @RequestMapping(value = "/parametry/test2", method = RequestMethod.GET)
    public String test2(@RequestParam("imie") String name,
                        @RequestParam("nazwisko") String surname) {
        System.out.println(name);
        System.out.println(surname);

        return "main";
    }

    @RequestMapping(value = "/parametry/test2/{param1}/{param2}", method = RequestMethod.GET)
    public String test3(@PathVariable String param1,
                        @PathVariable String param2,
                        @RequestParam int id) {
        System.out.println(param1);
        System.out.println(param2);
        System.out.println(id);

        return "main";
    }

    @RequestMapping(value = "/form", method = RequestMethod.GET)
    public String test4() {
        return "form";
    }

    @RequestMapping(value = "/form", method = RequestMethod.POST)
    public String test5(@RequestParam String name,
                        @RequestParam String password,
                        @RequestParam int age) {
        System.out.println(name);
        System.out.println(password);
        System.out.println(age);

        return "main";
    }

    @RequestMapping(value = "/parametry/test3",method = RequestMethod.GET)
    public String test3(@RequestParam int age,
                        @RequestParam String name) {
        System.out.println(age);
        System.out.println(name);

        return "main";
    }

    @RequestMapping(value = "/response/test", method = RequestMethod.GET)
    public String response(Model model) {
        List<String> strings = new ArrayList<>();
        strings.add("Mateusz");
        strings.add("Janusz");
        strings.add("Zbyszek");
        strings.add("Karol");
        strings.add("Wiesiek");
        strings.add("Paweł");

        String randomName = strings.get(new Random().nextInt(strings.size()));

        model.addAttribute("imie", randomName);
        model.addAttribute("wiek", 45);
        model.addAttribute("imiona", strings);

        return "data";
    }

    @RequestMapping(value = "/form2", method = RequestMethod.GET)
    public String form2(Model model) {
        User user = new User("mateusz1123", "Mateusz", "Kowalski", "tajne");
        model.addAttribute("user", user);
        System.out.println(user);
        return "form2";
    }

    @RequestMapping(value = "/form2", method = RequestMethod.POST)
    public String form2process(@ModelAttribute User user,
                               @RequestParam String password2) {
        System.out.println(user.getLogin());
        System.out.println(user.getName());
        System.out.println(user.getSurname());
        System.out.println(user.getPassword());
        System.out.println(password2);

        if(user.getPassword().equals(password2)) {
            System.out.println("Gitara !!");
        } else {
            System.out.println("Zle hasla nie rejestrujemy goscia");
        }

        System.out.println(user);

        return "main";
    }
}
