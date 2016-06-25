package gt.lea.usaid.perfiladorlinguistico.utils;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Bryan on 06-24-16.
 */
public abstract class ConnectivityDataBase extends SQLiteOpenHelper {

    private static final String DATA_BASE_NAME = "USAID";
    private static final int VERSION = 1;

    public ConnectivityDataBase(Context context){
        super(context,DATA_BASE_NAME,null,VERSION);
    }

    public ContentValues generadorValores(ConnectivityDataBase cdb){
        ContentValues cv = new ContentValues();
       // cv.put();
        return null;
    }

}
