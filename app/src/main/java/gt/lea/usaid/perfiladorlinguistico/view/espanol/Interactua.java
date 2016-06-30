package gt.lea.usaid.perfiladorlinguistico.view.espanol;

import android.os.Bundle;
import android.support.annotation.IdRes;
import android.view.View;
import android.widget.RadioButton;
import android.widget.Toast;

import gt.lea.usaid.perfiladorlinguistico.R;
import gt.lea.usaid.perfiladorlinguistico.controller.FlipperActivity;
import gt.lea.usaid.perfiladorlinguistico.controller.Verifica;
import gt.lea.usaid.perfiladorlinguistico.utils.ConectaInternet;
import gt.lea.usaid.perfiladorlinguistico.utils.DialogoAlerta;
import gt.lea.usaid.perfiladorlinguistico.utils.interfaces.OnInitializeComponent;

/**
 * Created by Bryan on 20/06/16.
 */
public class Interactua extends FlipperActivity implements OnInitializeComponent, View.OnClickListener  {

    private RadioButton respuesta1, respuesta2, respuesta3, respuesta4, respuesta5, respuesta6, respuesta7, respuesta8, respuesta9, respuesta10;
    private static final String NOMBRE_TABLA = "interaccion";
    private static final String NOMBRE_TABLA_KICKE = "interaccion_kiche";
    private static final String NOMBRE_TABLA_MAN = "interaccion_man";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.interpreta);
        DialogoAlerta d = new DialogoAlerta(this);
        d.alertDialog("Bienvenido","desea proceguir",false);
       setOnInit(null);
    }
    private void msg(String s){
        Toast.makeText(this, s ,Toast.LENGTH_SHORT).show();
    }

    private void conect(){
        ConectaInternet ci = new ConectaInternet(this);
        int result = ci.conectado();
        boolean resultBool = ConectaInternet.conectado(this);

        switch (result){
            case ConectaInternet.CONECTADO:
                msg("Conectado");
                break;
            case ConectaInternet.WIFI:
                msg("Wifi");
                break;
            case ConectaInternet.DATOS:
                msg("Dato");
                break;
            case ConectaInternet.ERROR:
                msg("Error");
                break;
        }

        if(ConectaInternet.conectado(this) == true){
            msg("Conectado");
        }else
            msg("no conectado");
    }


    @Override
    public void setOnInit(@IdRes int[][] matriz) {
        respuesta1 = (RadioButton) findViewById(R.id.rbRespuesta1);
        respuesta2 = (RadioButton) findViewById(R.id.rbRespuesta2);
        respuesta3 = (RadioButton) findViewById(R.id.rbRespuesta3);
        respuesta4 = (RadioButton) findViewById(R.id.rbRespuesta4);
        respuesta5 = (RadioButton) findViewById(R.id.rbRespuesta5);
        respuesta6 = (RadioButton) findViewById(R.id.rbRespuesta6);
        respuesta7 = (RadioButton) findViewById(R.id.rbRespuesta7);
        respuesta8 = (RadioButton) findViewById(R.id.rbRespuesta8);
        respuesta9 = (RadioButton) findViewById(R.id.rbRespuesta9);
        respuesta10 = (RadioButton) findViewById(R.id.rbRespuesta10);

        respuesta9.setOnClickListener(this);
        respuesta10.setOnClickListener(this);
    }

    protected void addId(RadioButton rb, @IdRes int id_radio){
        rb = (RadioButton) findViewById(id_radio);
    }

    @Override
    public void onClick(View v) {
        boolean[][] radios_selected = {
                {respuesta1.isChecked(),respuesta3.isChecked(), respuesta5.isChecked(), respuesta7.isChecked(), respuesta9.isChecked()},
                {respuesta2.isChecked(),respuesta4.isChecked(), respuesta6.isChecked(), respuesta8.isChecked(), respuesta10.isChecked()}};
        Verifica vr = new Verifica(radios_selected, NOMBRE_TABLA);
        try {
            float resultado = vr.getResultado();
            descition(resultado);
            setNextContext(Interactua.this, Comprende.class);
        } catch (Exception e) {
            Toast.makeText(this, e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

    private void descition(float resultado){
        if(resultado >= (100/50) + 1) {
            setNextContext(this, Interactua.class);

        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        finish();
    }
}