package klimapps;

import klimapps.entity.Ciuch;
import klimapps.entity.Status;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Leko on 2019-07-15.
 */
public class QueryCiuch {

    public static void main(String[] args) {

        // create session factory
    SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Ciuch.class)
            .addAnnotatedClass(Status.class)
            .buildSessionFactory();
    System.out.println("Factory created");
    Session session2 = factory.getCurrentSession();


        try {

            session2.beginTransaction();
            System.out.println("session begun");
           int ciuchId = 17;

//            List<Ciuch> theCiuchs = session2.createQuery("from Ciuch").getResultList();
//            displayCiuchs(theCiuchs);
        System.out.println("Updating ciuch with id: " + ciuchId);

Ciuch tempCiuch = session2.get(Ciuch.class, ciuchId);
            System.out.println(tempCiuch.getNazwa() + " found");
tempCiuch.setNazwa("nowa nazwa");
session2.getTransaction().commit();
String name = tempCiuch.getNazwa();
            System.out.println("new name: "+ name);
        } catch (Exception e) {
            System.out.println("NO NIESTETY BŁĄD");
        } finally {
            factory.close();
        }






//// create session factory
//
//        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Ciuch.class)
//                .addAnnotatedClass(Status.class)
//                .buildSessionFactory();
//        System.out.println("Factory created");
//        Session session2 = factory.getCurrentSession();
//        try {
//
//            session2.beginTransaction();
//
//            System.out.println("Creating list");
//            List<Ciuch> theCiuchy;
//            theCiuchy = session2.createQuery("from Ciuch ").getResultList();
//
//            System.out.println("Query done");
////            for(Student tempStudent: theStudents) {
////
////    System.out.println(tempStudent);
////}
//            System.out.println("all students");
//            displayStudens(theCiuchy);
//
////query students lastName='Doe'
//
//            System.out.println("Done  !!");
//
//            theCiuchy =
////                  session2.createQuery("from Student where last_name='Tomeko' OR first_name='Daffy'").getResultList();
//                    //     session2.createQuery("from Student where email LIKE '%vp.pl'").getResultList();
//                    session2.createQuery("from Ciuch s where s.nazwa='Spodnie'").getResultList();
//            System.out.println("Query students:");
//            displayStudens(theCiuchy);
//
//            System.out.println("Done 2 !!");
//            session2.getTransaction().commit();
//        } catch (Exception e) {
//            System.out.println("NO NIESTETY BŁĄD");
//        } finally {
//            factory.close();
//        }

    }

    private static void displayCiuchs(List<Ciuch> theCiuchs) {
        for (Ciuch tempCiuch : theCiuchs) {

            System.out.println(tempCiuch.getNazwa());
        }
    }
}
