/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package untils;


import controller.Validation;
import controller.VehicleList;
import java.util.Scanner;
import model.Vehicle;


/**
 *
 * @author tdinh
 */
public class Utils {

    public static String id(VehicleList list) {

        Scanner sc = new Scanner(System.in);

        String id;

        do {
            System.out.println("Id Valid example: BMW932");
            System.out.print("Input Id: ");
            id = sc.nextLine();
            
            
        } while (!Validation.idAdd(id, list));
        return id;

    }
    
    public static String idDel(){
        Scanner sc = new Scanner(System.in);
        String id;
        do{
         System.out.print("Input ID: ");
         id = sc.nextLine();
         
        }while(!Validation.idDel(id));
        
        return id;
    }

    public static String Name() {

        Scanner sc = new Scanner(System.in);
        String name = "";

        do {

            System.out.print("Input Name: ");
            name = sc.nextLine();
              
        } while (!Validation.validName(name));

        return name;

    }

    public static String Color() {
        Scanner sc = new Scanner(System.in);
        String color;

        do {
            System.out.print("Input Color: ");
            color = sc.nextLine();

        } while (!Validation.validColor(color));
        return color;
    }

    public static double Price() {

            String price;

        do {
            Scanner sc = new Scanner(System.in);
            System.out.print("Input price: ");
            price = sc.nextLine();

        } while (!Validation.validPrice(price));

        return Double.parseDouble(price);
  
    }

    
    
    public static String brand() {
        String brand;
        do {
            Scanner sc = new Scanner(System.in);
            System.out.print("Input brand: ");
            brand = sc.nextLine();

        } while (!Validation.validBrand(brand));
        return brand;

    }
    
    

    // khong su dung String;
    public static String type() {
        String type;
        do {
            Scanner sc = new Scanner(System.in);
            System.out.print("Input Type: ");
            type = sc.nextLine();

        } while (!Validation.validType(type));
        return type;
    }
    
    

    public static int proDuctYear() {
      
        String year;
        do{
            Scanner sc = new Scanner(System.in);
            System.out.print("Input year: ");
            year = sc.nextLine();
        }while(!Validation.validYear(year));
        
        return Integer.parseInt(year);
    }

    public static int getInt() {
      String choice;
        do{   
         Scanner sc = new Scanner(System.in);
        System.out.print("Input Your Choice: ");
        choice = sc.nextLine();
        
            
        }while(!Validation.validChoide(choice));
        
        return Integer.parseInt(choice);
                
    }

    
    
    // update
    public static String nameUp() {
        
         String name="";
         boolean isempty = false;
        do{
        Scanner sc = new Scanner(System.in);
        System.out.print("Input New Name: ");
        name = sc.nextLine();
        
        if(name.isEmpty()){
            isempty = true;
            break;
        }
        
        }while(!Validation.validName(name));
        
        if(isempty){
            return null;
        }
        return name;
    }

    public static String colorUp() {
      Scanner sc = new Scanner(System.in);
      String color;
      boolean isempty = false;
        do{
              
        System.out.print("Input New Color: ");
        color = sc.nextLine();
        
        if(color.isEmpty()){
            isempty = true;
            break;
                    
        }
     
        }while(!Validation.validColor(color));
        
        if(isempty){
            return null;
        }
           return color;
    }

  
    public static double priceUp(){
        Scanner sc = new Scanner(System.in);
        String price;
        boolean isempty = false;
        do{
            System.out.print("Input New Price: ");
            price = sc.nextLine();
           
            if(price.isEmpty()){
                isempty = true;
                break;
            }
           
            
        }while(!Validation.validPrice(price));
        
        if(isempty){
            return -1;
        }
        return Double.parseDouble(price);
        
        
    }

    public static String brandUp() {
       String brand;
       boolean isempty = false;
       
        do{
            Scanner sc = new Scanner(System.in);
            System.out.print("Input Brand: ");
            brand = sc.nextLine();
            
            if(brand.isEmpty()){
                isempty = true;
                break;
            }  
            
        }while(!Validation.validBrand(brand));
        
        
        if(isempty){
            return null;
        }
        
        return brand;
    }

    public static String typeUp() {
        String type;
        boolean isempty = false;
        do {
            Scanner sc = new Scanner(System.in);
            System.out.print("Input New Type: ");
            type = sc.nextLine();

            if (type.isEmpty()) {
                isempty = true;
                break;

            }
        } while (!Validation.validType(type));

        if (isempty) {
            return null;

        }

        return type;
    }

    public static int yearUp() {
     String year;
     boolean empty = false;
       do{
        Scanner sc = new Scanner(System.in);
        System.out.print("Input New Year: ");
         year = sc.nextLine();
         
        if (year.isEmpty()) {
            empty = true;
            break;
        }
 
       }while(!Validation.validYear(year));
  
       if (empty) {
            return -1;
        } 
       
       return Integer.parseInt(year);
          
    }
    
    public static boolean askContinue(String input){
        
        
        
        while(true){
            //System.out.println("Do You Want To Go Back(Y/N): ");
            
            if(input.equalsIgnoreCase("Y")){
                return true;
            }else if(input.equalsIgnoreCase("N")){
                return false;
            }else{
                System.out.println("Input not valid !!");
            }
        }
        
    }
    

//    public static boolean isIdExist(String id){
//        BufferedReader br = null;
//        
//        try {
//           br = new BufferedReader(new FileReader("src\\data\\vehicle.dat"));
//           String line;
//           
//           while( (line = br.readLine()) != null){
//               
//               if(line.equalsIgnoreCase(id)){
//                   System.out.println(line);
//                   return true;
//               }
//               
//           }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }finally{
//            try {
//                if(br != null){
//                    br.close();
//                }
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        }
//        //  Trả về false nếu không tìm thấy ID
//        return false;
//    }
}
