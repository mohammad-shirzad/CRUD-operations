package main;

import model.dao.IPersonDao;
import model.dto.Person;
import util.SpringUtil;

import java.sql.Date;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws Exception{
        try {
            Person person= (Person) SpringUtil.getBean("person");
            IPersonDao personDao= (IPersonDao) SpringUtil.getBean("personDao");

//            personDao.create(new Person("00365214","first","last",
//                    new Date(System.currentTimeMillis()),"university major"));
//            ArrayList<Person> people= (ArrayList<Person>) personDao.getPersons();
//            System.out.println(people);
//            personDao.updatePersonById(1,"name","family","university major");
//            personDao.deletePersonById(3);

        }catch (Exception ex){
            System.out.println(ex.getMessage());
        }

    }
}
