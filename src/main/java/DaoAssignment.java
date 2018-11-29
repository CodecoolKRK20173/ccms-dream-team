import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class DaoAssignment implements DAOAssignment {
    private Connection c = null;
    private PreparedStatement sqlStatement = null;

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
            sqlStatement = c.prepareStatement("UPDATE Assignments SET link = ? WHERE assignId = ? AND studentId = ?");
            sqlStatement.setString(1, assignmentLink);
            sqlStatement.setInt(2, assignId);
            sqlStatement.setInt(3, id);

            sqlStatement.executeUpdate();
            System.out.println("mmmmmmmmmmmmmmmmmmmmmmmmmmmmmm");
            sqlStatement.close();
            c.close();
        } catch ( Exception e ) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        }
    }
}