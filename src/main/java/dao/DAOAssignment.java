package dao;

import model.Assignment;
import user.Student;

import java.util.ArrayList;

public interface DAOAssignment {
    ArrayList<Assignment> getAssignments(Student student);
    void submitAssignment(Student student, int assignId, String assignmentLink);
    void addAssignment(Assignment assignment);
    void gradeAssigment(int studentId, String title, int newGrade);
    ArrayList<Assignment> getAllAssignments();
}
