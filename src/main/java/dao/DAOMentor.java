package dao;

import user.Mentor;
import user.Student;

import java.util.ArrayList;
import java.util.List;

public interface DAOMentor {

    Mentor getMentor(int id);
    List<Student> getStudents();
    void addStudent(Student student);
    void removeStudent(int id);
    void editStudent(int id, String newLogin, String newPassword, String newName, String newSurname);
}
