/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examen1.Model;

/**
 *
 * @author Mario
 */
public class Tableget {

    public static String tablename;

    public Tableget() {
    }

    public Tableget(String tablename) {
        this.tablename = tablename;
    }

    public static String getTablename() {
        return tablename;
    }

    public static void setTablename(String tablename) {
        Tableget.tablename = tablename;
    }

}
