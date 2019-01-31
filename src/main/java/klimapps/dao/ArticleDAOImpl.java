package klimapps.dao;

import klimapps.entity.Article;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public class ArticleDAOImpl implements ArticleDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    @Transactional
    public List<Article> getArticles() {

        Session currentSession = sessionFactory.getCurrentSession();

        Query<Article> query = currentSession.createQuery("from Article order by articleid", Article.class);

        return query.list();
    }

    @Override
    @Transactional
    public void saveArticle(Article article) {

        Session session = sessionFactory.getCurrentSession();

        session.saveOrUpdate(article);
    }

    @Override
    @Transactional
    public void deleteArticle(Integer articleId) {

        Session session = sessionFactory.getCurrentSession();

        Query query = session.createQuery("delete from Article where articleid = :id").
                setParameter("id", articleId);

        query.executeUpdate();
    }

    @Override
    @Transactional
    public Article getArticle(int articleId) {

        Session session = sessionFactory.getCurrentSession();

        return session.get(Article.class, articleId);
    }
}
