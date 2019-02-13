package klimapps.controller;

import klimapps.dao.ArticleDAO;
import klimapps.dao.StoredarticleDAO;
import klimapps.entity.StoredArticle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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


/*    @RequestMapping("/showForm")
    public String showForm(Model model) {

        Article article = new Article();
        model.addAttribute("article", article);

        return "storedarticle-form";
    }*/

    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model model) {

        StoredArticle storedArticle = new StoredArticle();
        model.addAttribute("articles", articleDAO.getArticles());
        model.addAttribute("storedarticle", storedArticle);

        return "article2storage-form";
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

    @PostMapping("/saveStoredarticle")
    public String saveStoredarticle(@ModelAttribute("storedarticle") StoredArticle storedArticle) {

        storedarticleDAO.saveStoredarticle(storedArticle);

        System.out.println("SAVE TO DB!");
        System.out.println("ID: " + storedArticle.getStoredarticleid() + ", Storage: " + storedArticle.getStorage().getStorageName() + ", article name: " + storedArticle.getArticle().getName());

        return "redirect:/article/list";
    }

    @RequestMapping("/list")
    public String listStoredarticles(Model model) {

        List<StoredArticle> storedArticles = storedarticleDAO.getStoredarticles();

        model.addAttribute("storedarticles", storedArticles);

        return "list-storedarticles";
    }
}
