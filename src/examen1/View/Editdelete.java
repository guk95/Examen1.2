/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examen1.View;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 *
 * @author Mario
 */
public class Editdelete extends JFrame {

    public Layout Principal;
    public JLabel usingtablename = new JLabel();
    public JLabel labelEditar = new JLabel();
    public JLabel labelset = new JLabel();
    public JLabel labelwhere = new JLabel();
    public JPanel GenericPanel = new JPanel();
    public JButton editar = new JButton();
    public JComboBox editarset = new JComboBox();
    public JTextField editarnuevo = new JTextField();
    public JComboBox editarwhere = new JComboBox();
    public JTextField editarviejo = new JTextField();
    public JLabel labelwheredelete = new JLabel();
    public JLabel labelDelete = new JLabel();
    public JTextField deleteviejo = new JTextField();
    public JButton delete = new JButton();
    public JComboBox deletewhere = new JComboBox();

    public Editdelete() {
        this.Principal = new Layout(1300, 1300, 4);
        setTitle("ChatBox");
        setLayout(Principal.getLayOut());
        setPreferredSize(Principal.setComponentDimension());
        setResizable(false);
        initComponents();
    }

    private void initComponents() {
        Layout nsPanel = new Layout(1300, 1300, 40);
        GenericPanel.setLayout(nsPanel.getLayOut());
        GenericPanel.setSize(nsPanel.setComponentDimension());
        usingtablename.setBounds(nsPanel.getRectangle(250, 30));
        usingtablename.setText("Tabla");
        labelEditar.setBounds(nsPanel.getRectangle(250, 30));
        labelEditar.setText("Editar");
        editar.setText("Editar");
        delete.setText("Borrar");
        labelset.setBounds(nsPanel.getRectangle(250, 30));
        labelset.setText("Set");

        Object[][] obj1
                = {
                    {editarset, 160, 30, 4},
                    {editarnuevo, 160, 30, 4}
                };
        nsPanel.setRow(obj1);
        labelwhere.setBounds(nsPanel.getRectangle(250, 30));
        labelwhere.setText("Where");
        Object[][] obj2
                = {
                    {editarwhere, 160, 30, 4},
                    {editarviejo, 160, 30, 4}
                };
        nsPanel.setRow(obj2);
        editar.setBounds(nsPanel.getRectangle(140, 30));
        labelDelete.setBounds(nsPanel.getRectangle(250, 30));
        labelDelete.setText("Borrar");
        labelwheredelete.setBounds(nsPanel.getRectangle(250, 30));
        labelwheredelete.setText("Where");
        Object[][] obj3
                = {
                    {deletewhere, 160, 30, 4},
                    {deleteviejo, 160, 30, 4}
                };
        nsPanel.setRow(obj3);
        delete.setBounds(nsPanel.getRectangle(140, 30));

        GenericPanel.add(usingtablename);
        GenericPanel.add(editarset);
        GenericPanel.add(editarnuevo);
        GenericPanel.add(editarwhere);
        GenericPanel.add(editarviejo);
        GenericPanel.add(editar);
        GenericPanel.add(labelEditar);
        GenericPanel.add(labelDelete);
        GenericPanel.add(deletewhere);
        GenericPanel.add(deleteviejo);
        GenericPanel.add(delete);
        GenericPanel.add(labelset);
        GenericPanel.add(labelwhere);
        GenericPanel.add(labelwheredelete);
        add(GenericPanel);
        pack();
        setVisible(true);

    }

}
