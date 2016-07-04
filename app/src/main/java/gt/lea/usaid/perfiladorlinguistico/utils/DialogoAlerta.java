package gt.lea.usaid.perfiladorlinguistico.utils;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.widget.Toast;

import gt.lea.usaid.perfiladorlinguistico.R;

/**
 * Created by programadormd on 06-30-16.
 */
public class DialogoAlerta {

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

    public static void alertDialog(String title, String msg, boolean status, android.content.Context context){
        AlertDialog.Builder d = new  AlertDialog.Builder(context);
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

   private static  void confirm(){
       Toast.makeText(context, "CONFIRMADO", Toast.LENGTH_SHORT).show();
   }

    private  static void cancel(){
        Toast.makeText(context, "Cancelado", Toast.LENGTH_SHORT).show();
    }
}
