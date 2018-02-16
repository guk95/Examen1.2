/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examen1.Controller;

import examen1.Model.ChatBox;
import examen1.Model.User;
import examen1.View.ChatBoxView;
import examen1.View.MainFrame;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;
import examen1.Controller.ControllerForChatBox;
import examen1.Model.Tablas;
import examen1.Model.Tableget;

/**
 *
 * @author Mario
 */
public class ManagerForMainFrame implements ActionListener {

    MainFrame mainFrame;
    ChatBox chatBox;
    User user = new User();
    ChatBoxView boxView;
    Tablas tablas = new Tablas();
    Tableget tableget = new Tableget();

    public ManagerForMainFrame() {

    }

    public ManagerForMainFrame(MainFrame mainFrame, ChatBox chatBox) {
        this.mainFrame = mainFrame;
        this.chatBox = chatBox;
        Controllerclock();
        controllerllenarCombobox();
        this.mainFrame.ChatBox.addActionListener(this);
        this.mainFrame.verTablas.addActionListener(this);
        this.mainFrame.abrirtabla.addActionListener(this);
    }

    public void actionPerformed(ActionEvent evento) {

        if (mainFrame.ChatBox == evento.getSource()) {
            mainFrame.tablas.setVisible(false);
            mainFrame.abrirtabla.setVisible(false);
            ControllerForChatBox controllerForChatBox = new ControllerForChatBox();
            controllerForChatBox.StartControllerForChatBox();
        }
        if (mainFrame.verTablas == evento.getSource()) {

            mainFrame.tablas.setVisible(true);
            mainFrame.abrirtabla.setVisible(true);
        }
        if (mainFrame.abrirtabla == evento.getSource()) {
            tableget.setTablename(mainFrame.tablas.getSelectedItem().toString());

            ControllerTables controllerTables = new ControllerTables();
            controllerTables.StartTables();
        }
        if (mainFrame.crearTablas == evento.getSource()) {
            mainFrame.tablas.setVisible(false);
            mainFrame.abrirtabla.setVisible(false);

        }

    }

//    public void ControllersendMessage() {
//
//        chatBox.sendtoDB(user.getDisplayname(), boxView.send_Message.getText());
//        boxView.send_Message.setText("");
//    }
//
//    public void ControllerreadDB() {
//        Thread t = new Thread(
//                new Runnable() {
//            public void run() {
//                while (boxView.isVisible()) {
//
//                    ResultSet rs1 = chatBox.readDB();
//
//                    try {
//                        String text = "";
//                        while (rs1.next()) {
//                            text = text + rs1.getObject("Displayname").toString() + "   "
//                                    + "  " + rs1.getObject("Message").toString() + "                                             " + rs1.getObject("Date").toString() + "\n" + "\n";
//
//                        }
//                        boxView.chatArea.setText(text);
//
//                    } catch (Exception e) {
//                        System.out.println("Error :" + e);
//                    }
//                    try {
//                        Thread.sleep(5000);
//                    } catch (InterruptedException ex) {
//                        Logger.getLogger(Manager.class.getName()).log(Level.SEVERE, null, ex);
//                    }
//                }
//
//            }
//        });
//
//        t.start();
//    }
    public void controllerllenarCombobox() {
        for (int i = 0; i < tablas.nombresTablas().size(); i++) {
            mainFrame.tablas.addItem(tablas.nombresTablas().get(i));
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
