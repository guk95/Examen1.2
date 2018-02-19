/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examen1.Controller;


import examen1.Model.Tablas;
import examen1.View.Editdelete;

/**
 *
 * @author Mario
 */
public class Controllerforeditdelete {

    public Controllerforeditdelete() {
    }

    public void startedit() {
        Editdelete editdelete = new Editdelete();
        Tablas tablas=new Tablas();
        Managerforeditdelete managerforeditdelete = new Managerforeditdelete(tablas, editdelete);

    }

}
