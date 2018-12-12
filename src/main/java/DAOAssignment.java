import java.util.ArrayList;

public interface DAOAssignment {
    public ArrayList<Assignment> getAssignments(Student student);
    public void submitAssignment(Student student, int assignId, String assignmentLink);
    public void addAssignment(Assignment assignment);
    public void gradeAssigment(int studentId, String title, int newGrade);
    public ArrayList<Assignment> getAllAssignments();
}
