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
            int option = view.getOption();
            switch (option) {
                case 1:
                    System.out.println("list students here");
                    daoOffice.getStudents();
                    break;
                case 0:
                    isRunning = false;
                    break;
                default:
                    System.out.println("  Invalid option input.");
            }
        }
    }



}
