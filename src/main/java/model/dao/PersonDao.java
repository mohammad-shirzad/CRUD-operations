package model.dao;

import model.dto.JDBC;
import model.dto.Person;
import util.SpringUtil;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Class for CRUD operations on table named Person in SQL server 2014 with columns:
 * Id int Primary key,
 * FirstName nvarchar(50),
 * LastName nvarchar(50),
 * BirthDate Date,
 * Major nvarchar(50),
 * NationalId nvarchar(50) Unique,
 * LastModificationDate Date
 */
public class PersonDao  implements IPersonDao {

    PreparedStatement ps;

    PersonDao() throws SQLException {
    }

    public void create(Person person) throws Exception {
        try {
            ps = JDBC.openConnection().
                    prepareStatement("INSERT INTO Person (NationalId,FirstName,LastName,BirthDate,LastModificationDate,Major )" +
                            "VALUES (?,?,?,?,?,?);");
            ps.setString(1, person.getNationalId());
            ps.setString(2, person.getFirstName());
            ps.setString(3, person.getLastName());
            ps.setDate(4, (Date) person.getBirthDate());
            ps.setDate(5, new Date(System.currentTimeMillis()));
            ps.setString(6, person.getMajor());
            ps.executeUpdate();
            ps.close();
            JDBC.closeConnection();

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            throw ex;
        }

    }

    public List<Person> getPersons() throws SQLException, ClassNotFoundException {
        try {
            ps = JDBC.openConnection().prepareStatement("SELECT * FROM Person");
            ResultSet rs = ps.executeQuery();
            ArrayList<Person> lst = (ArrayList<Person>) SpringUtil.getBean("list");
            Person person = (Person) SpringUtil.getBean("person");
            while (rs.next()) {
                person.nationalId = rs.getString(1);
                person.firstName = rs.getString(2);
                person.lastName = rs.getString(3);
                person.birthDate = rs.getDate(4);
                person.major = rs.getString(6);
                lst.add(person);
            }
            ps.close();
            JDBC.closeConnection();
            return lst;

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            throw ex;
        }
    }

    public void updatePersonById(int id, String firstName, String lastName, String major) throws SQLException, ClassNotFoundException {
        try {

            ps = JDBC.openConnection().
                    prepareStatement("UPDATE Person SET FirstName=? , LastName=? , Major=? ,LastModificationDate=? WHERE Id=?");
            ps.setString(1, firstName);
            ps.setString(2, lastName);
            ps.setString(3, major);
            ps.setDate(4, new Date(System.currentTimeMillis()));
            ps.setInt(5, id);
            ps.executeUpdate();
            ps.close();
            JDBC.closeConnection();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            throw ex;
        }
    }

    public void deletePersonById(int id) throws SQLException, ClassNotFoundException {
        try {

            ps = JDBC.openConnection().
                    prepareStatement("DELETE FROM Person WHERE Id=?");
            ps.setInt(1, id);
            ps.executeUpdate();
            JDBC.closeConnection();

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            throw ex;
        }
    }
}
