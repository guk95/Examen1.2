/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examen1.View;

import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Mario
 */
public class MainFrame extends JFrame {

    public Layout layout;
    public Layout Principal;
    public JPanel GenericPanel = new JPanel();
    public JPanel Menu = new JPanel();
    public JLabel Clock = new JLabel();
    public JPanel ClockPanel = new JPanel();
    public JButton ChatBox = new JButton();
    public JButton verTablas = new JButton();
    public JButton crearTablas = new JButton();
    public JButton editarTablas = new JButton();
    public JComboBox tablas = new JComboBox();
    public JButton abrirtabla = new JButton();

    public MainFrame() {

        this.layout = new Layout(800, 600, 4);

        Object[][] obj1
                = {
                    {Menu, 160, 600, 4},
                    {GenericPanel, 640, 600, 4}
                };
        layout.setRow(obj1);

        setTitle("Examen");
        setLayout(layout.getLayOut());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setPreferredSize(layout.setComponentDimension());
        setResizable(false);
        initComponents();
    }

    private void initComponents() {

        Layout nsPanel = new Layout(160, 600, 4);
        Layout generipanel = new Layout(600, 600, 25);
        Menu.setLayout(nsPanel.getLayOut());
        Menu.setSize(nsPanel.setComponentDimension());
        Menu.setBackground(new Color(48, 44, 43));
        GenericPanel.setLayout(generipanel.getLayOut());
        GenericPanel.setSize(generipanel.setComponentDimension());
        Clock.setBounds(generipanel.getRectangle(140, 30));
        Clock.setLocation(550, 15);
        tablas.setBounds(generipanel.getRectangle(140, 30));
        abrirtabla.setBounds(generipanel.getRectangle(140, 30));
        abrirtabla.setText("Abrir tabla");
        verTablas.setText("Ver Tablas");
        verTablas.setBounds(nsPanel.getRectangle(140, 30));
        ChatBox.setText("ChatBox");
        ChatBox.setBounds(nsPanel.getRectangle(140, 30));
        crearTablas.setText("Crear Tablas");
        crearTablas.setBounds(nsPanel.getRectangle(140, 30));
        editarTablas.setBounds(generipanel.getRectangle(140, 30));
        editarTablas.setText("Editar Tabla");
        editarTablas.setVisible(false);
        tablas.setVisible(false);
        abrirtabla.setVisible(false);
        Menu.add(verTablas);
        Menu.add(ChatBox);
        Menu.add(crearTablas);
        GenericPanel.add(Clock);
        GenericPanel.add(tablas);
        GenericPanel.add(abrirtabla);
        GenericPanel.add(editarTablas);
        add(Menu);
        pack();
        setVisible(true);
        add(GenericPanel);
        pack();
        setVisible(true);

    }

}
