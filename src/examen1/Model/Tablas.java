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

    public int Contarcolumnas(String tableName) {
        int columnas = 0;
        ArrayList<Object> objs = new ArrayList<Object>();
        objs.addAll(Arrays.asList(tableName));
        String col = "";
        ResultSet rs = sql.SELECT("Select DATA_TYPE FROM information_schema.COLUMNS WHERE  TABLE_NAME = ?", objs);
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

        ResultSet rs = sql.SELECT("Select COLUMN_NAME FROM information_schema.COLUMNS WHERE  TABLE_NAME = ?", objs);
        try {
            while (rs.next()) {

                Result.add(rs.getObject("COLUMN_NAME").toString());
            }
        } catch (Exception e) {
            System.out.println("Error" + e);
        }

        return Result;
    }

    public ArrayList nombresTablas() {
        ArrayList<String> result = new ArrayList<String>();
        ResultSet rs = sql.SELECT("Select TABLE_NAME FROM information_schema.COLUMNS  "
                + " WHERE TABLE_NAME not like  \"APPLICABLE_ROLES\" "
                + "and TABLE_NAME not like  \"ALL_PLUGINS\" "
                + "and TABLE_NAME not like  \"SESSION_VARIABLESTABLE_STATISTICS\" "
                + "and TABLE_NAME not like  \"CHARACTER_SETS\" "
                + "and TABLE_NAME not like  \"CLIENT_STATISTICS\" "
                + "and TABLE_NAME not like  \"COLLATIONS\" "
                + "and TABLE_NAME not like  \"COLLATION_CHARACTER_SET_APPLICABILITY\" "
                + "and TABLE_NAME not like  \"COLUMNS\" "
                + "and TABLE_NAME not like  \"COLUMN_PRIVILEGES\" "
                + "and TABLE_NAME not like  \"ENABLED_ROLES\" "
                + "and TABLE_NAME not like  \"ENGINES\" "
                + "and TABLE_NAME not like  \"EVENTS\" "
                + "and TABLE_NAME not like  \"FILES\" "
                + "and TABLE_NAME not like  \"GLOBAL_STATUS\" "
                + "and TABLE_NAME not like  \"GLOBAL_VARIABLES\" "
                + "and TABLE_NAME not like  \"INDEX_STATISTICS\" "
                + "and TABLE_NAME not like  \"KEY_CACHES\""
                + "and TABLE_NAME not like  \"KEY_COLUMN_USAGE\" "
                + "and TABLE_NAME not like  \"PARAMETERS\" "
                + "and TABLE_NAME not like  \"PARTITIONS\" "
                + "and TABLE_NAME not like \"PLUGINS\" "
                + "and TABLE_NAME not like \"PROCESSLIST\" "
                + "and TABLE_NAME not like \"PROFILING\" "
                + "and TABLE_NAME not like \"REFERENTIAL_CONSTRAINTS\" "
                + "and TABLE_NAME not like \"ROUTINES\" "
                + "and TABLE_NAME not like \"SCHEMATA\" "
                + "and TABLE_NAME not like \"SCHEMA_PRIVILEGES\" "
                + "and TABLE_NAME not like \"SESSION_STATUS\" "
                + "and TABLE_NAME not like \"STATISTICS\" "
                + "and TABLE_NAME not like \"TABLES\" "
                + "and TABLE_NAME not like \"TABLESPACES\" "
                + "and TABLE_NAME not like \"TABLE_CONSTRAINTS\" "
                + "and TABLE_NAME not like \"TABLE_PRIVILEGES\" "
                + "and TABLE_NAME not like \"TRIGGERS\" "
                + "and TABLE_NAME not like \"USER_PRIVILEGES\" "
                + "and TABLE_NAME not like \"USER_STATISTICS\" "
                + "and TABLE_NAME not like \"VIEWS\""
                + "and TABLE_NAME not like \"INNODB_CMP\" "
                + "and TABLE_NAME not like \"XTRADB_INTERNAL_HASH_TABLES\" "
                + "and TABLE_NAME not like \"INNODB_SYS_DATAFILES\" "
                + "and TABLE_NAME not like \"XTRADB_RSEG\" "
                + "and TABLE_NAME not like \"INNODB_SYS_TABLESTATS\" "
                + "and TABLE_NAME not like \"INNODB_TRX\" "
                + "and TABLE_NAME not like \"INNODB_FT_BEING_DELETED\" "
                + "and TABLE_NAME not like \"INNODB_CMP_RESET\" "
                + "and TABLE_NAME not like \"INNODB_CMP_PER_INDEX\" "
                + "and TABLE_NAME not like \"INNODB_LOCKS\" "
                + "and TABLE_NAME not like \"INNODB_FT_DELETED\" "
                + "and TABLE_NAME not like \"XTRADB_READ_VIEW\" "
                + "and TABLE_NAME not like \"INNODB_LOCK_WAITS\" "
                + "and TABLE_NAME not like \"INNODB_CMPMEM_RESET\" "
                + "and TABLE_NAME not like \"INNODB_SYS_INDEXES\""
                + "and TABLE_NAME not like \"INNODB_SYS_TABLES\" "
                + "and TABLE_NAME not like \"INNODB_SYS_FIELDS\" "
                + "and TABLE_NAME not like \"INNODB_BUFFER_PAGE_LRU\" "
                + "and TABLE_NAME not like \"INNODB_FT_CONFIG\" "
                + "and TABLE_NAME not like \"INNODB_FT_INDEX_TABLE\" "
                + "and TABLE_NAME not like \"INNODB_CMP_PER_INDEX_RESET\" "
                + "and TABLE_NAME not like \"INNODB_SYS_TABLESPACES\" "
                + "and TABLE_NAME not like \"INNODB_FT_INDEX_CACHE\" "
                + "and TABLE_NAME not like \"INNODB_SYS_FOREIGN_COLS\" "
                + "and TABLE_NAME not like \"INNODB_METRICS\" "
                + "and TABLE_NAME not like \"INNODB_BUFFER_POOL_STATS\" "
                + "and TABLE_NAME not like \"INNODB_CMPMEM\" "
                + "and TABLE_NAME not like \"INNODB_SYS_FOREIGN\" "
                + "and TABLE_NAME not like \"INNODB_FT_DEFAULT_STOPWORD\" "
                + "and TABLE_NAME not like \"INNODB_BUFFER_PAGE\" "
                + "and TABLE_NAME not like \"INNODB_CHANGED_PAGES\" "
                + "and TABLE_NAME not like \"INNODB_CHANGED_PAGES\" "
                + "and TABLE_NAME not like \"INNODB_SYS_COLUMNS\" "
                + "and TABLE_NAME not like \"SESSION_VARIABLES\" "
                + "and TABLE_NAME not like \"TABLE_STATISTICS\" "
                + " Group By TABLE_NAME ", new ArrayList());

        try {
            while (rs.next()) {

                result.add(rs.getObject("TABLE_NAME").toString());
            }

        } catch (Exception e) {
        }

        return result;
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
            sql.execfortables(query, objs);
        } catch (Exception e) {
            System.out.println("error" + e);
        }

        return true;
    }

    public boolean UpdateAnyTable(String tableName, String columnaChange, String New, String Columnawhere, String Old) {

        ArrayList<Object> objs = new ArrayList<Object>();
        objs.addAll(Arrays.asList(tableName, columnaChange, New, Columnawhere, Old));
        boolean result = sql.exec("Update ? "
                + " Set ? = ? "
                + " Where ? = ? ", objs);

        return true;
    }

}
