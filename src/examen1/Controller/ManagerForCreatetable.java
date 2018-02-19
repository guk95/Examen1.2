/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examen1.Controller;

import examen1.Model.Tablas;
import examen1.View.Createtable;

/**
 *
 * @author Mario
 */
public class ManagerForCreatetable {

    Tablas tablas;
    Createtable createtable;

    public ManagerForCreatetable(Tablas tablas, Createtable createtable) {
        this.createtable = createtable;
        this.tablas = tablas;
    }

}
