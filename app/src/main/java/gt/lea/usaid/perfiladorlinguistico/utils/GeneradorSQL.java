package gt.lea.usaid.perfiladorlinguistico.utils;



import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

/**
 * Created by programadormd on 06-24-16.
 */
public class GeneradorSQL {

    private String tabla = "";
    private ArrayList<String> valor = new ArrayList();

    public GeneradorSQL(String nombreTabla){
        tabla = nombreTabla;
        //new CreateTable(nombreTabla);
    }

    public void addValue(String value){
        valor.add(value);
    }

    private void countValue(){
           SQLiteDatabase db = null;

           String insert = "";
           if (valor != null || valor.size() <= 0) {
               for (int v = 0; v < valor.size(); v++) {
                   if ((v + 1) != valor.size()) {
                      // db.insert(tabla, insert,null);
                       insert += "'" + valor.get(v) + "'" + ",";
                   }else
                       insert += "'" + valor.get(v) + "'";
               }
               //INSERT INTO (i.....);
               db.execSQL(insert);
           }

    }


}
