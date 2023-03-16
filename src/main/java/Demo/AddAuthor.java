package Demo;



import Domain.Author;
import Domain.Book;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Scanner;

public class AddAuthor {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
//        System.out.println("write first author name");
//       String name= sc.next();
        System.out.println("write first book name");
        String book1=sc.next();
        System.out.println("write second book name");
        String book2=sc.next();
     Configuration cfg;
     SessionFactory factory;
     Session ses;
     Transaction tx;

     cfg=new Configuration();
     cfg=cfg.configure();
     cfg=cfg.addAnnotatedClass(Book.class);
     cfg=cfg.addAnnotatedClass(Author.class);
     factory= cfg.buildSessionFactory();
     ses= factory.openSession();

     Book b1=new Book();
     b1.setBookName(book1);
     Book b2=new Book();
     b2.setBookName(book2);

     Author a1=new Author();
     a1.setAuthorName("aka");

     a1.addBooks(b1);
     a1.addBooks(b2);

     tx=ses.beginTransaction();
     ses.save(b1);
     ses.save(a1);
     ses.save(b2);
     tx.commit();
     System.out.println("book and authors inserted successfully");



    }
}
