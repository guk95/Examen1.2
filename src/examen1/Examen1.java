/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examen1;

import examen1.Controller.Controller;
import examen1.Model.ChatBox;
import examen1.Model.Tablas;
import examen1.Model.User;
import examen1.View.ChatBoxView;

/**
 *
 * @author Mario
 */
public class Examen1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

//        Controller controller= new Controller();
//        controller.Start();
        Tablas tablas = new Tablas();
        System.out.println(tablas.Contarcolumnas("ChatBox"));
        
    }
    
}
