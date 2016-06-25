package gt.lea.usaid.perfiladorlinguistico.utils.interfaces;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.provider.BaseColumns;

import java.util.ArrayList;

import gt.lea.usaid.perfiladorlinguistico.utils.ConnectivityDataBase;

/**
 * Created by programadormd on 06-24-16.
 */
public class CreateTable {

    private ArrayList<String> valor = new ArrayList();
    private String nombre_tabla;

    public CreateTable(String nombre_tabla, ArrayList<String> valor){
        this.nombre_tabla = nombre_tabla;
        this.valor = valor;
    }

    private  String camp(String llave_primaria,String type_data){
        String resultado = llave_primaria + " " + "PRIMARY KEY AUTOINCREMENT";
        if(valor != null || valor.size()  > 0 ){
            for(int v = 0; v < valor.size(); v ++){
                if((v + 1) != valor.size()){
                    resultado += "'" + valor.get(v) + "'" + ",";
                }else
                    resultado += "'" + valor.get(v) + "'";
            }
        }
        return resultado;
    }

    public static class Colum{
        public static final String Id_pregunta = BaseColumns._ID;
        public static final String PREGUNTA = "";
        public static final int RESULTADO_FINAL = 0;
    }

    //public  String CREATE_TABLE = "CREATE TABLE " + nombre_tabla + "(" + camp() +;

}
