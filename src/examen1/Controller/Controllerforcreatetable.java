/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examen1.Controller;

import examen1.Model.Tablas;
import examen1.View.Createtable;

public class Controllerforcreatetable {

    public Controllerforcreatetable() {
    }

    public void startcreatable() {
        Tablas tablas = new Tablas();
        Createtable createtable = new Createtable();
        ManagerForCreatetable managerForCreatetable = new ManagerForCreatetable(tablas, createtable);

    }

}
