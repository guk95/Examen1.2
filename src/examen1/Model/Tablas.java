package examen1.Model;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Arrays;

public class Tablas {

    SQL sql;

    public Tablas() {
        this.sql = new SQL();
    }

   

    public boolean CreateUser(String Name, String DisplayName, String PassWord) {
        ArrayList<Object> objs = new ArrayList<>();
        objs.addAll(Arrays.asList(Name, DisplayName, PassWord));

        boolean result = sql.exec("INSERT INTO `Cesar_login1` "
                + "(`nombre`,`password`,`nombreMostrar` ) "
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

    public int Contarcolumnas(String tableName) {
        int columnas = 0;
        ArrayList<Object> objs = new ArrayList<Object>();
        objs.addAll(Arrays.asList(tableName));
        String col = "";
        ResultSet rs = sql.SELECT("Select count(COLUMN_NAME) FROM INFORMATION_SCHEMA.COLUMNS WHERE table_catalog = 'icompone_ulatina' AND table_name = ?", objs);
        try {
            while (rs.next()) {

                col = rs.getObject("(COLUMN_NAME)").toString();
            }
        } catch (Exception e) {
            System.out.println("Error" + e);
        }

        return columnas;
    }

    public boolean createTable(String tablename, ArrayList columnasvariables) {

        ArrayList<Object> objs = new ArrayList<Object>();
        objs.addAll(Arrays.asList(tablename));
        for (int i = 0; i < columnasvariables.size(); i++) {
            objs.addAll(Arrays.asList(columnasvariables.get(i)));
        }

        String query = "CREATE TABLE "+"`"+"?"+"` (";
        for (int i = 0; i < (columnasvariables.size() / 3)-1; i++) {
            query = query + "`"+" ? "+"`"+"  ? (?)  NOT NULL,";
        }
        query = query+"`"+" ? "+"`"+"   ? (?)  NOT NULL);";
        try {
            sql.exec(query, objs);
        } catch (Exception e) {
            System.out.println("error"+e);
        }

        return true;
    }
    
     public boolean UpdateAnyTable(String tableName, ArrayList Columnas, ArrayList NewData) {

        return true;
    }

}
