/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examen1.View;

import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTextArea;

public class ChatBoxView extends JFrame {

    public Layout Principal;
    public JPanel GenericPanel = new JPanel();
    public JTextField send_Message = new JTextField();
    public JTextArea chatArea = new JTextArea();
    public JTextArea chatArea1 = new JTextArea(10, 3);

    public ChatBoxView() {
        this.Principal = new Layout(1000, 1000, 4);
        setTitle("ChatBox");
        setLayout(Principal.getLayOut());
        setPreferredSize(Principal.setComponentDimension());
        setResizable(false);
        initComponents();
    }

    private void initComponents() {

        Layout nsPanel = new Layout(1000, 1000, 4);
        chatArea.setBounds(nsPanel.getRectangle(1000, 500));
        chatArea.setEditable(false);

        send_Message.setBounds(nsPanel.getRectangle(500, 150));
        GenericPanel.setLayout(nsPanel.getLayOut());
        GenericPanel.setSize(nsPanel.setComponentDimension());
        GenericPanel.setBackground(Color.BLACK);
        GenericPanel.add(chatArea);
        GenericPanel.add(send_Message);
        setVisible(true);
        add(GenericPanel);
        pack();
        setVisible(true);
    }

}
