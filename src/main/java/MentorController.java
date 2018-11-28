import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public class MentorController {

    private Mentor loggedmentor;
    private View view;
    private DAOMentor dao;

    public MentorController(int id, View view, DAOMentor dao) {
        this.loggedmentor = getMentor(id);
        this.view = view;
        this.dao = dao;
    }

    public View getView() {
        return view;
    }

    public Mentor getMentor(int id) {
        return dao.getMentor(id);
    }

    public void addStudent() {

        int id = view.getId();
        String login = view.getNickFromUser();
        String password = view.getPasswordFromUser();
        String name = view.takeNameFromUser();
        String surname = view.takeSurnameFromUser();

        dao.addStudent(new Student(id, login, password, "Student", name, surname));
    }

    public void removeStudent() {
        int id = view.getId();
        dao.removeStudent(id);
    }

    public void editStudentData() {
        int id = view.getId();
        String login = view.getNickFromUser();
        String password = view.getPasswordFromUser();
        String name = view.takeNameFromUser();
        String surname = view.takeSurnameFromUser();

        dao.editStudent(id, login, password, name, surname);
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

    public void addAssigment() throws NotImplementedException {
    }

    public void gradeAssigment() throws NotImplementedException {
    }

    public void checkAttendence() throws NotImplementedException {
    }
}