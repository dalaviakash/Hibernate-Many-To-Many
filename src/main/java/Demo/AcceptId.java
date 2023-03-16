package Demo;

import Domain.Author;
import Domain.Book;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;
import java.util.Scanner;

public class AcceptId {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("enter the author id");
        int id= sc.nextInt();
        Configuration cfg;
        SessionFactory factory;
        Session ses;
        Transaction tx;

        cfg=new Configuration();
        cfg=cfg.configure();
        cfg=cfg.addAnnotatedClass(Author.class);
        cfg=cfg.addAnnotatedClass(Book.class);
        factory= cfg.buildSessionFactory();
        ses= factory.openSession();

        Author a1=ses.load(Author.class,id);
        List<Book> authorList=a1.getBookList();
        for (Book b:authorList){
            System.out.println(b.getBookName());
        }

    }
}
