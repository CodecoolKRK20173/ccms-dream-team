import sun.reflect.generics.reflectiveObjects.NotImplementedException;
import java.util.ArrayList;

public class MentorController {

    private Mentor loggedmentor;
    private View view;
    private DAOMentor dao;
    private DAOStudent daoStudent;
    private DAOAssignment daoAssignment;

    public MentorController(int id, View view, DAOMentor dao){
        this.dao = dao;
        this.loggedmentor = getMentor(id);
        this.view = view;
        this.daoAssignment = new DaoAssignment();
        this.daoStudent = new DaoStudent();
        run();
    }

    public View getView() {
        return view;
    }

    public void run(){
        boolean isActive = true;
        while (isActive){
            view.mentorMenu();
            String option = view.getOptionForMenu();

            switch (option){
                case "1":
                    View.clearScreen();
                    View.showListOfStudents(dao.getStudents());
                    break;
                case "2":
                    View.clearScreen();
                    addAssignment();
                    break;
                case "3":
                    view.clearScreen();
                    gradeStudentAssignment();
                    break;
                case "4":
                    view.clearScreen();
                    View.showListOfAssignments(daoAssignment.getAllAssignments());
                    System.out.println();
                    break;
                case "5":
                    View.clearScreen();
                    addStudent();
                    break;
                case "6":
                    View.clearScreen();
                    removeStudent();
                    break;
                case "7":
                    editStudentData();
                    break;
                case "0":
                    isActive = false;
                    break;
                default:
                    View.clearScreen();
                    System.out.println("  Invalid option input.\n");
            }
        }
    }

    public Mentor getMentor(int id){
        return dao.getMentor(id);
    }

    public void addStudent() {

        int id = 0;
        String login = view.getNickFromUser();
        String password = view.getPasswordFromUser();
        String userType = "student";
        String name = view.takeNameFromUser();
        String surname = view.takeSurnameFromUser();

        dao.addStudent(new Student(id, login, password,userType, name, surname));
    }

    public void removeStudent() {
        int id = view.getId();
        dao.removeStudent(id);
    }

    public void editStudentData() {
        String newLogin = "login";
        String newPassword = "password";
        String newName = "name";
        String newSurname = "surname";

        int id = view.getId();

        if (view.getUserChoice(newName).equals("y")){
            newName = view.takeNameFromUser();
        } else {
            newName = daoStudent.getStudent(id).getName();
        }
        if (view.getUserChoice(newSurname).equals("y")){
            newSurname = view.takeSurnameFromUser();
        } else {
            newSurname = daoStudent.getStudent(id).getSurname();
        }
        if (view.getUserChoice(newLogin).equals("y")){
            newLogin = view.getNickFromUser();
        } else {
            newLogin = daoStudent.getStudent(id).getLogin();
        }
        if (view.getUserChoice(newPassword).equals("y")){
            newPassword = view.getPasswordFromUser();
        } else {
            newPassword = daoStudent.getStudent(id).getPassword();
        }

        dao.editStudent(id,newLogin,newPassword,newName,newSurname);
    }

    public String toString() {
        StringBuilder mentorBuilder = new StringBuilder();
        mentorBuilder.append("id: ");
        mentorBuilder.append(loggedmentor.getId() + " ");
        mentorBuilder.append("login: ");
        mentorBuilder.append(loggedmentor.getLogin() + " ");
        mentorBuilder.append("user type: ");
        mentorBuilder.append(loggedmentor.getUserType() + "\n");
        mentorBuilder.append("name: ");
        mentorBuilder.append(loggedmentor.getName() + " ");
        mentorBuilder.append("surname: ");
        mentorBuilder.append(loggedmentor.getSurname());
        return mentorBuilder.toString();
    }

    public void addAssignment() {
        ArrayList<Student> students = dao.getStudents();
        String title = view.getAssignmentTitle();
        for(Student student : students) {
            Assignment assignment = new Assignment(student.getId(), title);
            daoAssignment.addAssignment(assignment);
        }
    }

    public void gradeAssigment() throws NotImplementedException {
    }

    public void checkAttendence() throws NotImplementedException {}

    public void gradeStudentAssignment(){
        daoAssignment.gradeAssigment(view.takeStudentId(), view.getAssignmentTitle(), view.enterNewGrade());
    }
}