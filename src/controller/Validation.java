/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import model.Vehicle;

/**
 *
 * @author tdinh
 */
public class Validation {

    public static boolean idDel(String id) {

        String reget = "^[A-Z]{3}\\d{3}$";
        Pattern pat = Pattern.compile(reget);

        while (true) {

            Matcher mat = pat.matcher(id);
            if (mat.matches()) {
                return true;
            } else {
                System.out.println("** ID NOT VALID ***");
                return false;
            }

        }

    }

    public static boolean idAdd(String id, VehicleList list){
        
        if(id.isEmpty()){
            System.out.println("You Must Be Input ID First !!!");
            return false;
        }
        
        String reget = "^[A-Z]{3}\\d{3}$";
        Pattern pat = Pattern.compile(reget);  
        Matcher mat = pat.matcher(id);    
            if(!mat.matches()){
                System.out.println("ID NOT VALID !!!");
                return false;
            }
            
            for (Vehicle vehicle : list) {
            if(vehicle.getID_Vehicle().equalsIgnoreCase(id)){
                System.out.println("*** ID Exit, Please input another ID !!! ***");
                return false;
            }
        }
            
             ArrayList<Vehicle> a = VehicleList.readFromFile();

        for (Vehicle vehicle : a) {
             if (vehicle.getID_Vehicle().equalsIgnoreCase(id)) {
                System.out.println("** ID is Exit, Please input again !!! **");
                return false;
            }
        }
         
            return true;
    
        
       
        
    }
     
    
        
//
//    public static boolean validID(String id) {
//
//        String match = "^[A-Z]{3}\\d{3}$";
//        Pattern patter = Pattern.compile(match);
//
//        Matcher mat2 = patter.matcher(id);
//        if (!mat2.matches()) {
//            System.out.println("*** Id Not Valid Please Input Again !!! ***");
//            return false;
//        }
//
//        ArrayList<Vehicle> a = VehicleList.readFromFile();
//
//        for (Vehicle vehicle : a) {
//             if (vehicle.getID_Vehicle().equalsIgnoreCase(id)) {
//                System.out.println("** ID is Exit, Please input again !!! **");
//                return false;
//            }
//        }
//        
//        ArrayList<Vehicle> b = new ArrayList();
//        
//        for (Vehicle vehicle : b) {
//            if(vehicle.getID_Vehicle().equals(id)){
//                System.out.println("** ID is Exit, Please input again !!! **");
//                return false;
//            }
//        }
//        
//
//        return true;
//
//
//
//    }

    public static boolean validName(String nameInput) {
           
        if(nameInput.isEmpty()){
            System.out.println("Name Can't be Null");
            return false;
        }
        
        String name = "^[A-Za-z0-9\\s]*$";
        Pattern pat = Pattern.compile(name);
           
        
        while (true) {
            Matcher a = pat.matcher(nameInput);

            if (a.matches()) {
                return true;
            } else {
                System.out.println("*** Name Not Valid Please Input Again !!! ***");
                return false;
            }

        }

    }

    public static boolean validColor(String color) {
       
        if(color.isEmpty()){
            System.out.println("Color Can't be Null");
            return false;
        }
        
        String col = "^[A-Za-z\\s]*$";
        Pattern pat = Pattern.compile(col);

        while (true) {
            Matcher mat = pat.matcher(color);

            if (mat.matches()) {
                return true;
            } else {
                System.out.println("*** Color input not valid ***");
                return false;
            }
        }

    }

    public static boolean validPrice(String priceInput) {
        double price;

        try {
            price = Double.parseDouble(priceInput);
            return true;
//            if(price >0){
//                return true;
//            }else{
//                System.out.println("*** Price must be large than 0!!! ***");
//                return false;
//            }
        } catch (Exception e) {
            System.out.println("*** Please enter a valid number. ***");
            return false;
        }

    }

    public static boolean validBrand(String brand) {
         if(brand.isEmpty()){
             System.out.println("Brand can't be null");
             return false;
         }
        String reget = "^[A-Za-z\\s]*$";
        Pattern pat = Pattern.compile(reget);

        while (true) {
            Matcher mat = pat.matcher(brand);

            if (mat.matches()) {
                return true;
            } else {
                System.out.println("Brand Not Valid");
                return false;
            }

        }

    }

    public static boolean validType(String typeInp) {
         if(typeInp.isEmpty()){
             System.out.println("Type Can't Be Null");
             return false;
         }
        String reget = "^[A-Za-z\\s]*$";
        Pattern pat = Pattern.compile(reget);

        while (true) {
            Matcher mat = pat.matcher(typeInp);

            if (mat.matches()) {
                return true;
            } else {
                System.out.println("***  Input type not valid !!!  ***");
                return false;
            }
        }
    }

    public static boolean validYear(String yearInp) {

        int year;

        try {
            year = Integer.parseInt(yearInp);

            if (year > 1000 && year < 3000) {
                return true;
            } else {
                System.out.println("** Year Not Valid !! **");
                return false;
            }
        } catch (Exception e) {
            System.out.println("*** Year Not Valid !!! ***");
            return false;
        }

    }
    
    public static boolean validChoide(String choiceinp){
        
        if(choiceinp.isEmpty()){
            return false;
        }
        int choice;
        
        try {
            choice = Integer.parseInt(choiceinp);
            return true;
            
        } catch (Exception e) {
            System.out.println("Choice Must Be A Number !!!");
            return false;
        }
                        
    }

}
