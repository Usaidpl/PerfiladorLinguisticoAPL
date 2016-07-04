package gt.lea.usaid.perfiladorlinguistico.controller;

/**
 * Created by Roberto on 3/07/2016.
 */
public class VerificaExpresion {

    private boolean[] array_true, array_false;
    public static final int TOTAL_SERIE = 100;
    public static final int PREGUNTA = 4;
    private String tabla = "";

    public VerificaExpresion(boolean[] arreglo_verdadero, boolean[] arreglo_falso, String nombre_tabla){
        array_true = arreglo_verdadero;
        array_false = arreglo_falso;
        tabla = nombre_tabla;
    }

    public VerificaExpresion(boolean[][] arreglo, String nombre_tabla){
        array_true = arreglo[0];
        array_false = arreglo[1];
        tabla = nombre_tabla;
    }

    public float getResultado()throws Exception{
        float resultado = 0, sub_resultado = 0;
        if(toCompara() == false)
            throw  new Exception("Error: todo debe tener una respuesta.");
        else{
            sub_resultado = TOTAL_SERIE / PREGUNTA;
            sub_resultado = toVerificaRespuesta();
        }
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
        if(resultado == PREGUNTA)
            return true;
        else
            return false;
    }

    private int resultado(boolean[] arreglo){
        int resultado = 0, insert;
        //DataBase db = new DataBase(tabla);
        boolean select = false;
        for(int s = 0; s  < arreglo.length; s ++){
            select = arreglo[s];
            if(select == true){
                insert = 1;
                resultado ++;
            }
            else{
                insert = 0;
                resultado += 0;
            }
            //db.execute("INSERT INTO " + tabla + "(" + insert + ");");
        }
        return resultado;
    }
}
