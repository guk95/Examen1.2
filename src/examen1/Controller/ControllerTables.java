/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examen1.Controller;

import examen1.Model.Tablas;
import examen1.View.Tables;

/**
 *
 * @author Mario
 */
public class ControllerTables {

    public ControllerTables() {
    }

    public void StartTables() {

        Tables tables = new Tables();
        Tablas tablas = new Tablas();
        ManagerTables managerTables = new ManagerTables(tablas, tables);

    }

}
