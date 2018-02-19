/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examen1.View;

import examen1.Model.Tableget;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

/**
 *
 * @author Mario
 */
public class Createtable extends JFrame {

    public Layout layout;
    public Layout Principal;
    public JPanel GenericPanel = new JPanel();
    JTextField[] fields = new JTextField[15];
    JComboBox[] comboBoxs = new JComboBox[15];
    JLabel columnas = new JLabel();
    JLabel tipodato = new JLabel();
    JButton creartabla = new JButton();

    public Createtable() {

        this.layout = new Layout(1200, 1200, 4);
        setTitle("Examen");
        setLayout(layout.getLayOut());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setPreferredSize(layout.setComponentDimension());
        setResizable(false);
        initComponents();
    }

    private void initComponents() {
        String[] datos = {
            "INT", "VARCHAR", "DATETIME"
        };

        Layout generipanel = new Layout(1200, 1200, 25);
        GenericPanel.setLayout(generipanel.getLayOut());
        GenericPanel.setSize(generipanel.setComponentDimension());
        Object[][] obj2
                = {
                    {columnas, 160, 30, "Nombre Columna"},
                    {tipodato, 160, 30, "Tipo de dato"}
                };
        generipanel.setRow(obj2);
        creartabla.setBounds(generipanel.getRectangle(140, 30));
        for (int i = 0; i < 15; i++) {
            fields[i] = new JTextField("Your Value");
            comboBoxs[i] = new JComboBox(datos);
            Object[][] obj3
                    = {
                        {fields[i], 160, 30, 4},
                        {comboBoxs[i], 160, 30, 4}
                    };
            generipanel.setRow(obj3);
            GenericPanel.add(fields[i]);
            GenericPanel.add(comboBoxs[i]);
        }
        GenericPanel.add(tipodato);
        GenericPanel.add(columnas);
        GenericPanel.add(creartabla);
        add(GenericPanel);
        pack();
        setVisible(true);

    }

}
