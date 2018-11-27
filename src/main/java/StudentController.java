public class StudentController {

    private int id;
    private ViewStudent view;
    private DAOStudent dao;

    public StudentController(int id, View view, DAOStudent dao) {
        this.id = id;
        this.view = view;
        this.dao = dao;
        run();
    }


    public void run() {
        while(true) {
            view.studentMenu();
            String option = view.getOption();
            if(option.equals("1")) {
                int assignId = view.getId();
                this.dao.submitAssignment(this.id, assignId);
            }
            if(option.equals("2")) {
                String grades = dao.getGrades(this.id);
                this.view.print(grades);
            }
            else if(option.equals("0")) {
                System.exit(0);
            }
        }
    }
}

