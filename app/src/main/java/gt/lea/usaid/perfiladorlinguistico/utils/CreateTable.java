package gt.lea.usaid.perfiladorlinguistico.utils;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.provider.BaseColumns;

import java.lang.reflect.Array;
import java.sql.SQLException;
import java.util.ArrayList;

import gt.lea.usaid.perfiladorlinguistico.utils.ConnectivityDataBase;

/**
 * Created by bryan on 06-24-16.
 */
public class CreateTable {

    private String nombre_tabla = "";
    private ArrayList<String> valor = new ArrayList();
    private ArrayList<String> data = new ArrayList();
    private ConnectivityDataBase cdb = null;
    //public CreateTable().SQL().CreateTable("",0,0);

    private void add(String campo_completo){
        valor.add(campo_completo);
    }

    public void add(String campo, int tipo, int dimension, boolean not_null){
        String dato = campo;
        switch (tipo){
            case 1:
                dato += " VARCHAR(" + dimension + ") ";
                break;
            case 2:
                dato += " INT(" + dimension + ") ";
            case 3:
                dato += " CHAR ";
            case 4:
                dato += " DATE ";
            case 5:
                dato += " DATETIME ";
        }
        if(not_null == true)
            dato += "NOT NULL";
        else
            dato += "NULL";
        data.add(dato);
    }

    public CreateTable(String nombre_tabla, SQL sql){
        nombre_tabla += sql.key;
    }

    public void create() throws SQLException{

    }



    public class SQL {

        private String key;

        public final String primary_key(){
            return key;
        }

        public final void setKey(String campo, int dato, int dimension){
            key = campo + " " ;
            String data = "";
            switch (dato){
                case 1:
                    data = "VARCHAR(" + dimension + ")";
                    break;
                case 2:
                    data = "INT(" + dimension + ")";
                case 3:
                    data = "TEXT(" + dimension + ")";
                case 4:
                    data = "DATE";
                    break;
                case 5:
                    data = "DATETIME";
                    break;
                case 6:
                    data = "CHAR";

            }
            key += data + " PRIMARY KEY NOT NULL," ;
        }
    }


}
