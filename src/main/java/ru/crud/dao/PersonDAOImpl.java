package ru.crud.dao;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import ru.crud.models.Person;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class PersonDAOImpl implements PersonDAO{
    private static int PEOPLE_COUNT;

    private static final String URL = "jdbc:mysql://localhost:3306/criminal?serverTimezone=Europe/Minsk&useSSL=false";
    private static final String USERNAME = "root";
    private static final String PASSWORS = "qwerty123Ffd";
    private static Connection connection;

    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try {
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORS);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List <Person> index() {
        List<Person> people= new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            String SQL = "SELECT * FROM prisoners";
            ResultSet resultSet = statement.executeQuery(SQL);
            while(resultSet.next()){
                Person person = new Person();
                person.setId(resultSet.getInt("id"));
                person.setName(resultSet.getString("name"));
                person.setSurname(resultSet.getString("surname"));
                person.setDateOfBirth(resultSet.getDouble("dateOfBirth"));
                person.setArticle(resultSet.getDouble("article"));
                person.setArrivalDate(resultSet.getDouble("arrivalDate"));
                person.setAppointedTime(resultSet.getDouble("appointedTime"));
                person.setDemeanor(resultSet.getString("demeanor"));
                people.add(person);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return people;
    }

    public Person show (int id){
        Person person = null;

        try {
            PreparedStatement preparedStatement =
                    connection.prepareStatement("SELECT * FROM prisoners WHERE id=?");

            preparedStatement.setInt(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();

            resultSet.next();

            person = new Person();

            person.setId(resultSet.getInt("id"));
            person.setName(resultSet.getString("name"));
            person.setSurname(resultSet.getString("surname"));
            person.setDateOfBirth(resultSet.getDouble("dateOfBirth"));
            person.setArticle(resultSet.getDouble("article"));
            person.setArrivalDate(resultSet.getDouble("arrivalDate"));
            person.setAppointedTime(resultSet.getDouble("appointedTime"));
            person.setDemeanor(resultSet.getString("demeanor"));


        } catch (SQLException e) {
            e.printStackTrace();
        }
        return person;
    }


    public void save(Person person){
        try {
            PreparedStatement preparedStatement =
                    connection.prepareStatement("INSERT INTO prisoners VALUES(id, ?, ?, ?, ?, ?, ? ,?)");

            preparedStatement.setString(1, person.getName());
            preparedStatement.setString(2, person.getSurname());
            preparedStatement.setDouble(3, person.getDateOfBirth());
            preparedStatement.setDouble(4, person.getArticle());
            preparedStatement.setDouble(5, person.getArrivalDate());
            preparedStatement.setDouble(6, person.getAppointedTime());
            preparedStatement.setString(7, person.getDemeanor());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void update(int id, Person updatedPerson){
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE prisoners SET name=?, surname=?, dateOfBirth=?, article=?, arrivalDate=?, appointedTime=?, demeanor=? WHERE id=?");

            preparedStatement.setString(1, updatedPerson.getName());
            preparedStatement.setString(2, updatedPerson.getSurname());
            preparedStatement.setDouble(3, updatedPerson.getDateOfBirth());
            preparedStatement.setDouble(4, updatedPerson.getArticle());
            preparedStatement.setDouble(5, updatedPerson.getArrivalDate());
            preparedStatement.setDouble(6, updatedPerson.getAppointedTime());
            preparedStatement.setString(7, updatedPerson.getDemeanor());

            preparedStatement.setInt(8, id);

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete(int id) {
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement("DELETE FROM prisoners WHERE id=?");

            preparedStatement.setInt(1, id);

            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }
}





















   /*public Person show(int id){
        return people.stream().filter(person -> person.getId() == id).findAny().orElse(null);

     private List<Person> people;
    {
        people = new ArrayList<>();
        people.add(new Person(++PEOPLE_COUNT, "Tim", "Tim2", 345345, 345356, 34546, 345345, "ssdgdg" ));
        people.add(new Person(++PEOPLE_COUNT, "Tom", "Tim2", 345345, 345356, 34546, 345345, "ssdgdg" ));
        people.add(new Person(++PEOPLE_COUNT, "Bim", "Tim2", 345345, 345356, 34546, 345345, "ssdgdg" ));
        people.add(new Person(++PEOPLE_COUNT, "Lim", "Tim2", 345345, 345356, 34546, 345345, "ssdgdg" ));
    }



    }*/

