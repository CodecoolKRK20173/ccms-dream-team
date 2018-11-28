import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public class MentorController{

    private View view;
    // private DaoMentor dao;
    public Mentor mentor;
    // public Map<Integer,Student> students;

    public MentorController(){
        // this.students = new HashMap<>();
    }

    public View getView() {
        return view;
    }

    public Mentor getMentor() {
        return mentor;
    }


    public void addStudent(int id){

    }

    public void removeStudent(int id){

    }

    public void editStudentData(int id){

    }

    public void addAssigment()throws NotImplementedException{};

    public void gradeAssigment()throws NotImplementedException{};

    public void checkAttendence()throws NotImplementedException{};
}