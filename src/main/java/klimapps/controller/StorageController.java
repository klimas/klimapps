package klimapps.controller;

import klimapps.CreateStorage;
import klimapps.entity.Storage;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/storage")
public class StorageController {

    @RequestMapping("/showForm")
    public String showForm(Model model) {

        Storage storage = new Storage();
        model.addAttribute("storage", storage);

        return "storage-form";
    }

    @RequestMapping("/processForm")
    public String processForm(@ModelAttribute("storage") Storage storage) {

        CreateStorage.saveStorage(storage);

        return "storage-confirmation";
    }
}
