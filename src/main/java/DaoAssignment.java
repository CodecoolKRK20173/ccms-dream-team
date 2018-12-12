import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

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

            while (recordFromDatabase.next()) {
                int assignId = recordFromDatabase.getInt("assignId");
                String title = recordFromDatabase.getString("title");
                String link = recordFromDatabase.getString("link");
                int grade = recordFromDatabase.getInt("grade");
                Assignment assignment = new Assignment(studentId, title, link, grade);
                assignment.setAssignmentId(assignId);
                assignments.add(assignment);
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
        if (assignments.isEmpty()) {
            return null;
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
        } catch ( Exception e ) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        } finally {
            try {
                sqlStatement.close();
                c.close();
            } catch (Exception e){

            }
        }
    }

    public void addAssignment(Assignment assignment) {
        int studentId = assignment.getStudentId();
        String title = assignment.getTitle();
        String link = assignment.getLink();
        int grade = assignment.getGrade();
        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:src/main/resources/ccms.db");
            sqlStatement = c.prepareStatement("INSERT INTO Assignments (studentId, title, link, grade)" +
                                                "VALUES (?, ?, ?, ?)");
            sqlStatement.setInt(1, studentId);
            sqlStatement.setString(2, title);
            sqlStatement.setString(3, link);
            sqlStatement.setInt(4, grade);
            sqlStatement.executeUpdate();
        } catch ( Exception e ) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        } finally {
            try {
                sqlStatement.close();
                c.close();
            } catch (Exception e){

            }
        }
    }

    public void gradeAssigment(int studentId, String title, int newGrade){
        Connection c = null;
        Statement stmt = null;
        try{
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:src/main/resources/ccms.db");
            stmt = c.createStatement();
            stmt.executeUpdate("UPDATE Assignments SET grade = " + newGrade + "WHERE studentId = " + studentId + "AND title = '" + title + "';");
        } catch (SQLException e){
            System.out.println(e.getClass().getName() + " : " + e.getMessage());}
    }
}