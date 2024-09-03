import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.entity.Student;

import java.util.Set;

public class CreateStudentImageSet {
    public static void main(String[] args) {

        //create Configuration
        Configuration cfg = new Configuration();
        cfg.configure();
        //create sessionFactory
        SessionFactory sf = cfg.buildSessionFactory();
        //create session
        Session session = sf.getCurrentSession();
        try{
            //create object
            Student s = new Student("mib", "ghost", "mibghost@gmail.com");
            Set<String> images = s.getImages();
            images.add("pic1.jpg");
            images.add("pic2.jpg");
            images.add("pic3.jpg");

            Transaction tx = session.getTransaction();
            tx.begin();
            System.out.println("saving the student and images...");
            session.persist(s);
            System.out.println("done saving..!!");
            tx.commit();
        }finally {
            session.close();
            sf.close();
        }
    }
}
