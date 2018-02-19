/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examen1.Controller;

import examen1.Model.Tablas;
import examen1.Model.Tableget;
import examen1.View.Createtable;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 *
 * @author Mario
 */
public class ManagerForCreatetable implements ActionListener {

    Tablas tablas;
    Createtable createtable;
    Tableget tableget = new Tableget();

    public ManagerForCreatetable(Tablas tablas, Createtable createtable) {
        this.createtable = createtable;
        this.tablas = tablas;
        controllerfordata();
        controllercolectdata();
        this.createtable.creartabla.addActionListener(this);
    }

    public void controllerfordata() {

        for (int i = 0; i < tableget.numberofcolumns; i++) {
            createtable.fields[i].setVisible(true);
            createtable.comboBoxs[i].setVisible(true);
        }

    }

    public void actionPerformed(ActionEvent evento) {
    }

    public void controllercolectdata() {
        ArrayList data = new ArrayList();
        for (int i = 0; i < tableget.numberofcolumns; i++) {
            data.add(createtable.fields[i]);
            data.add(createtable.comboBoxs[i].getSelectedItem().toString());
        }

    }

}
