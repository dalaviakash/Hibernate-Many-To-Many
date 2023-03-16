package Demo;

import Domain.Author;
import Domain.Book;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Scanner;

public class AddBooks {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("write first book name");
        String book1= sc.next();
        System.out.println("write first Author name");
        String name1=sc.next();
        System.out.println("write Second Author name");
        String name2=sc.next();
        Configuration cfg;
        SessionFactory factory;
        Session ses;
        Transaction tx;

        cfg=new Configuration();
        cfg=cfg.configure();
        cfg= cfg.addAnnotatedClass(Book.class);
        cfg=cfg.addAnnotatedClass(Author.class);
        factory=cfg.buildSessionFactory();
        ses= factory.openSession();



        Book b1=new Book();
        b1.setBookName(book1);

        Author a1=new Author();
        a1.setAuthorName(name1);
        Author a2=new Author();
        a2.setAuthorName(name2);

      b1.addAuthor(a1);
      b1.addAuthor(a2);

        tx=ses.beginTransaction();
        ses.save(a1);
        ses.save(b1);
        ses.save(a2);
        tx.commit();
        System.out.println("data inserted");
    }
}
