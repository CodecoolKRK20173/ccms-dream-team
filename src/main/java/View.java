import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.io.Console;
import java.util.ArrayList;
import java.util.Map;
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

    public String getAssignmenntLink() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Put the assignment link: ");
        String link = scanner.nextLine();
        scanner.close();
        return link;
    }

    public int getOption(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter option number: ");
        int option = scanner.nextInt();
        //scanner.close();
        return option;
    }

    public int getId(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter id: ");
        String id = scanner.nextLine();
        scanner.close();
        return Integer.parseInt(id);
    }

    public String getNickFromUser(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter nick: ");
        String nick = scanner.nextLine();
        //scanner.close();
        return nick;
    }

    public String getPasswordFromUser(){
//        Console cnsl = null;
//        try {
//            cnsl = System.console();
//            if (cnsl != null) {
//                //login = cnsl.readLine("Please provide a username: ");
//                char[] pwd = cnsl.readPassword("Enter password: ");
//                String password = String.valueOf(pwd);
//                return password;
//            }
//        } catch(Exception ex) {
//            ex.printStackTrace();
//        }
//        return null;
//    }
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter password:\t");
        String password = scanner.nextLine();
        //scanner.close();
        return password;
    }

    public String takeNameFromUser(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter name:\t");
        String name = scanner.nextLine();
        //scanner.close();
        return name;
    }

    public String takeSurnameFromUser(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter surname:\t");
        String surname = scanner.nextLine();
        //scanner.close();
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

    public void showGrades (Map<String,Integer> grades){
        for(Map.Entry<String,Integer> entry : grades.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    public static void showListOfStudents(ArrayList<Student> students) {

        String leftAlignFormat = "|  %-3d | %-12s |  %-12s  |  %-12s  |  %-10s  |%n";
        System.out.format("+------+--------------+----------------+----------------+--------------+%n");
        System.out.format("|  ID  |  Login       |  Name          |  Surname       |   User type  |%n");
        System.out.format("+------+--------------+----------------+----------------+--------------+%n");

        for (int i = 0; i < students.size() ; i++) {
            int id = students.get(i).getId();
            String login = students.get(i).getLogin();
            String name = students.get(i).getName();
            String surname = students.get(i).getSurname();
            String userType = students.get(i).getUserType();
            System.out.format(leftAlignFormat, id, login, userType, name, surname);
        }
        System.out.format("+------+--------------+----------------+----------------+--------------+%n");
    }

    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static void showListOfMentors(ArrayList<Mentor> mentors) {

        String leftAlignFormat = "|  %-3d | %-12s |  %-12s  |  %-12s  |  %-10s  |%n";
        System.out.format("+------+--------------+----------------+----------------+--------------+%n");
        System.out.format("|  ID  |  Login       |  Name          |  Surname       |   User type  |%n");
        System.out.format("+------+--------------+----------------+----------------+--------------+%n");

        for (int i = 0; i < mentors.size() ; i++) {
            int id = mentors.get(i).getId();
            String login = mentors.get(i).getLogin();
            String name = mentors.get(i).getName();
            String surname = mentors.get(i).getSurname();
            String userType = mentors.get(i).getUserType();
            System.out.format(leftAlignFormat, id, login, userType, name, surname);
        }
        System.out.format("+------+--------------+----------------+----------------+--------------+%n");
    }

    public String getOptionForMenu(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter option number: ");
        String option = scanner.nextLine();
        //scanner.close();
        return option;
    }
}
