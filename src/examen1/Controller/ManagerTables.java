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
import java.sql.ResultSet;
import java.util.ArrayList;
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
        ArrayList nombrecolumnas = new ArrayList();
        nombrecolumnas = tablas.Nombrescolumnas(tableget.getTablename());

        tables.mainTable = fnc.createTable(nombrecolumnas);
        tables.scrollPane = new JScrollPane(tables.mainTable);

        ResultSet rs = tablas.datosTablas(tableget.getTablename(), nombrecolumnas);
          Object[] objects = new Object[] { 
                };
          
        try {
            while (rs.next()) {
                    ArrayList result = new ArrayList();
                for (int i = 0; i < nombrecolumnas.size(); i++) {
                   
                        result.add(rs.getObject(nombrecolumnas.get(i).toString()));
                    
                }
             objects=result.toArray();                
              
                 fnc.addrow(tables.mainTable, objects);

            }
        } catch (Exception e) {
        }
        tables.GenericPanel.add(tables.scrollPane);
        tables.setVisible(true);
        tables.pack();

    }

}
