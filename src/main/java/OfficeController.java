public class OfficeController {
    private int id;
    private View view;
    private DAOOffice daoOffice;


    public OfficeController(int id, View view, DAOOffice daoOffice) {
        this.id = id;
        this.view = view;
        this.daoOffice = daoOffice;
        run(); // wiem że w konstruktorze, potem wyrzucę gdzie indziej heheszki
    }


    public void run() {
        boolean isRunning = true;
        while (isRunning) {
            view.officeMenu();
            String option = view.getOptionForMenu();
            switch (option) {
                case "1":
                    view.clearScreen();
                    view.showListOfStudents(daoOffice.getStudents());
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
