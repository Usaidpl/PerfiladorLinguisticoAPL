package gt.lea.usaid.perfiladorlinguistico.controller;

import android.view.View;

import gt.lea.usaid.perfiladorlinguistico.R;

/**
 * Created by Bryan on 25/07/2016.
 */
public abstract class Respuesta implements View.OnClickListener{

    //área estatica
    private static final int RESPUESTA_UNO = 1;
    private static final int RESPUESTA_DOS = 2;
    private static final int RESPUESTA_TRES = 3;

    protected int ques(int opcion, View v)
    {
        int resultado = 0, op = des(opcion);
        if(op == RESPUESTA_UNO){
            switch (v.getId()){
                case R.id.ivImagen1:
                    resultado = 1;
                    break;
                default:
                    resultado = 0;
            }
        }else if(op == RESPUESTA_DOS){
            switch (v.getId()){
                case R.id.ivImagen2:resultado = 1;break;
                default:resultado = 0;
            }
        }else if(op == RESPUESTA_TRES){
            switch (v.getId()){
                case R.id.ivImagen3:
                    resultado = 1;
                    break;
                default:
                    resultado =0;
            }
        }
        return  resultado;
    }

    protected int  des(int valor){
        int dev_val = 0;
        switch (valor){
            case 0: dev_val = RESPUESTA_DOS;break;
            case 1: dev_val = RESPUESTA_TRES;break;
            case 2: dev_val = RESPUESTA_TRES;break;
            case 3: dev_val = RESPUESTA_UNO;break;
            case 4: dev_val = RESPUESTA_DOS;break;
            case 5: dev_val = RESPUESTA_TRES;break;
            case 6: dev_val = RESPUESTA_DOS;break;
            case 7: dev_val = RESPUESTA_UNO;break;
            case 8: dev_val = RESPUESTA_TRES;break;
            case 9: dev_val = RESPUESTA_DOS;break;
            case 10: dev_val = RESPUESTA_DOS;break;
            case 11: dev_val = RESPUESTA_TRES;break;
            case 12: dev_val = RESPUESTA_DOS;break;
            case 13: dev_val = RESPUESTA_UNO;break;
            case 14: dev_val = RESPUESTA_UNO;break;
            case 15: dev_val = RESPUESTA_UNO;break;
            case 16: dev_val = RESPUESTA_TRES;break;
            case 17: dev_val = RESPUESTA_UNO;break;
        }
        return dev_val;
    }
}
