import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class DaoAssignment implements DAOAssignment {
    private Connection c = null;
    private PreparedStatement sqlStatement = null;
    private Statement stmt = null;

    public DaoAssignment() {
    }

    public ArrayList<Assignment> getAssignments(Student student) {
        ArrayList<Assignment> assignments = new ArrayList<>();
        int studentId = student.getId();
        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:src/main/resources/ccms.db");
            sqlStatement = c.prepareStatement("SELECT * FROM Assignments WHERE studentId LIKE ?");
            sqlStatement.setInt(1, studentId);
            ResultSet recordFromDatabase = sqlStatement.executeQuery();

            if (recordFromDatabase.next()) {
                int assignId = recordFromDatabase.getInt("assignId");
                String title = recordFromDatabase.getString("title");
                String link = recordFromDatabase.getString("link");
                int grade = recordFromDatabase.getInt("grade");
                Assignment assignment = new Assignment(assignId, studentId, title, link, grade);
                assignments.add(assignment);
            } else {
                return null;
            }
            recordFromDatabase.close();
            sqlStatement.close();
            c.close();
            return assignments;

        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        return assignments;
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
}