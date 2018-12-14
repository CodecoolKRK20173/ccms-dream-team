package dao;

import user.Student;

import java.sql.*;
import java.util.ArrayList;

public class DaoOffice implements DAOOffice {

    private Connection c = null;
    private PreparedStatement sqlStatement = null;

    public ArrayList<Student> getStudents() {
        ArrayList<Student> students = new ArrayList<Student>();
        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:src/main/resources/ccms.db");
            sqlStatement = c.prepareStatement("SELECT * FROM Users WHERE userType LIKE 'student'");

            ResultSet recordFromDatabase = sqlStatement.executeQuery();
            while ( recordFromDatabase.next() ) {
                int id = recordFromDatabase.getInt("id");
                String login = recordFromDatabase.getString("login");
                String password = recordFromDatabase.getString("password");
                String name = recordFromDatabase.getString("name");
                String surname = recordFromDatabase.getString("surname");
                String userType = recordFromDatabase.getString("userType");
                students.add(new Student(id, login, password, name, surname, userType) );
            }

            recordFromDatabase.close();
            sqlStatement.close();
            c.close();
        } catch ( Exception e ) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        }
        return students;
    }
}