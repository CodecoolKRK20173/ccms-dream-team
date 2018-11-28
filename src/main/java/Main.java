public class Main {

    public static void main(String[] args) {
        run();

    }

    public static void run() {
        View view = new View();
        String login = view.getNickFromUser();
        String password = view.getPasswordFromUser();


        MasterController masterController = new MasterController(view);
        masterController.login(login, password);
    }
}