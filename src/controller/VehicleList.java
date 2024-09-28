/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Scanner;
import model.I_list;
import model.I_menu;
import model.Vehicle;
import untils.Utils;

/**
 *
 * @author tdinh
 */
public class VehicleList extends ArrayList<Vehicle> implements I_list {

    //0
    @Override
    public void add() {

        boolean addConfirm = true;

        while (addConfirm) {
           // String inputId = Utils.id();
           String inputId = Utils.id(this);
            String name = Utils.Name();
            String color = Utils.Color();
            double price = Utils.Price();
            String brand = Utils.brand();
            String type = Utils.type();
            int productYear = Utils.proDuctYear();

            Vehicle vehicle = new Vehicle(inputId, name, color, price, brand, type, productYear);
            try {
                this.add(vehicle);
                System.out.println("** Add Suceess **");
            } catch (Exception e) {
                System.out.println("** Add fail !!! **" + e.getMessage());
            }

            Scanner sc = new Scanner(System.in);
            I_menu menu = new Menu();

            System.out.print("Do You Want To Go Back Main Screen? (Y/N): ");
            String inp = sc.nextLine();
            addConfirm = !menu.confrimYesNo(inp);
            //addConfirm = !Utils.askContinue(inp);

        }

    }

    //1
    @Override
    public void exist() {

        boolean isContinue = true;

        while (isContinue) {
            String id = Utils.idDel();
            boolean isExit = false;
            ArrayList<Vehicle> vehi = readFromFile();

            if (vehi.isEmpty()) {
                System.out.println("Your List Is Empty");
                return;
            }

            for (Vehicle vehicle : vehi) {
                if (vehicle.getID_Vehicle().equalsIgnoreCase(id)) {
                    System.out.println("Exist Vehicle");
                    System.out.println(vehicle);
                    isExit = true;
                }
            }
            if (!isExit) {
                System.out.println("No Vehicle Found!");
            }
            Scanner sc = new Scanner(System.in);
            I_menu menu = new Menu();
            System.out.print("Do You Want To Go Back Main Screen? (Y/N): ");
            String inp = sc.nextLine();
            isContinue = !menu.confrimYesNo(inp);

        }

    }

    //2
    @Override
    public void update() {

        ArrayList<Vehicle> vehi = readFromFile();
        String id = Utils.idDel();
        boolean idExist = false;
        for (Vehicle vehicle : vehi) {
            if (vehicle.getID_Vehicle().equalsIgnoreCase(id)) {
                //  System.out.println("ID Exist");
                idExist = true;
            }
        }

        if (!idExist) {
            System.out.println("Vehicle does not exist");
            return;
        }

        String name = Utils.nameUp();
        String color = Utils.colorUp();
        double price = Utils.priceUp();
        String brand = Utils.brandUp();
        String type = Utils.typeUp();
        int year = Utils.yearUp();

        for (Vehicle veh : vehi) {

            if (veh.getID_Vehicle().equalsIgnoreCase(id)) {

                if (name != null) {
                    veh.setName_Vehicle(name);
                }

                if (color != null) {
                    veh.setColor_Vehicle(color);
                }
                if (price != -1) {
                    veh.setPrice_Vehicle(price);
                }

                if (brand != null) {
                    veh.setBrand_Vehicle(brand);
                }

                if (type != null) {
                    veh.setType(type);
                }
                if (year != -1) {
                    veh.setProductYear(year);
                }

            }

        }

        try {
            FileOutputStream fi = new FileOutputStream("src\\data\\vehicle.dat");// DAY

            ObjectOutputStream ois = new ObjectOutputStream(fi);

            ois.writeObject(vehi);
           // ois.close();
            System.out.println("** Update Successfull !!! **");

        } catch (Exception e) {
            System.out.println("** Update Fail **");
        }

    }

    //3
    @Override
    public void deleted() {

        Scanner sc = new Scanner(System.in);
        System.out.print("Input Id: ");
        String id = sc.nextLine();

        if (id.isEmpty()) {
            System.out.println("You Need To Input Id You Want To Deleted First");
            return;
        }

        ArrayList<Vehicle> vehicle = readFromFile();
        boolean constran = false;

        for (Vehicle vehicle1 : vehicle) {
            if (vehicle1.getID_Vehicle().equalsIgnoreCase(id)) {
                //   System.out.println(vehicle1.toString());
                constran = true;
            }
        }

        if (constran) {
            System.out.println("Id Found");
        } else {
            System.out.println("Id Not Found !!!");
            return;
        }

        boolean isContinue = true;
        I_menu menu = new Menu();
        System.out.print("Do You Want To Deleted: " + id + " (Y/N): ");
        String inp = sc.nextLine();
        
        isContinue = menu.confrimYesNo(inp);
        if (!isContinue) {
            return;
        }

        Iterator<Vehicle> ite = vehicle.iterator();

        while (ite.hasNext()) {
            Vehicle vehi = ite.next();

            if (vehi.getID_Vehicle().equalsIgnoreCase(id)) {
                ite.remove();
                break;
            }
        }

        try (
                FileOutputStream fo = new FileOutputStream("src\\data\\vehicle.dat");
                ObjectOutputStream ou = new ObjectOutputStream(fo)) {

            ou.writeObject(vehicle);

            System.out.println("Remove Success !!");

        } catch (Exception e) {
            System.out.println("Error" + e.getMessage());

        }

    }

