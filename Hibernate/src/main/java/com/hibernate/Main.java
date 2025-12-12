package com.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Main {
    public static void main(String[] args) {
//        Student s1  =  new Student();
//        s1.setRollNo(36);
//        s1.setsName("Ruby");
//        s1.setsAge(27);

//        Student s2  =  null;
//
//        SessionFactory sf =new Configuration()
//                .addAnnotatedClass(com.hibernate.Student.class)
//                .configure()
//                .buildSessionFactory();
//
//        Session session = sf.openSession();
//
//        Transaction tx = session.beginTransaction();
//        session.persist(s1);
//        session.merge(s1);
//        tx.commit();
//        s2 = session.find(Student.class, 35);
//        session.close();
//        sf.close();
//        System.out.println(s1);
//          System.out.println(s2);


        Laptop l1 = new Laptop();
        l1.setBrand("HP");
        l1.setLid(1);
        l1.setModel("Victus");
        l1.setRAM(17);

        Employee e1 = new Employee();
        e1.setId(101);
        e1.setName("Nikhil");
        e1.setTech("java");
        e1.setLaptop(l1);

        SessionFactory sf = new Configuration()
                .addAnnotatedClass(com.hibernate.Employee.class)
                .addAnnotatedClass(com.hibernate.Laptop.class)
                .configure()
                .buildSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();
        session.persist(l1);
        session.persist(e1);

        tx.commit();
        Employee e2 = session.find(Employee.class, 101);
        System.out.println(e2);
        session.close();
        sf.close();

    }
}