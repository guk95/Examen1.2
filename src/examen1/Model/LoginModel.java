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

    public LoginModel() {
        this.sql = new SQL();
    }

    public boolean CreateUser(String Name, String DisplayName, String PassWord) {
        ArrayList<Object> objs = new ArrayList<>();
        objs.addAll(Arrays.asList(Name, DisplayName, PassWord));

        boolean result = sql.exec("INSERT INTO `Examen_Mario_Login` "
                + "(`Username`,`Password`,`DisplayName` ) "
                + "VALUES (?, ?, ?)", objs);
        if (result) {
            return true;
        } else {
            return false;
        }
    }

    public boolean Login(String Username, String Password) {
        ArrayList<Object> objs = new ArrayList<Object>();
        objs.addAll(Arrays.asList(Username, Password));
        ResultSet rs = sql.SELECT("Select `Username`,`Password` from `Examen_Mario_Login`Where `Username`=? and `Password`=? ", objs);
        if (sql.Exists(rs)) {
            return true;
        } else {
            return false;
        }

    }

    public String GetDisplay(String Username, String Password) {
        ArrayList<Object> objs = new ArrayList<Object>();
        objs.addAll(Arrays.asList(Username, Password));
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
