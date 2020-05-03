package com.sailfish.example;

import java.util.concurrent.TimeUnit;

/**
 * @author sailfish
 * @create 2020-05-03-11:35 上午
 */
public class PersonServiceImpl implements PersonService{

    private PersonDAO personDAO;

    @Override
    public void findPersonList() {
        System.out.println("findPersonList ...");
        personDAO.findPersonList();
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void setPersonDAO(PersonDAO personDAO) {
        this.personDAO = personDAO;
    }
}
