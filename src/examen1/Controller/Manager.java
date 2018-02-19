/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examen1.Controller;

import examen1.Model.LoginModel;
import examen1.Model.Tablas;
import java.awt.event.ActionListener;
import examen1.Model.User;
import examen1.View.Login;
import java.awt.event.ActionEvent;
import examen1.View.MainFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Mario
 */
public class Manager implements ActionListener {

    Login login;
    LoginModel loginModel;
    MainFrame mainFrame;
    User user = new User();

    public Manager() {
    }

    public Manager(Login login, LoginModel loginModel) {
        this.login = login;
        this.loginModel = loginModel;
        this.login.Loguear.addActionListener(this);
        this.login.Registrar.addActionListener(this);

    }

    public void actionPerformed(ActionEvent evento) {

        if (login.Loguear == evento.getSource()) {
            if (ControllerLogIn()) {
                ControllerForMainFrame cfmf = new ControllerForMainFrame();
                cfmf.StartMainFrame();
                login.dispose();
            } else {

                JOptionPane.showMessageDialog(null, "Usuario incorrecto o espacios en blanco");
            }

        }
        if (login.Registrar == evento.getSource()) {
            ControllerRegister();

        }

    }

    public boolean ControllerLogIn() {
        if(login.Nombre.getText().trim().compareTo("")==0
                || login.Password.getText().trim().compareTo("")==0 ){
        return false;
        }
        if (loginModel.Login(login.Nombre.getText(), login.Password.getText())) {
            user.setDisplayname(loginModel.GetDisplay(login.Nombre.getText(), login.Password.getText()));
            return true;
        } else {

            return false;
        }

    }

    public void ControllerRegister() {

        boolean result = loginModel.CreateUser(login.Username.getText(), login.Passwordnew.getText(), login.Displayname.getText());
        if (result) {
            JOptionPane.showMessageDialog(null, "Usuario Creado");
        } else {
            JOptionPane.showMessageDialog(null, "Error");
        }
    }

}
