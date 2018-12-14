package controller;

import dao.DAOAssignment;
import dao.DAOStudent;
import dao.DaoAssignment;
import display.View;
import model.Assignment;
import user.Student;

import java.util.*;
public class StudentController {

    private View view;
    private DAOStudent dao;
    private DAOAssignment daoAssignment;
    private Student loggedStudent;

    public StudentController(int id, View view, DAOStudent dao) {
        this.view = view;
        this.dao = dao;
        this.daoAssignment = new DaoAssignment();
        this.loggedStudent = createLoggedUser(id);
        run();
}

    public Student createLoggedUser(int id) {
        Student student = this.dao.getStudent(id);
        return student;
    }

    public void run() {
        boolean isRunning = true;
        while(isRunning) {
            view.printEmptyLine();
            view.studentMenu();
            String option = view.getOption();
            if(option.equals("1")) {
                view.clearScreen();
                ArrayList<Assignment> assignments = daoAssignment.getAssignments(this.loggedStudent);
                if(assignments == null) {
                    System.out.println("There is no assignment");
                    continue;
                }
                try {
                    view.showAssignmentsIdxs(assignments);
                    int assignId = view.getId();
                    String assignmentLink = view.getAssignmentLink();
                    this.daoAssignment.submitAssignment(this.loggedStudent, assignId, assignmentLink);
                } catch (NumberFormatException e) {
                    System.out.println("Wrong assignment id");
                }
            }
            else if(option.equals("2")) {
                view.clearScreen();
                ArrayList<Assignment> assignments = daoAssignment.getAssignments(this.loggedStudent);
                if(assignments == null) {
                    System.out.println("There is no assignment");
                    continue;
                }
                this.view.showGrades(assignments);
            }
            else if(option.equals("0")) {
                isRunning = false;
            }
        }
    }
}

