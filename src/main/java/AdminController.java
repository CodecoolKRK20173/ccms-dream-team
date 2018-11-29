public class AdminController {
    private View view;
    private Admin admin;
    private DaoAdmin daoAdmin;


    public AdminController(int id, View view, DaoAdmin daoAdmin) {
        this.view = view;
        this.admin = admin;
        this.daoAdmin = daoAdmin;
        menuWork();
    }

    public void menuWork() {
        boolean isRunning = true;
        while (isRunning) {
            view.adminMenu();
            String opt = view.getOptionForMenu();

            switch (opt) {
                case "1":
                    view.clearScreen();
                    view.showListOfMentors(daoAdmin.getMentors());
                    break;
                case "2":
                    view.clearScreen();
                    view.showListOfStudents(daoAdmin.getStudents());
                    break;
                case "3":
                    int id = 0;
                    String login = view.getNickFromUser();
                    String password = view.getPasswordFromUser();
                    String userType = "mentor";
                    String name = view.takeNameFromUser();
                    String surname = view.takeSurnameFromUser();

                    Mentor mentor = new Mentor(id, login, password, userType, name, surname);
                    daoAdmin.addMentor(mentor);
                    break;
                case "4":
                    //int userId = view.getIdFromUser();
                    //admin.removeMentor(view.getIdFromUser());
                    break;
                case "5":
                    int userId = view.getId();
                    daoAdmin.editMentor(userId);
                    break;
                case "0":
                    isRunning = false;
                    break;
                default:
                    view.clearScreen();
                    System.out.println("  Invalid option input.\n");
                    break;
            }
        }
    }
}
