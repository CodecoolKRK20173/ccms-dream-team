import java.util.Map;

public interface DAOStudent {
    public Student getStudent(int id);
    public void submitAssignment(Student student, int assignId, String assignmentLink);
    public Map<String,Integer> getGrades(Student student);
}
