import java.util.*;
public class StudentController {

    private View view;
    private DAOStudent dao;
    private DAOAssignment daoAssignment;
    private Student loggedStudent;

    public StudentController(int id, View view, DAOStudent dao, DAOAssignment daoAssignment) {
        this.view = view;
        this.dao = dao;
        this.daoAssignment = daoAssignment;
        this.loggedStudent = createLoggedUser(id);
        run();
}

    public Student createLoggedUser(int id) {
        Student student = this.dao.getStudent(id);
        return student;
    }

    public void run() {
        while(true) {
            view.studentMenu();
            String option = view.getOption();
            if(option.equals("1")) {
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
                } catch (Exception e) {
                    System.out.println("Wrong assignmnent id");
                }
            }
            else if(option.equals("2")) {
                ArrayList<Assignment> assignments = daoAssignment.getAssignments(this.loggedStudent);
                if(assignments == null) {
                    System.out.println("There is no assignment");
                    continue;
                }
                this.view.showGrades(assignments);
            }
            else if(option.equals("0")) {
                System.exit(0);
            }
        }
    }
}

