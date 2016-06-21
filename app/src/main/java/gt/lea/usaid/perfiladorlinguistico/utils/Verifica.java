package gt.lea.usaid.perfiladorlinguistico.utils;

/**
 * Created by Bryan on 14/06/16.
 */
public class Verifica {

    private boolean[] array_true, array_false;
    public static final int TOTAL_SERIE = 100;
    public static final int PREGUNTA = 5;

    public Verifica(boolean[] arreglo_verdadero, boolean[] arreglo_falso){
        array_true = arreglo_verdadero;
        array_false = arreglo_falso;
    }

    public Verifica(boolean[][] arreglo){
        array_true = arreglo[0];
        array_false = arreglo[1];
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
        int resultado = 0;
        boolean select = false;
        for(int s = 0; s  < arreglo.length; s ++){
            select = arreglo[s];
            if(select == true)
                resultado ++;
            else
                resultado += 0;
        }
        return resultado;
    }
}
