/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examen1.View;

import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import examen1.Model.funciones;

public class Tables extends JFrame {

    public Layout Principal;
    public JPanel GenericPanel = new JPanel();
    public JTable mainTable = new JTable();
    funciones FNC;

    public Tables() {
        this.FNC = new funciones();
        this.Principal = new Layout(400, 450, 4);
        setTitle("ChatBox");
        setLayout(Principal.getLayOut());
        setPreferredSize(Principal.setComponentDimension());
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        initComponents();

    }

    public void initComponents() {
        Layout nsPanel = new Layout(300, 300, 4);
        ArrayList<String> cols = new ArrayList<>(Arrays.asList("idusuario", "Nombre", "Password"));
        JFrame nn = new JFrame();
        nn.setSize(nsPanel.setComponentDimension());
        JTable table = FNC.createTable(cols);
        JScrollPane scrollPane = new JScrollPane(table);
        nn.add(scrollPane);
        nn.setVisible(true);

    }

}
