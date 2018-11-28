public class OfficeController {
    private int id;
    private View view;
    private DaoOffice daoOffice;


    public OfficeController(int id, View view, DaoOffice daoOffice) {
        this.id = id;
        this.view = view;
        this.daoOffice = daoOffice;
        daoOffice.getStudents(); //usunąć przed pushem
        run(); // wiem że w konstruktorze, potem wyrzucę gdzie indziej heheszki
    }


    public void run() {
        boolean isRunning = true;
        while (isRunning) {
            view.officeMenu();
            //int option = view.getOption();
            int option = 1;
            switch (option) {
                case 1:
                    System.out.println("list students here");
                    isRunning = false; //to usunac potem heheszki
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
