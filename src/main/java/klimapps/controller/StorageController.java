package klimapps.controller;

import klimapps.dao.StorageDAO;
import klimapps.entity.Storage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/storage")
public class StorageController {

    @Autowired
    private StorageDAO storageDAO;
    
    @RequestMapping("/showForm")
    public String showForm(Model model) {

        Storage storage = new Storage();
        model.addAttribute("storage", storage);

        return "storage-form";
    }


    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model model) {

        Storage storage = new Storage();
        model.addAttribute("storage", storage);

        return "storage-form";
    }

    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("storageId") int storageId, Model model) {

        Storage storage = storageDAO.getStorage(storageId);

        model.addAttribute("storage", storage);

        return "storage-form";
    }

    @PostMapping("/saveStorage")
    public String saveStorage(@ModelAttribute("storage") Storage storage) {

        storageDAO.saveStorage(storage);

        System.out.println("SAVE TO DB!");
        System.out.println("Storage name: " + storage.getStorageName() + ", localization: " + storage.getLocalization());

        return "redirect:/storage/list";
    }

    @GetMapping("/deleteStorage")
    public String deleteStorage(@RequestParam("storageId") int storageId) {

        storageDAO.deleteStorage(storageId);

        System.out.println("DELTED FROM DB!");

        return "redirect:/storage/list";
    }

    @RequestMapping("/list")
    public String listStorages(Model model) {

        List<Storage> theStorages = storageDAO.getStorages();

        model.addAttribute("storages", theStorages);

        return "list-storages";
    }

    @RequestMapping("/processForm")
    public String processForm(@ModelAttribute("storage") Storage storage) {

        storageDAO.saveStorage(storage);

        return "storage-confirmation";
    }
}
