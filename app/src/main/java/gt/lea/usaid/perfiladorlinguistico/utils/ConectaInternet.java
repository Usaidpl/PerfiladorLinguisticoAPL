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
    private static NetworkInfo ni = null;

    public ConectaInternet(android.content.Context context){
        this.context = context;
    }

    public String tipoConexion() throws ErrorInternet{
        String tipo_conexion = null;
        if(conectoWifi() == true && conectoDatos() == true)
            tipo_conexion = CONECTADO_INTERNET;//"CONECTADO";
        else if(conectoWifi() == true && conectoDatos() == false)
            tipo_conexion = CONECTADO_WIFI;//"WIFI";
        else if(conectoWifi() == false && conectoDatos() == true)
            tipo_conexion = CONECTADO_MOVIL;//"MOBILE";
        else{
            //tipo_conexion == ERR;//"Error"
            if(ni.isAvailable() && conectoWifi() == false)
                throw new ErrorInternet("Error: Verifique si su WIFI esta ensendido:");
            else if(tipo_conexion.isEmpty() && conectoDatos() == false)
                throw new ErrorInternet("Erro: Sus saldo es insuficiente o no esta conectado los dato");

        }

        return tipo_conexion;
    }

    public int tipoConetion(){
        int tipo_conexion = 0;
        if(conectoWifi() == true && conectoDatos() == true)
            tipo_conexion = CONECTADO;
        else if(conectoWifi() == true && conectoDatos() == false)
            tipo_conexion = WIFI;
        else if(conectoWifi() == false && conectoDatos() == true)
            tipo_conexion = DATOS;
        else
            tipo_conexion = ERROR;
        return tipo_conexion;
    }

    public static boolean conectoInternet(android.content.Context context){
        boolean c = false;
        ConectaInternet.context = context;
        if(conectoWifi() == true && conectoDatos() == true)
            c = true;
        else if(conectoWifi() == true && conectoDatos() == false)
            c = true;
        else if(conectoWifi() == false && conectoDatos() == true)
            c = true;
        else
            c = false;
        return c;
    }

    private static boolean conectoDatos() {
        return conecta(DATOS);
    }

    private static boolean conectoWifi() {
        return conecta(WIFI);
    }

    private static boolean conecta(int tipo_conexion) {
        boolean estado = false;
        ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        if(cm != null){
            NetworkInfo ni = null;
            //NetworkRequest nr = null
            switch (tipo_conexion){
                case WIFI:
                    ni = cm.getNetworkInfo(ConnectivityManager.TYPE_WIFI);
                    break;
                case DATOS:
                    ni = cm.getNetworkInfo(ConnectivityManager.TYPE_MOBILE);
                    break;
            }
            if(ni != null){
                if(ni.isConnected())
                    estado = true;
            }else{
                estado = false;
            }
        }
        return estado;
    }

    public class ErrorInternet extends Exception{
        public ErrorInternet(String error){
            super(error);
        }

        public String mensaje(String s){
            return getMessage();
        }
    }

    /*
    getReason() // Reportara la razón de un intento de establecer la conectividad falló, si hay alguno disponible
    getTypeName()//Devolver un nombre legible por humanos describir el tipo de la red, por ejemplo "WIFI" o "movil"
    isAvailable()// Indica si la conectividad de red es posible

     */
}
