/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.ArrayList;
import model.I_menu;
import untils.Utils;

/**
 *
 * @author tdinh
 */
public class Menu extends ArrayList<String>implements I_menu{

    @Override
    public void addItem(String s) {
        this.add(s);
    }


    @Override
    public int getChoice() {
      
        int choice = Utils.getInt();
        
        return choice;
    }

    @Override
    public void showMenu() {
        for (String thi : this) {
            System.out.println(thi);
        }
    }

    @Override
    public boolean confrimYesNo(String inp) {
       
        return Utils.askContinue(inp);
    }


    
}
