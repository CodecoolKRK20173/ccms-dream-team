import java.util.ArrayList;
import java.util.Scanner;

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

    public String getNickFromUser(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter nick:\t");
        String nick = scanner.nextLine();
        scanner.close();
        return nick;
    }

    public String getPasswordFromUser(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter password:\t");
        String password = scanner.nextLine();
        scanner.close();
        return password;
    }

    public String takeNameFromUser(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter name:\t");
        String name = scanner.nextLine();
        scanner.close();
        return name;
    }

    public String takeSurnameFromUser(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter surmane:\t");
        String surname = scanner.nextLine();
        scanner.close();
        return surname;
    }

    public void showStudentsList(ArrayList studentsList){
        for (int i = 0; i <= studentsList.size(); i++ ){
            System.out.println(studentsList.get(i));
        }
    }

    public void showMentorsList (ArrayList mentorsList){
        for (int i = 0; i <= mentorsList.size(); i++) {
            System.out.println(mentorsList.get(i));
        }
    }
}
