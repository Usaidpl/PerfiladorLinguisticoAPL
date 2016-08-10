package gt.lea.usaid.perfiladorlinguistico.controller.control_vista;
import android.view.View;

import gt.lea.usaid.perfiladorlinguistico.R;
/**
 * Created by Bryan on 25/07/2016.
 */
public abstract class Respuesta implements View.OnClickListener{

    private String string;
    private double resultado_final;
    private int idioma;

    public Respuesta(int idioma){
        this.idioma = idioma;

    }

    public String getString(){
        return string;
    }

    public double getDouble(){
        return resultado_final;
    }

    //área estatica
    protected static final int FIRTS_IMAGE = 1;
    protected static final int SECUND_IMAGE = 2;
    protected static final int THRERE_IMAGE = 3;


    protected int result(int opcion, View v)
    {
        int resultado = 0, op = des(opcion);
        String respuesta = "";
        if(op == FIRTS_IMAGE){
            switch (v.getId()){
                case R.id.ivImagen1:
                    resultado += 1;
                    break;
                default:
                    resultado += 0;
            }
        }else if(op == SECUND_IMAGE){
            switch (v.getId()){
                case R.id.ivImagen2:resultado += 1;break;
                default:resultado += 0;
            }
        }else if(op == THRERE_IMAGE){
            switch (v.getId()){
                case R.id.ivImagen3:
                    resultado += 1;
                    break;
                default:
                    resultado +=0;
            }
        }

        respuesta += resultado;
        addVal(respuesta, resultado);
        return  resultado;
    }

    protected int  des(int valor){
        int dev_val = 0;
        switch (idioma){
            case 0:
                switch (valor){
                    case 0: dev_val = SECUND_IMAGE; break;
                    case 1: dev_val = FIRTS_IMAGE; break;
                    case 2: dev_val = SECUND_IMAGE; break;
                    case 3: dev_val = THRERE_IMAGE; break;
                    case 5: dev_val = FIRTS_IMAGE; break;
                    case 6: break;
                    case 7: break;
                }
                break;
            case 1:
                break;
            case 2:
                switch (valor){
                    case 0: dev_val = SECUND_IMAGE;break;
                    case 1: dev_val = THRERE_IMAGE;break;
                    case 2: dev_val = THRERE_IMAGE;break;
                    case 3: dev_val = FIRTS_IMAGE;break;
                    case 4: dev_val = SECUND_IMAGE;break;
                    case 5: dev_val = THRERE_IMAGE;break;
                    case 6: dev_val = SECUND_IMAGE;break;
                    case 7: dev_val = FIRTS_IMAGE;break;
                    case 8: dev_val = THRERE_IMAGE;break;
                    case 9: dev_val = SECUND_IMAGE;break;
                    case 10: dev_val = FIRTS_IMAGE;break;
                    case 11: dev_val = SECUND_IMAGE;break;
                    case 12: dev_val = SECUND_IMAGE;break;
                    case 13: dev_val = FIRTS_IMAGE;break;
                    case 14: dev_val = FIRTS_IMAGE;break;
                    case 15: dev_val = FIRTS_IMAGE;break;
                    case 16: dev_val = THRERE_IMAGE;break;
                    case 17: dev_val = FIRTS_IMAGE;break;

                }
                break;
        }
        return dev_val;
    }

    private void addVal(String v, double d){
        string = v;
        resultado_final = d;
    }

}
