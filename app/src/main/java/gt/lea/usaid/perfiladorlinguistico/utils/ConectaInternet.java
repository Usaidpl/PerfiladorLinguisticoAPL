package gt.lea.usaid.perfiladorlinguistico.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.NetworkRequest;



/**
 * Created by programadormd on 06-29-16.
 */
public class ConectaInternet {

    public static final int ERROR = 0;
    public static final int CONECTADO = 1;
    public static final int WIFI = 2;
    public static final int DATOS = 3;
    public static final String ERR = "ERROR DE CONEXION";
    public static final String CONECTADO_INTERNET = "CONECTADO";
    public static final String CONECTADO_WIFI = "CONECTADO A WIFI";
    public static final String CONECTADO_MOVIL = "CONECTADO A DATOS MOVILES";

    private static android.content.Context context;

    public ConectaInternet(android.content.Context activity){
        context = activity;
    }

    public static boolean conectado(android.content.Context activity){
        ConectaInternet.context = activity;
        if(conectadoWifi() == true ||conectadoDatos() == true)
            return true;
        else{
            return false;
        }
    }

    public int conectado(){
        int resultado = 0;
        if((conectadoWifi() && conectadoDatos()) == true)
            resultado = CONECTADO;
        else if(conectadoWifi())
            resultado = WIFI;
        else if(conectadoDatos())
            resultado = DATOS;
        else
            resultado = ERROR;
        return  resultado;
    }

    private static boolean conectadoWifi() {
        return typeToConnection(WIFI);
    }

    private static boolean conectadoDatos() {
        return typeToConnection(DATOS);
    }

    private static boolean typeToConnection(int type_network){
        boolean type = false;
        ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        if(cm != null){
            NetworkInfo ni = null;
            ni = cm.getActiveNetworkInfo();
            switch (type_network){
                case WIFI:
                    ni = cm.getNetworkInfo(ConnectivityManager.TYPE_WIFI); break;
                case DATOS:
                    ni = cm.getNetworkInfo(ConnectivityManager.TYPE_MOBILE); break;
            }
            if(ni != null){
                if(ni.isConnected() && ni.isAvailable())
                    return  true;
                else if(ni.isConnectedOrConnecting())
                    return false;
            }
        }
        return false;
    }



    /*
    getReason() // Reportara la razón de un intento de establecer la conectividad falló, si hay alguno disponible
    getTypeName()//Devolver un nombre legible por humanos describir el tipo de la red, por ejemplo "WIFI" o "movil"
    isAvailable()// Indica si la conectividad de red es posible

     */
}
