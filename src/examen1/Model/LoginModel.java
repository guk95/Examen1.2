/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examen1.Model;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Arrays;

public class LoginModel  {

   public static SQL sql;
   funciones fun;

    public LoginModel() {
        this.sql = new SQL();
        this.fun= new funciones();
    }

       /**
     * Crea a un usuario en la base de datos
     *
     * @param Nombre , Password. DisplayName
     * @return lretorna true si se agrega y false si hay algun problema
     */
    public boolean CreateUser(String Name,  String PassWord,String DisplayName) {
        ArrayList<Object> objs = new ArrayList<>();
        objs.addAll(Arrays.asList(Name, fun.MD5(PassWord),DisplayName ));

        boolean result = sql.exec("INSERT INTO `Examen_Mario_Login` "
                + "(`Username`,`Password`,`DisplayName` ) "
                + "VALUES (?, ?, ?)", objs);
        if (result) {
            return true;
        } else {
            return false;
        }
    }

       /**
     * Loguea al usuario al programa
     *
     * @param String Nombre de usuario , String Password
     * @return retorna true si se loguea y false si existe algun problema
     */
    public boolean Login(String Username, String Password) {
        ArrayList<Object> objs = new ArrayList<Object>();
        objs.addAll(Arrays.asList(Username, fun.MD5(Password)));
        ResultSet rs = sql.SELECT("Select `Username`,`Password` from `Examen_Mario_Login`Where `Username`=? and `Password`=? ", objs);
        if (sql.Exists(rs)) {
            return true;
        } else {
            return false;
        }

    }
   /**
     * Toma el DisplayName del usuario
     *
     * @param String Username , String Password
     * @return String nombre de usuario
     */
    public String GetDisplay(String Username, String Password) {
        ArrayList<Object> objs = new ArrayList<Object>();
        objs.addAll(Arrays.asList(Username,fun.MD5( Password)));
        ResultSet rs = sql.SELECT("Select `DisplayName`from `Examen_Mario_Login`Where `Username`=? and `Password`=? ", objs);
        String displayname = "";
        try {
            while (rs.next()) {
                displayname = rs.getObject("DisplayName").toString();

            }
        } catch (Exception e) {
        }
        return displayname;

    }

}
