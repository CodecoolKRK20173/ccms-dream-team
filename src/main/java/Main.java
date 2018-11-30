public class Main {

    public static void main(String[] args) {
        run();

    }

    public static void run() {
        View view = new View();
        boolean isActive = true;
        while (isActive) { //lipne to jest mentorzy od razu się skrzywią xD
            View.clearScreen();
            System.out.println("Welcome into CcMS\n" +
                                "(1) Login\n" +
                                "(0) Exit CcMS");
            String option = view.getOptionForMenu();

            switch (option){
                case "1":
                    String login = view.getNickFromUser();
                    String password = view.getPasswordFromUser();
                    MasterController masterController = new MasterController(view);
                    masterController.login(login, password);
                    View.clearScreen();
                    break;
                case "0":
                    isActive = false;
                    break;
                default:
                    view.clearScreen();
                    System.out.println("    Invalid option input.\n");
            }


        }
    }
}