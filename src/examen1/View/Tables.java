/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examen1.View;

import examen1.Model.Tablas;
import examen1.Model.Tableget;
import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import examen1.Model.funciones;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JComboBox;

public class Tables extends JFrame {

    public Layout Principal;
    public JPanel GenericPanel = new JPanel();
    public JTable mainTable;
    public JScrollPane scrollPane;
    funciones FNC;
    Tableget tableget = new Tableget();

    public Tables() {
        this.FNC = new funciones();
        this.Principal = new Layout(1000, 1000, 4);
        setTitle("Tables");
        setLayout(Principal.getLayOut());
        setPreferredSize(Principal.setComponentDimension());

        initComponents();

    }

    public void initComponents() {

        Layout GenericnsPanel = new Layout(600, 600, 4);
        GenericPanel.setSize(GenericnsPanel.setComponentDimension());
        setVisible(true);
        add(GenericPanel);
        pack();

    }

}
