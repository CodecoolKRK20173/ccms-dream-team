import java.util.*;
public class StudentController {

    private Student loggedStudent;
    private View view;
    private DAOStudent dao;

    public StudentController(int id, View view, DAOStudent dao) {
        this.loggedStudent = createLoggedUser(id);
        this.view = view;
        this.dao = dao;
        run();
    }

    public Student createLoggedUser(int id) {
        return dao.getStudent(id);
    }


    public void run() {
        while(true) {
            view.studentMenu();
            String option = view.getOption();
            if(option.equals("1")) {
                int assignId = view.getId();
                String assignmentLink = view.getAssignmenntLink();
                this.dao.submitAssignment(this.loggedStudent, assignId, assignmentLink);
            }
            if(option.equals("2")) {
                Map<String,Integer> grades = dao.getGrades(this.loggedStudent);
                this.view.showGrades(grades);
            }
            else if(option.equals("0")) {
                System.exit(0);
            }
        }
    }
}

