/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examen1.Controller;

import examen1.Model.Tablas;
import examen1.Model.Tableget;
import examen1.View.Tables;
import examen1.Model.funciones;
import examen1.View.MainFrame;
import java.sql.ResultSet;
import javax.swing.JScrollPane;

/**
 *
 * @author Mario
 */
public class ManagerTables {

    Tables tables;
    Tablas tablas;

    funciones fnc = new funciones();
    Tableget tableget = new Tableget();

    public ManagerTables(Tablas tablas, Tables tables) {
        this.tablas = tablas;
        this.tables = tables;
        controllerTable();

    }

    public void controllerTable() {
        tables.mainTable = fnc.createTable(tablas.Nombrescolumnas(tableget.getTablename()));
        tables.scrollPane = new JScrollPane(tables.mainTable);
        tables.GenericPanel.add(tables.scrollPane);
        tables.setVisible(true);
   
           ResultSet rs=tablas.datosTablas(tableget.getTablename(),tablas.Nombrescolumnas(tableget.getTablename()));
            try {
                   while (rs.next()) {
                       
                            for (int i = 0; i < tablas.Nombrescolumnas(tableget.getTablename()).size(); i++) {
                            
                            
                            }
                       
                    Object[] result = {
                        rs.getObject("idusuario"),
                        rs.getObject("Nombre"),
                        rs.getObject("Password")
                            
                    };
                    fnc.addrow(tables.mainTable, result);
                }
            } catch (Exception e) {
            }
            
      
        
        tables.pack();

    }

}
