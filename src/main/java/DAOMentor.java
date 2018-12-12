import java.util.ArrayList;

public interface DAOMentor {

    public Mentor getMentor(int id);
    public ArrayList<Student> getStudents();
    public void addStudent(Student student);
    public void removeStudent(int id);
    public void editStudent(int id,String newLogin, String newPassword, String newName, String newSurname );
    public void addAssigment();
    public void gradeAssigment();
}
