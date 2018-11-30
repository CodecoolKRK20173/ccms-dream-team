import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;

public class DaoMentor implements DAOMentor {

    private Connection c = null;
    private PreparedStatement sqlStatement = null;
    private Statement stmt = null;
    private View view = null;

    @Override
    public Mentor getMentor(int id) {
        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:src/main/resources/ccms.db");
            sqlStatement = c.prepareStatement("SELECT * FROM Users WHERE id LIKE ?");
            sqlStatement.setInt(1, id);
            ResultSet recordFromDatabase = sqlStatement.executeQuery();

            if (recordFromDatabase.next()) {

                int id2 = recordFromDatabase.getInt("id");
                String login = recordFromDatabase.getString("login");
                String password = recordFromDatabase.getString("password");
                String userType = recordFromDatabase.getString("userType");
                String name = recordFromDatabase.getString("name");
                String surname = recordFromDatabase.getString("surname");
                return new Mentor(id2, login, password, userType, name, surname);
            } else {
                System.out.println("Wrong id");
            }
            return null;

        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        } finally {
        try {
            sqlStatement.close();
            c.close();
        } catch (Exception e){
        }
    }
        return null;
    }

    @Override
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

        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        } finally {
        try {
            sqlStatement.close();
            c.close();
        } catch (Exception e){
        }
    }
        return students;
    }

    @Override
    public void addStudent(Student student) {
        String login = student.getLogin();
        String password = student.getPassword();
        String userType = student.getUserType();
        String name = student.getName();
        String surname = student.getSurname();

        try {
            //connect();
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:src/main/resources/ccms.db");
            sqlStatement = c.prepareStatement("INSERT INTO Users (login, password, name, surname, userType) VALUES (?, ?, ?, ?, ?)");
            sqlStatement.setString(1, login);
            sqlStatement.setString(2, password);
            sqlStatement.setString(3, name);
            sqlStatement.setString(4, surname);
            sqlStatement.setString(5, userType);

            sqlStatement.executeUpdate();
            System.out.println("  Student " + name + " added to database successfully");
            //return null;
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
            //disconnect();
        } finally {
            try {
                sqlStatement.close();
                c.close();
            } catch (Exception e){
            }
        }
    }

    @Override
    public void removeStudent(int id) {
        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:src/main/resources/ccms.db");
            sqlStatement = c.prepareStatement("DELETE FROM Users WHERE id LIKE ?");
            sqlStatement.setInt(1, id);
            sqlStatement.executeUpdate();
            System.out.println("  Student deleted from to database successfully");
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        } finally {
        try {
            sqlStatement.close();
            c.close();
        } catch (Exception e){
        }
    }
    }

    @Override
    public void editStudent(int id, String newLogin, String newPassword, String newName, String newSurname) {

//        Scanner scan = new Scanner(System.in);
//        System.out.println("What would you like to edit(Name, Surname, Login, Password):\n");
//        String inputColumn = scan.nextLine();

        Connection c = null;
        Statement stmt = null;
        try{
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:src/main/resources/ccms.db");
            stmt = c.createStatement();
            if (newName.equals("Name")){
//                System.out.println("Enter new name:\t");
//                String newName = scan.nextLine();
                stmt.executeUpdate( "UPDATE Users SET NAME = '" + newName +"' WHERE ID = " + id + ";");
            }
            if (newSurname.equals("Surname")){
//                System.out.println("Enter new surname:\t");
//                String newSurname = scan.nextLine();
                stmt.executeUpdate("UPDATE Users set SURNAME = '" + newSurname + "' WHERE ID = " + id +";" );
            }
            if (newLogin.equals("Login")){
//                System.out.println("Enter new login:\t");
//                String newLogin = scan.nextLine();
                stmt.executeUpdate("UPDATE Users set LOGIN = '" + newLogin + "' WHERE ID = " + id + ";");
            }
            if (newPassword.equals("Password")){
//                System.out.println("Enter new password:\t");
//                String newLogin = scan.nextLine();
                stmt.executeUpdate("UPDATE Users set PASSWORD = '" + newLogin + "' WHERE ID = " + id + ";");
            }
        } catch (Exception e){
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

//        try {
//            //connect();
//            Class.forName("org.sqlite.JDBC");
//            c = DriverManager.getConnection("jdbc:sqlite:src/main/resources/ccms.db");
//            sqlStatement = c.prepareStatement("UPDATE Users set login = ?, password = ?, name = ?, surname = ? where ID = ?");
//            sqlStatement.setString(1, login);
//            sqlStatement.setString(2, password);
//            sqlStatement.setString(3, name);
//            sqlStatement.setString(4, surname);
//            sqlStatement.setInt(5, id);
//
//            sqlStatement.executeUpdate();
//            System.out.println("  Student " + name + " added to database successfully");
//            //return null;
//        } catch (Exception e) {
//            System.err.println(e.getClass().getName() + ": " + e.getMessage());
//            System.exit(0);
//            //disconnect();
//        } finally {
//            try {
//                sqlStatement.close();
//                c.close();
//            } catch (Exception e){
//            }
//        }
    }

    @Override
    public void addAssigment() throws NotImplementedException {

    }

    @Override
    public void gradeAssigment() throws NotImplementedException {

    }
}
