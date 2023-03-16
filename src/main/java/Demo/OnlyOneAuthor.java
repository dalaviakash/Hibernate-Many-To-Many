package Demo;

import Domain.Author;
import Domain.Book;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class OnlyOneAuthor {
    public static void main(String[] args) {

        Configuration cfg;
        SessionFactory factory;
        Session ses;
        Transaction tx;

        cfg = new Configuration();
        cfg = cfg.configure();
        cfg = cfg.addAnnotatedClass(Author.class);
        cfg = cfg.addAnnotatedClass(Book.class);
        factory = cfg.buildSessionFactory();
        ses = factory.openSession();

        Criteria crt= ses.createCriteria(Book.class);
        List<Book>bookList=crt.list();
        for (Book b:bookList){

            List<Author>authorList=b.getAuthorList();
            if (authorList.size()==1){
                System.out.println(b.getBookName());
            }
        }
    }
}