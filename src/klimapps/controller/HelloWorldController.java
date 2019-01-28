package klimapps.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloWorldController {

    @RequestMapping("/")
    public String showPage() {
        return "main-menu";
    }

/*    @RequestMapping("/form")
    public String formRequest () {
        return "form-request";
    }

    @RequestMapping("/formProcess")
    public String formProcess () {
        return "form-process";
    }

    @RequestMapping("/formProcessTwo")
    public String formProcessTwo (@RequestParam("studentName") String name, Model model) {

        model.addAttribute("message", name.toUpperCase());

        return "form-process";
    }*/
}
