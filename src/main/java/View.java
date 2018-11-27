


public class View {
    public void adminMenu(){
        System.out.println("What would you like to do:\n " +
                " (1) List mentors\n " +
                " (2) List students\n " +
                " (3) Add mentor\n " +
                " (4) Remove mentor\n" +
                " (5) Edit mentor\n" +
                " (0) Exit CcMS");
    }

    public void officeMenu(){
        System.out.println("What would you like to do:\n" +
                " (1) List students\n" +
                " (0) Exit CcMS");
    }

    public void mentorMenu(){
        System.out.println("What would you like to do:\n" +
                " (1) List students\n" +
                " (2) Add assignment\n" +
                " (3) Grade assignment\n" +
                " (4) Attendance check\n" +
                " (5) Add student\n" +
                " (6) Remove student\n" +
                " (7) Edit student\n" +
                " (0) Exit CcMS");
    }

    public void studentMenu(){
        System.out.println("What would you like to do:\n" +
                " (1) Submit assignment\n" +
                " (2) View grades\n" +
                " (0) Exit CcMS");
    }
}
