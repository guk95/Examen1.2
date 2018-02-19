/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examen1.Controller;

import examen1.Model.Tablas;
import examen1.Model.Tableget;
import examen1.View.Editdelete;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 *
 * @author Mario
 */
public class Managerforeditdelete implements ActionListener {

    Tablas tablas;
    Editdelete editdelete;
    Tableget tableget = new Tableget();

    public Managerforeditdelete(Tablas tablas, Editdelete editdelete) {

        this.editdelete = editdelete;
        this.tablas = tablas;
        this.editdelete.usingtablename.setText("Using " + tableget.getTablename());
        controllerForcombobox();
        this.editdelete.editar.addActionListener(this);
        this.editdelete.delete.addActionListener(this);
    }

    public void actionPerformed(ActionEvent evento) {
        if (editdelete.editar == evento.getSource()) {
            controllerForEdit();
        }
        if (editdelete.delete == evento.getSource()) {
            controllerforDelete();
        }

    }

    public void controllerForcombobox() {
        ArrayList nombrecolumnas = new ArrayList();
        nombrecolumnas = tablas.Nombrescolumnas(tableget.getTablename());
        for (int i = 0; i < nombrecolumnas.size(); i++) {
            editdelete.editarset.addItem(nombrecolumnas.get(i));
            editdelete.deletewhere.addItem(nombrecolumnas.get(i));
            editdelete.editarwhere.addItem(nombrecolumnas.get(i));
        }

    }

    public void controllerForEdit() {
        tablas.UpdateAnyTable(tableget.getTablename(), editdelete.editarset.getSelectedItem().toString(),
                editdelete.editarnuevo.getText(), editdelete.editarwhere.getSelectedItem().toString(),
                editdelete.editarviejo.getText());
    }

    public void controllerforDelete() {
        tablas.DeleteAnyTable(tableget.getTablename(),
                editdelete.deletewhere.getSelectedItem().toString(), editdelete.deleteviejo.getText());

    }

}
