public class Main {

    public static void main(String[] args) {
        run();

    }

    public static void run() {
        View view = new View();
        String password = view.getPasswordFromUser();
        String login = view.getNickFromUser();

        MasterController masterController = new MasterController(View view);
        masterController.login(login, password);
    }
}