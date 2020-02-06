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
    private List<Ciuch> doPrzyjeciaNaMagazyn = new ArrayList<>();
    private List<Ciuch> ciuchyDostepne = null;
    private String latestId = IndexPrefix.createNewPrefix();

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


    @GetMapping("/wyslijZamowienie")
    public String wyslijZamowienie() {

        for (Ciuch ciuch : ciuchyNaMagazyn) {
            ciuchDAO.saveCiuch(ciuch, Status.WYSLANO_NA_MAGAZYN);
            System.out.println("zapisano ciuch: " + ciuch.getCiuchid() + " ze statusem WYSLANO NA MAGAZYN");
//            ciuchyNaMagazyn.remove(ciuch);
//            ciuchyNaMagazyn.removeIf(a -> a.getCiuchid().equals(ciuch.getCiuchid()));
        }
        ciuchyNaMagazyn.clear();
        System.out.println("EFEKT");
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


    // START START START START START START START wyslijNaMagazyn = przyjmijNaMagazyn
    @RequestMapping("/przyjmijNaMagazyn")

    public String listSentarticles(Model model) {

        ciuchyDostepne = ciuchDAO.getWyslaneCiuchy();
        ciuchyDostepne.removeAll(ciuchyNaMagazyn);

        model.addAttribute("ciuchyPrzygotowane", ciuchyDostepne);
        model.addAttribute("ciuchyNaMagazyn", ciuchyNaMagazyn);

        return "wyslij-na-magazyn";
    }

    @RequestMapping("/saveStoredarticle")

    public String saveStoredarticle(@ModelAttribute("storedarticle") Ciuch theCiuch) {

        System.out.println("theStudent: " + theCiuch.getNazwa() + " " + theCiuch.getIndex());


        return "wyslij-na-magazyn";
    }

    // STOP STOP STOP STOP STOP STOP STOP STOP STOP STOP STOP STOP STOP STOP STOP STOP


    @RequestMapping("/")
    public String showMainMenu() {
        return "main-menu";
    }

    public String getCiuch(int ciuchId) {

        Ciuch ciuch = ciuchDAO.getCiuch(ciuchId);

        return ciuch.getNazwa();
    }
}