    //4
    @Override
    public void find() {
        boolean stop = true;
        I_menu menu = new Menu();
        int choice;

        ArrayList<Vehicle> vehi = readFromFile();
        
        

        do {
            System.out.println("===================");
            System.out.println("1.Serch By Id");
            System.out.println("2.Serch By Name");
            System.out.println("Input another will back to main screen");
            choice = menu.getChoice();
            switch (choice) {

                case 1: {
                    String id = Utils.idDel();
                    boolean constain = false;

//                      Collections.sort(vehi, new Comparator<Vehicle>() {
//                      public int compare(Vehicle v1, Vehicle v2) {
//                       return v1.getName_Vehicle().compareToIgnoreCase(v2.getName_Vehicle());
//                               }
//                         });
                    for (Vehicle vehicle : vehi) {
                        if (vehicle.getID_Vehicle().equalsIgnoreCase(id)) {
                            System.out.println("ID Found: " + vehicle);
                            constain = true;

                        }
                    }

                    if (!constain) {
                        System.out.println("ID Not Found !!!");
                    }

                    break;
                }

                case 2: {
                    String name = Utils.Name();
                    boolean isexit = false;

                    Collections.sort(vehi, new Comparator<Vehicle>() {
                        @Override
                        public int compare(Vehicle o1, Vehicle o2) {
                            return o1.getName_Vehicle().compareToIgnoreCase(o2.getName_Vehicle());

                        }
                    });

                    for (Vehicle vehicle : vehi) {
                        if (vehicle.getName_Vehicle().equalsIgnoreCase(name)) {
                            System.out.println("Name Found: " + vehicle);
                            isexit = true;
                        }
                    }

                    if (!isexit) {
                        System.out.println("Name Not Found !!!");
                    }
                    break;

                }

                default: {
                    stop = false;
                }

            }

        } while (stop);

    }


    //5 
    @Override
    public void printList() {
        I_menu menu = new Menu();
        int choice;
        boolean isContinue = true;

        do {
            System.out.println("========================================");
            System.out.println("Displaying vehicle list.");
            System.out.println("1. Displaying all");
            System.out.println("2. Displaying all (descending by price)");
            System.out.println("3. Ouit");
            choice = menu.getChoice();

            switch (choice) {

                case 1: {
                    if (this.isEmpty()) {
                        System.out.println("List Is Empty !!!");
                        return;
                    }
                    for (Vehicle vehicle1 : this) {
                        System.out.println(vehicle1);
                    }
                    break;
                }

                case 2: {
                    if (this.isEmpty()) {
                        System.out.println("List Is Empty !!!");
                        return;
                    }
                    Collections.sort(this, new Comparator<Vehicle>() {
                        @Override
                        public int compare(Vehicle o1, Vehicle o2) {
                            return Double.compare(o2.getPrice_Vehicle(), o1.getPrice_Vehicle());
                        }
                    });

                    for (Vehicle thi : this) {
                        System.out.println(thi);
                    }
                    break;
                }

                default: {
                    isContinue = false;
                    break;
                }

            }

        } while (isContinue);

    }

    //6
    @Override
    public void saveToFile() {
        ArrayList<Vehicle> vehicle = readFromFile();
        vehicle.addAll(this);

        try (
                FileOutputStream fos = new FileOutputStream("src\\data\\vehicle.dat");
                ObjectOutputStream os = new ObjectOutputStream(fos)) {

            os.writeObject(vehicle);
            System.out.println("Save Sucess !!");

        } catch (Exception e) {
            System.out.println("Can't Save File: " + e.getMessage());
        }

    }

    // done //
    public static ArrayList<Vehicle> readFromFile() {
        ArrayList<Vehicle> arr = new ArrayList<>();

        try (
                FileInputStream fi = new FileInputStream("src\\data\\vehicle.dat");
                ObjectInputStream ois = new ObjectInputStream(fi)) {

            arr = (ArrayList<Vehicle>) ois.readObject();

        } catch (FileNotFoundException e) {
            System.out.println("File Not Found: " + e.getMessage());
        } catch (IOException e) {
            e.printStackTrace();
            //System.out.println("Error Reading File: " + e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println("Class Not Found: " + e.getMessage());
        }

        return arr;
    }

    //7
//    @Override
//    public void printFile() {
//        ArrayList<Vehicle> a = readFromFile();
//
//        if (a.isEmpty()) {
//            System.out.println("File contains no data !!!");
//            return;
//        }
//        for (Vehicle vehicle : a) {
//            System.out.println(vehicle);
//        }
//    }

    @Override
    public void printFile() {

        I_menu menu = new Menu();

        boolean isContinue = true;
        int choice;
        do {
            System.out.println("========================================");
            System.out.println("Displaying vehicle list in file");
            System.out.println("1. Displaying all");
            System.out.println("2. Displaying all (descending by price)");
            System.out.println("Other: quit");
            choice = menu.getChoice();
            ArrayList<Vehicle> a = readFromFile();
            switch (choice) {
                
                case 1: {
                  

                    if (a.isEmpty()) {
                        System.out.println("File contains no data !!!");
                        return;
                    }
                    for (Vehicle vehicle : a) {
                        System.out.println(vehicle);
                    }
                    
                 break;
                }
                
                case 2: {
                    
                    if(a.isEmpty()){
                        System.out.println("File contains no data !!!");
                        return;
                    }
                    
                    Collections.sort(a, new Comparator<Vehicle>() {
                        @Override
                        public int compare(Vehicle o1, Vehicle o2) {
                            return Double.compare(o2.getPrice_Vehicle(), o1.getPrice_Vehicle());
                        }
                    }) ;
                    
                    for (Vehicle vehicle : a) {
                        System.out.println(vehicle);
                    }
                    break;
                }
                
                
                default :{
                    isContinue = false;
                    break;
                }
            }

     

        } while (isContinue);

    }

}
