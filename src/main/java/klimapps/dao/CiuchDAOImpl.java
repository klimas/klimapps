package klimapps.dao;

import klimapps.entity.Ciuch;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public class CiuchDAOImpl implements CiuchDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    @Transactional
    public List<Ciuch> getCiuchy() {

        Session currentSession = sessionFactory.getCurrentSession();

        Query<Ciuch> query = currentSession.createQuery("from Ciuch order by ciuchid", Ciuch.class);

        return query.list();
    }

    @Override
    @Transactional
    public void saveCiuch(Ciuch ciuch) {

        Session session = sessionFactory.getCurrentSession();

        session.saveOrUpdate(ciuch);
    }

    @Override
    @Transactional
    public void deleteCiuch(Integer ciuchId) {

        Session session = sessionFactory.getCurrentSession();

        Query query = session.createQuery("delete from Ciuch where ciuchid = :id").
                setParameter("id", ciuchId);

        query.executeUpdate();
    }
    // znaleźć ostatni wpis do bazy !!!!, SELECT last albo coś takiego



    @Override
    @Transactional
    public Ciuch getCiuch(int ciuchId) {

        // znaleźć ostatni wpis do bazy !!!!

        Session session = sessionFactory.getCurrentSession();

        return session.get(Ciuch.class, ciuchId);
    }
}
