package klimapps.dao;

import klimapps.entity.Article;

import java.util.List;

public interface ArticleDAO {

    List<Article> getArticles();

    void saveArticle(Article article);

    void deleteArticle(Integer articleId);

    Article getArticle(int articleId);
}
