

public class AdminControler {
    private View view;
    private Admin admin;

    public AdminControler(){
        this.view = view;
        this.admin = admin;
    }

    public void menuWork(){
        view.adminMenu();
        int opt = view.getOption();

        switch (opt){
            case 1:
                view.showMentorsList(mentorList);
                break;
            case 2:
                view.showStudentsList(studentsList);
                break;
            case 3:
                String mentorLogin = view.takeLoginFromUser();
                String mentorName = view.takeNameFromUser();
                String mentorSurname = view.takeSurnameFromUser();
                String mentorPasword = view.takePasswordFromUser();
                String uType = view.takeUserType();
                admin.addMentor(mentorLogin, mentorName, mentorSurname, mentorPasword, uType);
                break;
            case 4:
                //int userId = view.getIdFromUser();
                admin.removeMentor(view.getIdFromUser());
                break;
            case 5:
                //int userId = view.getIdFromUser();
                admin.editMentorData(view.getIdFromUser());
                break;
            case 0:
                System.exit(0);
                break;
        }
    }
}
