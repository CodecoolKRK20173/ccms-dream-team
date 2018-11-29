public class Main {

    public static void main(String[] args) {
        run();

    }

    public static void run() {
        View view = new View();
        while (true) { //lipne to jest mentorzy od razu się skrzywią xD
            String login = view.getNickFromUser();
            String password = view.getPasswordFromUser();


            MasterController masterController = new MasterController(view);
            masterController.login(login, password);
            View.clearScreen();
        }
    }
}