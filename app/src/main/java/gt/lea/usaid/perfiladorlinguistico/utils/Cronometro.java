package gt.lea.usaid.perfiladorlinguistico.utils;

import android.view.View;

/**
 * Created by programadormd on 08-11-16.
 */
public class Cronometro implements Runnable{


    private boolean cronometroActivo = false;
    private long INCREMENTO = 4;
    private long SEGUNDO = 1000;
    private long MINUTO = 60;
    private String tiempo = "";

    @Override
    public void run() {
        Integer minutos = 0, segundos = 0, milesimas = 0;
        String min="", seg="", mil="";
        try{
            while (cronometroActivo){
                Thread.sleep(INCREMENTO);
                milesimas += 4;
                if(milesimas == SEGUNDO){
                    milesimas = 0;
                    segundos += 1;
                    if(segundos == MINUTO){
                        segundos = 0;
                        minutos ++;
                    }
                }
                if(minutos < 10) min = "0" + minutos;
                else min = minutos.toString();
                if(segundos < 10) seg = "0" + segundos;
                else seg = segundos.toString();
                if(milesimas < 10) mil = "00" + milesimas;
                else if(milesimas < 100) mil = "0" + milesimas;
                else mil = milesimas.toString();

                tiempo = min + ":" + seg + ":" + mil;
            }
        }catch (Exception e){}
        tiempo = "00:00:000";
    }

    public String getTiempo(){
        return tiempo;
    }

    private View.OnClickListener click = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

        }
    };

    public View.OnClickListener getClickActi(){
        cronometroActivo = true;
        return click;
    }
}
