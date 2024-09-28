/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author tdinh
 */
public interface I_menu {
    void addItem(String s);
    int getChoice();
    void showMenu();
    boolean confrimYesNo(String inp);
}
