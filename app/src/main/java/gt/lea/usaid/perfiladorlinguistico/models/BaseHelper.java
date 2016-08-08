package gt.lea.usaid.perfiladorlinguistico.models;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Intecprom-PC on 31/07/2016.
 */
public class BaseHelper extends SQLiteOpenHelper {

    String tabla_perfil = "CREATE TABLE entrevistador (Cod_entrevistador INTEGER PRIMARY KEY, " +
            "Nombre TEXT, Cargo TEXT, Fecha DATE," +
            "Escuela TEXT, Codigo TEXT, Municipio TEXT, Departamento TEXT, Ciclo TEXT)";

    String tabla_estudiante = "CREATE TABLE estudiante(Cod_estudiante INTEGER PRIMARY KEY, " +
            "Nombre TEXT, Genero TEXT, Edad TEXT, Grado TEXT, entrevistador INTEGER, " +
            " FOREIGN KEY(entrevistador) REFERENCES perfil(cod_entrevistador))";


    public BaseHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("PRAGMA foreign_keys=ON");
        db.execSQL(tabla_perfil);
        db.execSQL(tabla_estudiante);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table_perifl");
        db.execSQL("drop table_estudiante");
        db.execSQL(tabla_perfil);
        db.execSQL(tabla_estudiante);
    }


}
