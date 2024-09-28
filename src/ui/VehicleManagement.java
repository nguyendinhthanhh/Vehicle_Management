/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import controller.Menu;
import controller.VehicleList;
import model.I_list;
import model.I_menu;
import model.Vehicle;

/**
 *
 * @author tdinh
 */
public class VehicleManagement {

    public static void main(String[] args) {
        I_menu menu = new Menu();
        menu.addItem("===================================================");
        menu.addItem("============== Vehicle Management =================");
        menu.addItem("==================================================="); 
        menu.addItem("           0. Adding new vehicle.         ");
        menu.addItem("           1. Checking exits Vehicle.");
        menu.addItem("           2. Updating vehicle.");
        menu.addItem("           3. Deleting vehicle.");
        menu.addItem("           4. Searching vehicle.");
        menu.addItem("              4.1 Searching by id.");
        menu.addItem("              4.2 Searching by name");
        menu.addItem("           5. Displaying vehicle list.");
        menu.addItem("              5.1 Displaying all.");
        menu.addItem("              5.2 Displaying all (descending by price)");
        menu.addItem("           6. Saving Vehicle to file.");
        menu.addItem("           7. Printing list Vehicles the file.");
        menu.addItem("           8. Quit");
        
        Vehicle thanh = new Vehicle("SE123", "Nguyen Dinh Thanh", "Yellow", 2003, "Viet Nam", "Adult", 21);
       Vehicle huy = new Vehicle("SE1828", "NGUYEN QUANG HUY", "YELLOW", 2003, "Viet Nam", "Adult", 21);
       
         boolean isContinue = true;
       
        int choice;
        I_list list = new VehicleList();
        do {
            menu.showMenu();
            choice = menu.getChoice();
            switch (choice) {
                case 0: {
                    list.add();
                    break;
                }

                case 1: {
                    list.exist();
                    break;

                }
                case 2:{
                    list.update();
                  break;
                }
                case 3:{
                    list.deleted();
                    break;
                }
                
                case 4:{
                    list.find();
                    break;
                }
                case 5: {
                    list.printList();
                    break;
                }
                case 6: {
                    list.saveToFile();
                    break;
                }
                case 7:{
                    list.printFile();
                    break;
                }
                
                default:{
                    System.out.println("Exiting program...");
                    isContinue = false;
                    break;
                }
                       
             
            }
        } while (isContinue);
        
    }

}
