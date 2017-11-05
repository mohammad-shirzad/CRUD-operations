package model.dao;

import model.dto.Person;
import java.sql.SQLException;
import java.util.List;

public interface IPersonDao {
    public void create(Person person) throws Exception;
    public List<Person> getPersons() throws SQLException, ClassNotFoundException;
    public void updatePersonById(int id,String firstName,String lastName,String major) throws SQLException, ClassNotFoundException;
    public void deletePersonById(int nationalId) throws SQLException, ClassNotFoundException;
}