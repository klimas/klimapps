package klimapps.controller;

import klimapps.IndexPrefix;
import klimapps.dao.CiuchDAO;
import klimapps.entity.Ciuch;
import klimapps.entity.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/ciuch")
public class CiuchController {


    @Autowired
    private CiuchDAO ciuchDAO;

    private List<Ciuch> ciuchyNaMagazyn = new ArrayList<>();
    private List<Ciuch> ciuchyDostepne = null;
    private String latestId = IndexPrefix.getLatestCiuchIndex().toString();

    @RequestMapping("/showForm")
    public String showForm(Model model) {

        Ciuch ciuch = new Ciuch(latestId);
        model.addAttribute("ciuch", ciuch);

        return "ciuch-form";
    }

    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model model) {

        Ciuch ciuch = new Ciuch(latestId);
        model.addAttribute("ciuch", ciuch);

        return "ciuch-form";
    }

    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("ciuchId") int ciuchId, Model model) {

        Ciuch ciuch = ciuchDAO.getCiuch(ciuchId);

        model.addAttribute("ciuch", ciuch);

        return "ciuch-form";
    }

    @GetMapping("/przeniesDoListy")
    public String przeniesDoListy(@RequestParam("ciuchId") int ciuchId, Model model) {

        Ciuch ciuch = ciuchDAO.getCiuch(ciuchId);
        ciuchyDostepne.removeIf(a -> a.getCiuchid().equals(ciuchId));

        ciuchyNaMagazyn.add(ciuch);

        model.addAttribute("ciuchyPrzygotowane", ciuchyDostepne);
        model.addAttribute("ciuchyNaMagazyn", ciuchyNaMagazyn);

        return "wyslij-na-magazyn";
    }

    @GetMapping("/usunZListy")
    public String usunZListy(@RequestParam("ciuchId") int ciuchId, Model model) {

        Ciuch ciuch = ciuchDAO.getCiuch(ciuchId);
        ciuchyNaMagazyn.removeIf(a -> a.getCiuchid().equals(ciuchId));
        ciuchyDostepne.add(ciuch);

        model.addAttribute("ciuchyPrzygotowane", ciuchyDostepne);
        model.addAttribute("ciuchyNaMagazyn", ciuchyNaMagazyn);

        return "wyslij-na-magazyn";
    }

    @PostMapping("/saveCiuch")
    public String saveCiuch(@ModelAttribute("ciuch") Ciuch ciuch) {

        ciuchDAO.saveCiuch(ciuch, Status.PRZYGOTOWANY);
        System.out.println("SAVE TO DB!");
        System.out.println("Ciuch name: " + ciuch.getNazwa() + ", Index: " + ciuch.getIndex());

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

        ciuchyDostepne = ciuchDAO.getPrzygotowaneCiuchy();
        ciuchyDostepne.removeAll(ciuchyNaMagazyn);

        model.addAttribute("ciuchyPrzygotowane", ciuchyDostepne);
        model.addAttribute("ciuchyNaMagazyn", ciuchyNaMagazyn);

        return "wyslij-na-magazyn";
    }

    @RequestMapping("/")
    public String showMainMenu() {
        return "main-menu";
    }

    public String getCiuch(int ciuchId) {

        Ciuch ciuch = ciuchDAO.getCiuch(ciuchId);

        return ciuch.getNazwa();
    }
}
