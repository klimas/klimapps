package klimapps.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloWorldController {

    @RequestMapping("/")
    public String showPage() {
        return "main-menu";
    }

    @RequestMapping("/import")
    public String importFile() {
        return "import";
    }
}
