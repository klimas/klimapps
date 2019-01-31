package klimapps.controller;

import klimapps.dao.ArticleDAO;
import klimapps.entity.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/article")
public class ArticleController {

    @Autowired
    private ArticleDAO articleDAO;

    @RequestMapping("/showForm")
    public String showForm(Model model) {

        Article article = new Article();
        model.addAttribute("article", article);

        return "article-form";
    }

    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model model) {

        Article article = new Article();
        model.addAttribute("article", article);

        return "article-form";
    }

    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("articleId") int articleId, Model model) {

        Article article = articleDAO.getArticle(articleId);

        model.addAttribute("article", article);

        return "article-form";
    }

    @PostMapping("/saveArticle")
    public String saveArticle(@ModelAttribute("article") Article article) {

        articleDAO.saveArticle(article);

        System.out.println("SAVE TO DB!");
        System.out.println("Article name: " + article.getName() + ", EAN: " + article.getEan() + ", int. name: " + article.getInternalName());

        return "redirect:/article/list";
    }

    @GetMapping("/deleteArticle")
    public String deleteArticle(@RequestParam("articleId") int articleId) {

        articleDAO.deleteArticle(articleId);

        System.out.println("DELTED FROM DB!");

        return "redirect:/article/list";
    }

    @RequestMapping("/list")
    public String listArticles(Model model) {

        List<Article> theArticles = articleDAO.getArticles();

        model.addAttribute("articles", theArticles);

        return "list-articles";
    }
}
