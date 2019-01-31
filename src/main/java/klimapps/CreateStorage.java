package klimapps;

import klimapps.entity.Storage;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateStorage {

    private static SessionFactory getSessionFactory() {
        return new Configuration()
                .configure()
                .addAnnotatedClass(Storage.class)
                .buildSessionFactory();
    }

    public static Integer saveStorage(Storage storage) {

        Session session = getSessionFactory().getCurrentSession();

        session.beginTransaction();
        Integer storageId = (Integer) session.save(storage);
        session.getTransaction().commit();
        session.close();

        return storageId;
    }
}
