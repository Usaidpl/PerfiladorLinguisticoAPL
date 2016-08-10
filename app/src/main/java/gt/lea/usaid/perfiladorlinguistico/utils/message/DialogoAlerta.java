package gt.lea.usaid.perfiladorlinguistico.utils.message;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.AsyncTask;
import android.widget.Toast;

import gt.lea.usaid.perfiladorlinguistico.R;

/**
 * Created by programadormd on 06-30-16.
 */
public abstract class DialogoAlerta {

    private static android.content.Context context;

    public DialogoAlerta(android.content.Context activity){
        context = activity;
    }

    public void alertDialog(String title, String msg, boolean status){
        AlertDialog.Builder d = new  AlertDialog.Builder(context);
        d.setTitle(title);
        d.setMessage(msg);
        d.setCancelable(false);
        d.setPositiveButton("Confirmar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                confirm();
            }
        });
        d.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                cancel();
            }
        });
        d.show();
    }

    public static void alertDialog(String title, String msg, boolean status, android.content.Context contexto){
        context = contexto;
        AlertDialog.Builder d = new  AlertDialog.Builder(contexto);
        d.setTitle(title);
        d.setMessage(msg);
        d.setCancelable(false);
        d.setIcon((status) ? R.drawable.ic_menu_gallery : R.drawable.ic_menu_camera);
        d.setPositiveButton("Confirmar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // confirm();
            }
        });
        d.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                cancel();
            }
        });
        d.show();
    }

    public abstract void confirm(Object o);

    public abstract void cancel(Object o);

   private static void confirm(){
      String s = "tabla 1,0,1,0,1", res = "";
       String linea[] = s.split(",");
       for(int i = 0; i < linea.length; i++){
         res = linea[i];
       }
       Toast.makeText(context, res, Toast.LENGTH_LONG).show();
   }

    private  static void cancel(){
        Toast.makeText(context, "Cancelado", Toast.LENGTH_SHORT).show();
    }


}
