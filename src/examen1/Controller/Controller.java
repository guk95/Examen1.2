/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examen1.Controller;
import examen1.Model.LoginModel;
import examen1.View.Login;





/**
 *
 * @author Mario
 */
public class Controller {
    public Controller(){}
    
       public void Start() {

        Login login= new Login();
        LoginModel loginModel= new LoginModel();        
        Manager manager = new Manager(login,loginModel);
   

    }
    
}
