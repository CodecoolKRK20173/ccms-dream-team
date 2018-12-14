package controller;

import dao.DAOOffice;
import display.View;

public class OfficeController {
    private int id;
    private View view;
    private DAOOffice daoOffice;


    public OfficeController(int id, View view, DAOOffice daoOffice) {
        this.id = id;
        this.view = view;
        this.daoOffice = daoOffice;
        run();
    }


    public void run() {
        String option = "";

        while (!option.equals("0")) {
            view.officeMenu();
            option = view.getOptionForMenu();
            switch (option) {
                case "1":
                    view.clearScreen();
                    view.showListOfStudents(daoOffice.getStudents());
                    break;
                default:
                    view.clearScreen();
                    System.out.println("  Invalid option input.\n");
                    break;
            }
        }
    }
}
