package klimapps.controller;

import klimapps.dao.ArticleDAO;
import klimapps.dao.StoredarticleDAO;
import klimapps.entity.StoredArticle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/storedarticle")
public class StoredarticleController {

    @Autowired
    private StoredarticleDAO storedarticleDAO;

    @Autowired
    private ArticleDAO articleDAO;

    @GetMapping(value = "/showFormForAdd")
    public String getArticle2storageForm(Model model) {

        model.addAttribute("articles", articleDAO.getArticles());
        model.addAttribute("storedarticle", new StoredArticle());
        return "article2storage-form";
    }

    @PostMapping("/saveStoredarticle")
    public String submitArticle2storageForm(@ModelAttribute("storedarticle") StoredArticle storedArticle, BindingResult result) {

        if (result.hasErrors()) {
            return "article2storage-form";
        }
        storedarticleDAO.saveStoredarticle(storedArticle);

        System.out.println("Nowy wpis ID: " + storedArticle.getStoredarticleid() + ", Storage name: " + storedArticle.getStorage().getStorageName() + ", article name: " + storedArticle.getArticle().getArticleName());

        return "redirect:/storedarticle/list";

    }

    @RequestMapping("/list")
    public String listStoredarticles(Model model) {

        List<StoredArticle> storedArticles = storedarticleDAO.getStoredarticles();

        model.addAttribute("storedarticles", storedArticles);

        return "list-storedarticles";
    }

    /*
    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("articleId") int articleId, Model model) {

        Article article = articleDAO.getArticle(articleId);

        model.addAttribute("article", article);

        return "article-form";
    }


    @GetMapping("/deleteArticle")
    public String deleteArticle(@RequestParam("articleId") int articleId) {

        articleDAO.deleteArticle(articleId);

        System.out.println("DELTED FROM DB!");

        return "redirect:/article/list";
    }*/

}
