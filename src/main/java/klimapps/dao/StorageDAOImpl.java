package klimapps.dao;

import klimapps.entity.Storage;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public class StorageDAOImpl implements StorageDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    @Transactional
    public List<Storage> getStorages() {

        Session currentSession = sessionFactory.getCurrentSession();

        Query<Storage> query = currentSession.createQuery("from Storage order by storageid", Storage.class);

        return query.list();
    }

    @Override
    @Transactional
    public void saveStorage(Storage storage) {

        Session session = sessionFactory.getCurrentSession();

        session.saveOrUpdate(storage);
    }

    @Override
    @Transactional
    public void deleteStorage(Integer storageId) {

        Session session = sessionFactory.getCurrentSession();

        Query query = session.createQuery("delete from Storage where storageid = :id").
                setParameter("id", storageId);

        query.executeUpdate();
    }

    @Override
    @Transactional
    public Storage getStorage(int storageId) {

        Session session = sessionFactory.getCurrentSession();

        return session.get(Storage.class, storageId);
    }
}
