package klimapps.dao;

import klimapps.entity.Article;
import klimapps.entity.Storage;
import klimapps.entity.StoredArticle;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;

@Repository
public class StoredarticleDAOImpl implements StoredarticleDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    @Transactional
    public List<StoredArticle> getStoredarticles() {
        Session currentSession = sessionFactory.getCurrentSession();

        Query<StoredArticle> query = currentSession.createQuery("from StoredArticle", StoredArticle.class);

        return query.list();
    }

    @Override
    @Transactional
    public void saveStoredarticle(StoredArticle storedarticle) {
        Session session = sessionFactory.getCurrentSession();
        /*To jest niepotrzebne - działa bez tego bloku, ale to tak trochę dla poprawności*/
        Article article = session.load(Article.class, storedarticle.getArticle().getArticleid());
        Storage storage = session.load(Storage.class, storedarticle.getStorage().getStorageid());
        storedarticle.setArticle(article);
        storedarticle.setStorage(storage);
        /* KONIEC BLOKU*/

        storedarticle.setDateIn(new Date());
        session.saveOrUpdate(storedarticle);

    }

    @Override
    @Transactional
    public void deleteStoredarticle(Integer storedarticleId) {
        Session session = sessionFactory.getCurrentSession();

        Query query = session.createQuery("delete from StoredArticle where storedarticleid = :id").
                setParameter("id", storedarticleId);

        query.executeUpdate();

    }

    @Override
    @Transactional
    public StoredArticle getStoredarticle(int storedarticleId) {
        Session session = sessionFactory.getCurrentSession();

        return session.get(StoredArticle.class, storedarticleId);
    }
}
