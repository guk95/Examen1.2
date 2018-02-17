package examen1.Model;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Arrays;

public class Tablas {



    public Tablas() {
   
    }  
    public int Contarcolumnas(String tableName) {
        
        int columnas = 0;
        ArrayList<Object> objs = new ArrayList<Object>();
        objs.addAll(Arrays.asList(tableName));
        String col = "";
        ResultSet rs = LoginModel.sql.SELECT("Select DATA_TYPE FROM information_schema.COLUMNS WHERE  TABLE_NAME = ?", objs);
        try {
            while (rs.next()) {

                columnas++;
            }
        } catch (Exception e) {
            System.out.println("Error" + e);
        }

        return columnas;
    }

    public ArrayList Nombrescolumnas(String tableName) {
        int columnas = 0;
        ArrayList<Object> objs = new ArrayList<Object>();
        objs.addAll(Arrays.asList(tableName));
        ArrayList<String> Result = new ArrayList<String>();
        ResultSet rs = LoginModel.sql.SELECT("Select COLUMN_NAME FROM information_schema.COLUMNS WHERE  TABLE_NAME = ?", objs);
        if (LoginModel.sql.Exists(rs)) {
            try {
                while (rs.next()) {
                    Result.add(rs.getObject("COLUMN_NAME").toString());

                }

            } catch (Exception e) {
            }

        }

        return Result;
    }

    public ArrayList nombresTablas() {
        ArrayList<String> result = new ArrayList<String>();
        ResultSet rs = LoginModel.sql.SELECT("Select TABLE_NAME FROM information_schema.COLUMNS  "
                + "where Table_SCHEMA= \"icompone_ulatina\""
                + " Group By TABLE_NAME ", new ArrayList());
        try {
            while (rs.next()) {

                result.add(rs.getObject("TABLE_NAME").toString());
            }

        } catch (Exception e) {
        }

        return result;
    }

    public ResultSet datosTablas(String tablename, ArrayList datos) {
        ArrayList<Object> objs = new ArrayList<Object>();
        for (int i = 0; i < datos.size(); i++) {
            objs.addAll(Arrays.asList(datos.get(i)));
        }
        objs.addAll(Arrays.asList(tablename));
        String query = "Select ";
        for (int i = 0; i < datos.size() - 1; i++) {
            query = query + " ? ,";

        }
        query = query + " ? From ?";
        ResultSet rs = LoginModel.sql.SELECT(query, objs);

        return rs;
    }

    public boolean createTable(String tablename, ArrayList columnasvariables) {

        ArrayList<Object> objs = new ArrayList<Object>();
        objs.addAll(Arrays.asList(tablename));
        for (int i = 0; i < columnasvariables.size(); i++) {
            objs.addAll(Arrays.asList(columnasvariables.get(i)));
        }

        String query = "CREATE TABLE " + "?" + " (";
        for (int i = 0; i < (columnasvariables.size() / 3) - 1; i++) {
            query = query + "  ?  " + "  ? (?)  NOT NULL,";
        }
        query = query + "  ?  " + "   ? (?)  NOT NULL);";
        try {
            LoginModel.sql.execfortables(query, objs);
        } catch (Exception e) {
            System.out.println("error" + e);
        }

        return true;
    }

    public boolean UpdateAnyTable(String tableName, String columnaChange, String New, String Columnawhere, String Old) {

        ArrayList<Object> objs = new ArrayList<Object>();
        objs.addAll(Arrays.asList(tableName, columnaChange, New, Columnawhere, Old));
        boolean result = LoginModel.sql.exec("Update ? "
                + " Set ? = ? "
                + " Where ? = ? ", objs);

        return true;
    }

}
