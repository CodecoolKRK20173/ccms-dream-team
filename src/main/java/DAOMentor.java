import java.util.ArrayList;

public interface DAOMentor {

    public Mentor getMentor(int id);
    public ArrayList<Student> getStudents();
    public void addStudent(Student student);
    public void removeStudent(int id);
    public void editStudent(int id);
    public void addAssigment();
    public void gradeAssigment();
}
