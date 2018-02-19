package examen1.Model;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Arrays;

public class Tablas {

    public Tablas() {

    }

       /**
     *Cuenta la columnas de la tablas especificada
     *
     * @param String nombre de la tabla
     * @return int numero de columnas
     */
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

       /**
     * Toma el nombre de la tablas especificada
     *
     * @param String nombre de la tabla
     * @return ArrayList con los nombres de las columnas
     */    
    public ArrayList Nombrescolumnas(String tableName) {
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

          /**
     * Toma el nombre de la tablas de la base de datos
     *
     * @param 
     * @return ArrayList con los nombres de las tablas
     */  
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
      /**
     * Toma los datos de la tabla especificada 
     *
     * @param String nombre de la tabla , ArrayLis de datos
     * @return Result Set  del query
     */  
    public ResultSet datosTablas(String tablename, ArrayList datos) {
        ArrayList<Object> objs = new ArrayList<Object>();
        String query = "Select ";
        for (int i = 0; i < datos.size() - 1; i++) {
            query = query + datos.get(i).toString() + " ,  ";

        }
        query = query + datos.get(datos.size() - 1).toString() + " From " + tablename;
        ResultSet rs = LoginModel.sql.SELECT(query, objs);

        return rs;
    }

          /**
     * Crea una tabla en la base de datos
     *
     * @param String nombre de la tabla , ArrayList con los nombres de las columnas
     * @return true si la tabla se crea y false si existe algun problema
     */  
    public boolean createTable(String tablename, ArrayList columnasvariables) {
        ArrayList<Object> objs = new ArrayList<Object>();
        String query = "CREATE TABLE " + tablename + " (";
        if (columnasvariables.size() > 2) {
            for (int i = 0; i < (columnasvariables.size()-2); i = i + 2) {
                query = query + columnasvariables.get(i) + " " + columnasvariables.get(i + 1)
                        + " (6) NOT NULL, ";
            }
        }
        query = query + columnasvariables.get(columnasvariables.size() - 2)
                + " " + columnasvariables.get(columnasvariables.size() - 1)
                + " (6)  NOT NULL);";
        try {
            LoginModel.sql.exec(query, objs);
        } catch (Exception e) {
            System.out.println("error" + e);
        }
        return true;
    }

          /**
     * Actualiza una tabla especifica 
     *
     * @param String nombre de la tabla, String columnas set , String nuevo dato , String columna where ,
     * String dato viejo
     * @return true si se actualiza correctamente y false si existe algun problema
     */  
    public boolean UpdateAnyTable(String tableName, String columnaChange, String New, String Columnawhere, String Old) {

        ArrayList<Object> objs = new ArrayList<Object>();
        objs.addAll(Arrays.asList(New, Old));
        boolean result = LoginModel.sql.exec("Update  " + tableName
                + " Set " + columnaChange + "  = ? "
                + " Where " + Columnawhere + " = ? ", objs);
        return result;
    }

          /**
     * Borra los datos de la tabla segun las especificaciones
     *
     * @param String nombre de la tabla, String columna where , String dato de la tabla
     * @return true si se borra correctamente y false si existe algun problema 
     */  
    public boolean DeleteAnyTable(String tableName, String Columnawhere, String Old) {

        ArrayList<Object> objs = new ArrayList<Object>();
        objs.addAll(Arrays.asList(Old));
        boolean result = LoginModel.sql.exec("Delete  "
                + " From " + tableName + "  "
                + " Where " + Columnawhere + " =  ? ", objs);
        return result;
    }

}
