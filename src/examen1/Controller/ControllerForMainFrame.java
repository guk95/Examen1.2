/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examen1.Controller;
import examen1.View.MainFrame;
import examen1.Model.ChatBox;

/**
 *
 * @author Mario
 */
public class ControllerForMainFrame {

  

    public ControllerForMainFrame() {

    }

    public void StartMainFrame() {
        MainFrame mainFrame = new MainFrame();
        ChatBox chatBox = new ChatBox();
        ManagerForMainFrame managerForMainFrame = new ManagerForMainFrame(mainFrame, chatBox);
    }

}
