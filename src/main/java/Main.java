public class Main {

    public static void main(String[] args) {

        View view = new View();
        String password = view.getPasswordFromUser();
        String login = view.getNickFromUser();

        MasterController masterController = new MasterController();
        masterController.login(login, password);
    }
}