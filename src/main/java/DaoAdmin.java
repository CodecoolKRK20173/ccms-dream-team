import java.sql.*;
import java.util.Scanner;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class DaoAdmin implements DAOAdmin {
    private Connection c = null;
    private PreparedStatement sqlStatement = null;

    public void addMentor(User user) {
        String login = user.getLogin();
        String password = user.getPassword();
        String userType = user.getUserType();
        String name = user.getName();
        String surname = user.getSurname();

        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:src/main/resources/ccms.db");
            sqlStatement = c.prepareStatement("INSERT INTO Users (login, password, name, surname, userType) VALUES (?, ?, ?, ?, ?)");
            sqlStatement.setString(1, login);
            sqlStatement.setString(2, password);
            sqlStatement.setString(3, name);
            sqlStatement.setString(4, surname);
            sqlStatement.setString(5, userType);

            sqlStatement.executeUpdate();
            System.out.println("  Mentor " + name + " added to database successfully");
            sqlStatement.close();
            c.close();
        } catch ( Exception e ) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        } finally {
            try {
                sqlStatement.close();
                c.close();
            } catch (Exception e) {

            }
        }
    }


    public void removeMentor(int id) {

        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:test.db");
            c.setAutoCommit(false);
            sqlStatement = c.prepareStatement("DELETE FROM Users WHERE id LIKE ?");
            sqlStatement.setInt(1, id);
            sqlStatement.executeUpdate();
            sqlStatement.close();
            c.close();
            System.out.println("  Mentor deleted from to database successfully");
        } catch ( Exception e ) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        } finally {
            try {
                sqlStatement.close();
                c.close();
            } catch (Exception e) {

            }
        }
    }


    public static void editMentor(int id) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("What would you like to edit(Name, Surname, Login, Password, Type):\n");
        String inputColumn = scanner.nextLine();

        Connection c = null;
        Statement stmt = null;
        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:src/main/resources/ccms.db");
            stmt = c.createStatement();
            if (inputColumn.equals("Name")) {
                System.out.println("Enter new name:\t");
                String newName = scanner.nextLine();
                ResultSet rs = stmt.executeQuery( "UPDATE Users SET NAME = '" + newName +"' WHERE ID = " + id + ";");
            }
            if (inputColumn.equals("Surname")){
                System.out.println("Enter new surname:\t");
                String newSurname = scanner.nextLine();
                ResultSet rs = stmt.executeQuery("UPDATE Users set SURNAME = '" + newSurname + "' WHERE ID = " + id +";" );
            }
            if (inputColumn.equals("Login")){
                System.out.println("Enter new login:\t");
                String newLogin = scanner.nextLine();
                ResultSet rs = stmt.executeQuery("UPDATE Users set LOGIN = '" + newLogin + "' WHERE ID = " + id + ";");
            }
            if (inputColumn.equals("Password")){
                System.out.println("Enter new password:\t");
                String newLogin = scanner.nextLine();
                ResultSet rs = stmt.executeQuery("UPDATE Users set PASSWORD = '" + newLogin + "' WHERE ID = " + id + ";");
            }
            if (inputColumn.equals("Type")){
                System.out.println("Enter new type:\t");
                String newLogin = scanner.nextLine();
                ResultSet rs = stmt.executeQuery("UPDATE Users set TYPE = '" + newLogin + "' WHERE ID = " + id + ";");
            }
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        } finally {
            try{
                stmt.close();
                c.close();
            } catch (Exception e){
                System.err.println(e.getClass().getName() + ": " + e.getMessage());
            }
        }
    }


    public ArrayList<Mentor> getMentors() {
        ArrayList<Mentor> mentors = new ArrayList<Mentor>();
        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:src/main/resources/ccms.db");
            sqlStatement = c.prepareStatement("SELECT * FROM Users WHERE userType LIKE 'mentor'");

            ResultSet recordFromDatabase = sqlStatement.executeQuery();
            while ( recordFromDatabase.next() ) {
                int id = recordFromDatabase.getInt("id");
                String login = recordFromDatabase.getString("login");
                String password = recordFromDatabase.getString("password");
                String name = recordFromDatabase.getString("name");
                String surname = recordFromDatabase.getString("surname");
                String userType = recordFromDatabase.getString("userType");
                mentors.add(new Mentor(id, login, password, name, surname, userType) );
            }

            recordFromDatabase.close();
            sqlStatement.close();
            c.close();
        } catch ( Exception e ) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        } finally {
            try {
                sqlStatement.close();
                c.close();
            } catch (Exception e) {

            }
        }

            return mentors;
    }


    public ArrayList<Student> getStudents() {
        ArrayList<Student> students = new ArrayList<Student>();
        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:src/main/resources/ccms.db");
            sqlStatement = c.prepareStatement("SELECT * FROM Users WHERE userType LIKE 'student'");

            ResultSet recordFromDatabase = sqlStatement.executeQuery();
            while (recordFromDatabase.next()) {
                int id = recordFromDatabase.getInt("id");
                String login = recordFromDatabase.getString("login");
                String password = recordFromDatabase.getString("password");
                String name = recordFromDatabase.getString("name");
                String surname = recordFromDatabase.getString("surname");
                String userType = recordFromDatabase.getString("userType");
                students.add(new Student(id, login, password, name, surname, userType));
            }

            recordFromDatabase.close();
            sqlStatement.close();
            c.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        } finally {
            try {
                sqlStatement.close();
                c.close();
            } catch (Exception e) {

            }

            return students;
        }
    }
}
