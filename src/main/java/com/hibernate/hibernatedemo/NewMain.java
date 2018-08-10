package com.hibernate.hibernatedemo;

import com.hibernate.hibernatedemo.models.*;
import org.hibernate.*;
import org.hibernate.cfg.Configuration;


public class NewMain {
    public static void main(String[] args){
        SessionFactory fak = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .addAnnotatedClass(Town.class)
                .addAnnotatedClass(Address.class)
                .addAnnotatedClass(Department.class)
                .addAnnotatedClass(Project.class)
                .buildSessionFactory();
        Session ses = fak.openSession();
        ses.beginTransaction();
        //CREATE NEW TOWN
        //---------------------------------------------------------
        //Town newTown = new Town("Haskovo");
        //ses.save(newTown);
        //Employee.printSpaces();
        //System.out.println(newTown.getName() + " has been created!");
        //Employee.printSpaces();


        //DELETE TOWN
        //--------------------------------------------------------------
        //ses.delete(ses.get(Town.class, 33));//Haskovo


        //TAKE ALL TOWNS WITH HQL
        //--------------------------------------------------------------
        //String s = "from Town t";
        //List<Town> listOfAllTowns = ses.createQuery(s).list();
        //List<String> strings = ses.createQuery("select name from Town").list();
        //for (String t: strings) {
            //System.out.println(t);
        //}
        //DELETE SPECIFIC TOWN WITH HQL
        //------------------------------------------------------------------
        //int countOfDeletedTowns = ses
                //.createQuery("delete from Town where name ='Haskovo'")
                //.executeUpdate();


        //TAKE A SIGLE ENTITY(EMPLOYEE) BY ID
        //-----------------------------------------------------------
        //Employee emp = ses.get(Employee.class, 1);
        //System.out.println(emp.getID()+" "+emp.getFirstName()+" "+ emp.getLastName());


        //JOIN ADDRESS AND EMPLOYEES(BOTH WAYS : BI-DIRECTIONAL) ONE TO ONE
        //-----------------------------------------------------------
        //Address a = ses.get(Address.class, 40);
        //Employee a = ses.get(Employee.class, 1);
        //System.out.println(a.getFirstName() + " " + a.getAddress().getAddressText());
        //System.out.println(a.getAddressText() + "-" + a.getEmployee().getFirstName());
        //Employee.printSpaces();


        //MANY TO ONE : EMPLOYEE -> DEPARTMENTS
        //-----------------------------------------------------------------------
        //Employee a = ses.get(Employee.class, 2);
        //System.out.println(a.getFirstName()+" "+a.getLastName()+" "+a.getDepartment().getName());
        //Employee.printSpaces();


        //ONE TO MANY : DEPARTMENT -> EMPLOYEES(RETURNS LIST OF EMPLOYEES)
        //-----------------------------------------------------------------------
        //Department dep = ses.get(Department.class,7);
        //for (Employee emp: dep.getEmployees()) {
            //System.out.println(emp.getFirstName()+" "+emp.getLastName());
        //}
        //Employee.printSpaces();


        //MANY TO MANY
        //-----------------------------------------------------------------------
        //Project p = ses.get(Project.class, 4);
        //Employee em = ses.get(Employee.class,1);
        //for (Employee e : p.getEmployees()) {
            //System.out.println(e.getFirstName()+" "+e.getLastName());
        //}
        //System.out.println();
        //for (Project e : em.getProjects()) {
            //System.out.println(e.getName());
        //}
        //Employee.printSpaces();

        ses.getTransaction().commit();
        ses.close();
    }
}
