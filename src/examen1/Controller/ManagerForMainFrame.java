/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examen1.Controller;

import examen1.Model.ChatBox;

import examen1.View.ChatBoxView;
import examen1.View.MainFrame;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import examen1.Model.Tablas;
import examen1.Model.Tableget;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Mario
 */
public class ManagerForMainFrame implements ActionListener {

    MainFrame mainFrame;
    ChatBox chatBox;

    public ManagerForMainFrame() {

    }

    public ManagerForMainFrame(MainFrame mainFrame, ChatBox chatBox) {
        this.mainFrame = mainFrame;
        this.chatBox = chatBox;
        Controllerclock();
        this.mainFrame.ChatBox.addActionListener(this);
        this.mainFrame.verTablas.addActionListener(this);
        this.mainFrame.abrirtabla.addActionListener(this);
        this.mainFrame.editarTablas.addActionListener(this);
        this.mainFrame.crearTablas.addActionListener(this);

    }

    public void actionPerformed(ActionEvent evento) {

        if (mainFrame.ChatBox == evento.getSource()) {
            mainFrame.editarTablas.setVisible(false);
            mainFrame.tablas.setVisible(false);
            mainFrame.abrirtabla.setVisible(false);
            ControllerForChatBox controllerForChatBox = new ControllerForChatBox();
            controllerForChatBox.StartControllerForChatBox();
        }
        if (mainFrame.verTablas == evento.getSource()) {
            mainFrame.editarTablas.setVisible(true);
            controllerllenarCombobox();
            mainFrame.tablas.setVisible(true);
            mainFrame.abrirtabla.setVisible(true);
        }
        if (mainFrame.abrirtabla == evento.getSource()) {
            Tableget tableget = new Tableget();
            tableget.setTablename(mainFrame.tablas.getSelectedItem().toString());
            ControllerTables controllerTables = new ControllerTables();
            controllerTables.StartTables();
        }
        if (mainFrame.crearTablas == evento.getSource()) {
            Tableget tableget = new Tableget();

            if (Integer.parseInt(mainFrame.numerodecolumnastext.getText()) > 15 ||
          mainFrame.nombretabletext.getText().compareTo("")==0) {
                JOptionPane.showMessageDialog(null, "Me dio pereza y solo puse 15 espacios o escriba el nombre de la tabla ");

            } else {
                tableget.setTablename(mainFrame.nombretabletext.getText());
                tableget.setNumberofcolumns(Integer.parseInt(mainFrame.numerodecolumnastext.getText()));
                Controllerforcreatetable controllerforcreatetable = new Controllerforcreatetable();
                controllerforcreatetable.startcreatable();
                mainFrame.editarTablas.setVisible(false);
                mainFrame.tablas.setVisible(false);
                mainFrame.abrirtabla.setVisible(false);

            }

        }
        if (mainFrame.editarTablas == evento.getSource()) {
            Tableget tableget = new Tableget();
            tableget.setTablename(mainFrame.tablas.getSelectedItem().toString());
            Controllerforeditdelete controllerforeditdelete = new Controllerforeditdelete();
            controllerforeditdelete.startedit();
        }

    }

    public void controllerllenarCombobox() {
        Tablas tablas = new Tablas();
        ArrayList nombretablas = new ArrayList();
        nombretablas = tablas.nombresTablas();
        for (int i = 0; i < nombretablas.size(); i++) {
            mainFrame.tablas.addItem(nombretablas.get(i));
        }

    }

    public void Controllerclock() {

        Thread clock = new Thread(
                new Runnable() {
            public void run() {
                while (mainFrame.isVisible()) {
                    mainFrame.Clock.setText(chatBox.getTime());
                }

            }
        });

        clock.start();

    }

}
