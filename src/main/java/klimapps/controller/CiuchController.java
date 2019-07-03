package klimapps.controller;

import klimapps.dao.CiuchDAO;
import klimapps.entity.Ciuch;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/ciuch")
public class CiuchController {

    @Autowired
    private CiuchDAO ciuchDAO;

    @RequestMapping("/showForm")
    public String showForm(Model model) {

        Ciuch ciuch = new Ciuch();
        model.addAttribute("ciuch", ciuch);

        return "ciuch-form";
    }

    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model model) {

        Ciuch ciuch = new Ciuch();
        model.addAttribute("ciuch", ciuch);

        return "ciuch-form";
    }

    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("ciuchId") int ciuchId, Model model) {

        Ciuch ciuch = ciuchDAO.getCiuch(ciuchId);

        model.addAttribute("ciuch", ciuch);

        return "ciuch-form";
    }

    @PostMapping("/saveCiuch")
    public String saveCiuch(@ModelAttribute("ciuch") Ciuch ciuch) {

        ciuchDAO.saveCiuch(ciuch);

        System.out.println("SAVE TO DB!");
        System.out.println("Ciuch name: " + ciuch.getNazwa() + ", Index: " + ciuch.getIndex() );

        return "redirect:/ciuch/list";
    }

    @GetMapping("/deleteCiuch")
    public String deleteCiuch(@RequestParam("ciuchId") int ciuchId) {

        ciuchDAO.deleteCiuch(ciuchId);

        System.out.println("DELTED FROM DB!");

        return "redirect:/ciuch/list";
    }

    @RequestMapping("/list")
    public String listCiuchy(Model model) {

        List<Ciuch> ciuchy = ciuchDAO.getCiuchy();

        model.addAttribute("ciuchy", ciuchy);

        return "list-ciuchy";
    }

    @RequestMapping("/wyslijNaMagazyn")
    public String listStoredarticles(Model model) {

        List<Ciuch> ciuchy = ciuchDAO.getPrzygotowaneCiuchy();

        model.addAttribute("ciuchyPrzygotowane", ciuchy);

        return "wyslij-na-magazyn";
    }
}
