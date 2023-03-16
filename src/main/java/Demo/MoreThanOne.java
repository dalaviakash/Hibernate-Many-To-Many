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

public class MoreThanOne {
    public static void main(String[] args) {

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

        Criteria crt= ses.createCriteria(Author.class);
        List<Author> AuthorList=crt.list();
        for (Author a:AuthorList){


            List<Book>bookList=a.getBookList();
                if(bookList.size()>1){
                    System.out.println(a.getAuthorName());

                }
            }
        }

    }

