package gt.lea.usaid.perfiladorlinguistico.utils;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import gt.lea.usaid.perfiladorlinguistico.Entrevistas;
import gt.lea.usaid.perfiladorlinguistico.utils.interfaces.OnStartNextContext;


/**
 * Created by Bryan on 05/08/2016.
 */

/**
 * Created Bryan_Juarez07
 * version 2.5.7 RC5
 * fecha_creacion 05/08/2016 02:16:46 PM
 * ultima_modificacion 05/08/2016 11:15:13 PM
 */
public class Lanzador extends Activity
        implements OnStartNextContext {

    //Const
    public static final String KEY_TRANSITION_DOUBLE_STRING = "doble-cadena";
    public static final String KEY_TRANSTION_STRING = "cadena";
    private static final String KEY_TRANSITION_LANGUAGE = "idioma";
    //Const privados
    private static final String LINE_SEPARETOR = " | ";
    private static final String SEPARETOR_SERIE = " && ";
    private static final String LANGUAGE_SEPARETOR = " -- ";
    private static final String QUESTION_SEPARETOR = "//";
    private static final String KEY_TRANSITION_DOUBLE = "decimal";
    //field class
    private Activity activity_;
    private Bundle bundle;
    //field java
    private Class<?> next_context;
    private boolean lanza = false;

    //constructores
    public Lanzador(Activity actividad) {
        next_context = null;
        confirmacion(actividad);
    }

    public Lanzador(Activity actividad, Class<?> siguiente_actividad) {
        confirmacion(actividad);
        next_context = siguiente_actividad;
    }

    //SETTERS
    public void agregarValores(String resultado, String datos) {
        decitionActivity(converArrayString(resultado), datos);
    }

    public void agregarValores(String resultado, float total) {
        addDecima(total);
        decitionActivity(converArrayString(resultado), total);
    }

    public void agregarValores(String resultado, double total) {
        addDecima(total);
        decitionActivity(converArrayString(resultado), total);
    }

    public void agregarValores(String resultado, short total) {
        addDecima(total);
        decitionActivity(converArrayString(resultado), total);
    }

    public void agregarValores(String resultado, long total) {
        addDecima(total);
        decitionActivity(converArrayString(resultado), total);
    }

    public void agregarValores(String resultado, int total) {
        addDecima(total);
        decitionActivity(converArrayString(resultado), total);
    }

    public void agregarValores(String resultado, char caracter) {
        decitionActivity(converArrayString(resultado), caracter);
    }

    public void agregarValores(String resultado, boolean condicion) {
        decitionActivity(converArrayString(resultado), condicion);
    }

    public void agragarValor(String resultado) {
        decitionActivity(converArrayString(resultado), null);
    }

    public void setLanza(boolean siguiente_activitda){
        if(siguiente_activitda == true){
            lanza = siguiente_activitda;
            newLazamiento();
        }
    }

    public void addLanguage(int language) {
        boolean idioma = false;
        switch (language) {
            case 0:
                idioma = true;
                break;
            case 1:
                idioma = true;
                break;
            case 2:
                idioma = true;
                break;
            default:
                idioma = false;
                break;
        }
        if (idioma == true) {
            bundle.putInt(KEY_TRANSITION_LANGUAGE, language);
            if(lanza == false){
                newLazamiento();
            }
        }
    }

   

    //GETTERS
    //##############################################################################################
    public String getBundleStringDouble() {
        String resultado = "";
        if (bundle != null) {
            resultado += "" + bundle.getString(KEY_TRANSITION_DOUBLE_STRING);
        }
        return resultado;
    }

    public int getBundleLanguage() {
        int resultado = 0;
        if (bundle != null) {
            resultado = bundle.getInt(KEY_TRANSITION_LANGUAGE);
        }
        return resultado;
    }

    public double getTotal(){
        return bundle.getDouble(KEY_TRANSITION_DOUBLE);
    }

    //##############################################################################################
    //PRIVATE

    private void addDecima(Object decimal){
        String s = String.valueOf(decimal);
        double d = Double.parseDouble(s);
        bundle.putDouble(KEY_TRANSITION_DOUBLE, d);
    }
    private Object[] convertirToObjetArray(Object o) {
        Object[] objects = new Object[25];
        objects[0] = o;
        return objects;
    }

    private String[] converArrayString(String dato) {
        String[] position = new String[25];
        position[0] = dato;
        return position;
    }

    private void confirmacion(Activity a) {
        if (a != null) {
            activity_ = a;
            Intent i = activity_.getIntent();
            if (i != null) {
                bundle = i.getExtras();
            } else
                bundle = new Bundle();
        }
    }

    private void decitionActivity(String[] valores, Object o) {
        Class<?> contexto = activity_.getClass(), comparador = Entrevistas.class;
        boolean nulo = (o == null) == true, condicion = (contexto != comparador) == true;
        String convert_String = String.valueOf(o), valor = valores[0];
        if (!valor.isEmpty() && !nulo) {
            if (condicion) {
                valor += LINE_SEPARETOR + o;
            } else {
                valor += "";
            }
            if(next_context != null){
                valor += SEPARETOR_SERIE;
            }
        } else if (!valor.isEmpty() && nulo)
            valor = valores[0];
        bundle.putString(KEY_TRANSITION_DOUBLE_STRING, valor);
        if(lanza == false) {
            newLazamiento();
        }
    }

    public void newLazamiento() {
        setNextContext(activity_, next_context);
    }

    @Override
    public void setNextContext(Context context, Class<?> next_context) {
        Intent i = null;
        if(next_context != null){
            i = new Intent(context, next_context);
            Bundle b = new Bundle();
            if (bundle != null) {
                b = bundle;
                i.putExtras(b);
            }
            activity_.startActivity(i);
        }
    }
}
