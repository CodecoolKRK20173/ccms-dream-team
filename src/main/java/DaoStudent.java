import java.sql.*;
import java.util.*;

public class DaoStudent implements DAOStudent{
    private Connection c = null;
    private PreparedStatement sqlStatement = null;
    private Statement stmt = null;

    public DaoStudent() { }

    public Student getStudent(int id) {
        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:src/main/resources/ccms.db");
            sqlStatement = c.prepareStatement("SELECT * FROM Users WHERE id LIKE ?");
            sqlStatement.setInt(1, id);
            ResultSet recordFromDatabase = sqlStatement.executeQuery();

            if ( recordFromDatabase.next() ) {

                int id2 = recordFromDatabase.getInt("id");
                String login = recordFromDatabase.getString("login");
                String password = recordFromDatabase.getString("password");
                String userType = recordFromDatabase.getString("userType");
                String name = recordFromDatabase.getString("name");
                String surname = recordFromDatabase.getString("surname");
                return new Student(id2, login, password, userType, name, surname);

                } else { System.out.println("Wrong id");}

            recordFromDatabase.close();
            sqlStatement.close();
            c.close();
            return null;

        } catch ( Exception e ) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        }
        return null;
    }

    public void submitAssignment(Student student, int assignId, String assignmentLink) {
        int id = student.getId();
        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:src/main/resources/ccms.db");
            sqlStatement = c.prepareStatement("SELECT * FROM Assignments WHERE id LIKE ? AND assignId LIKE ?");
            sqlStatement.setInt(1, id);
            sqlStatement.setInt(2, assignId);
            ResultSet recordFromDatabase = sqlStatement.executeQuery();

            if ( recordFromDatabase.next() ) {
                String sql = "INSERT INTO Assignments (link) " +
                        "VALUES (" + assignmentLink + ");";
                stmt.executeUpdate(sql);
            } else { System.out.println("Wrong id or assignId");}

            recordFromDatabase.close();
            sqlStatement.close();
            c.close();
        } catch ( Exception e ) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        }
    }

    public Map<String,Integer> getGrades(Student student) {
        int id = student.getId();
        Map<String, Integer> assignments = new HashMap<>();
        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:src/main/resources/ccms.db");
            sqlStatement = c.prepareStatement("SELECT * FROM Assignments WHERE id LIKE ?");
            sqlStatement.setInt(1, id);
            ResultSet recordFromDatabase = sqlStatement.executeQuery();

            if ( recordFromDatabase.next() ) {

                String title = recordFromDatabase.getString("title");
                int grade = recordFromDatabase.getInt("grade");
                assignments.put(title, grade);

            } else { System.out.println("Wrong id");}

            recordFromDatabase.close();
            sqlStatement.close();
            c.close();
            return assignments;

        } catch ( Exception e ) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        }
        return assignments;
    }

}
