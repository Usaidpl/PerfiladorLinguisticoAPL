package gt.lea.usaid.perfiladorlinguistico.controller;

import gt.lea.usaid.perfiladorlinguistico.utils.GeneradorSQL;

/**
 * Created by Bryan on 14/06/16.
 */
public class Verifica {

    private boolean[] array_true, array_false;
    public static final int TOTAL_SERIE = 100;
    private String dato = "";
    private String tabla = "";

    public Verifica(boolean[] arreglo_verdadero, boolean[] arreglo_falso, String nombre_tabla){
        array_true = arreglo_verdadero;
        array_false = arreglo_falso;
        tabla = nombre_tabla;
    }

    public Verifica(boolean[][] arreglo, String nombre_tabla){
        array_true = arreglo[0];
        array_false = arreglo[1];
        tabla = nombre_tabla;
    }

    //Last method
    public float getResultado()throws Exception{
        float resultado = 0, sub_resultado = 0;
        if(toCompara() == false)
            throw  new Exception("Error: todo debe tener una respuesta.");
        else{
            //replace PREGUNTA for address complet type Const.
            sub_resultado = TOTAL_SERIE / Pregunta.Interactua.PREGUNTA;
            sub_resultado *= toVerificaRespuesta();
        }
        resultado = sub_resultado;
        return resultado;
    }

    //New Method
    public float getResultado(int cantidad_pregunta)throws Exception{
        float resultado = 0, sub_resultado = 0;
        if(toCompara(cantidad_pregunta) == false)
            throw  new Exception("Error: todo debe tener una respuesta.");
        else{
            sub_resultado = TOTAL_SERIE / cantidad_pregunta;
            sub_resultado *= toVerificaRespuesta();
        }
        resultado = sub_resultado;
        return resultado;
    }

    private float toVerificaRespuesta() {
        return resultado(array_true);
    }

    private boolean toCompara() {
        int resultado = 0, respuesta1, respuesta2;
        respuesta1 = resultado(array_true);
        respuesta2 = resultado(array_false);
        resultado = respuesta1 + respuesta2;
        if(resultado == Pregunta.Interactua.PREGUNTA)
            return true;
        else
            return false;
    }

    private boolean toCompara(int preguntas) {
        int resultado = 0, respuesta1, respuesta2;
        respuesta1 = resultado(array_true);
        respuesta2 = resultado(array_false);
        resultado = respuesta1 + respuesta2;
        if(resultado == preguntas)
            return true;
        else
            return false;
    }

    private int resultado(boolean[] arreglo){
        int resultado = 0;

        //DataBase db = new DataBase(tabla);
        boolean select = false;
        for(int s = 0; s  < arreglo.length; s ++){
            select = arreglo[s];
            if(select == true){
                resultado ++;
            }
            else{
                resultado += 0;
            }
        }
        return resultado;
    }

    private String concatena(boolean[] arreglo){
        String s = "";

        return "";
    }

    public static final class Pregunta{

        public static final class Interactua{
            public static final int PREGUNTA = 5;
        }

        public static final class Expresa{
            public static final int PREGUNTA = 4;
        }
    }


}
