package gt.lea.usaid.perfiladorlinguistico.view.espanol;

import android.os.Bundle;
import android.support.annotation.IdRes;
import android.view.View;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import gt.lea.usaid.perfiladorlinguistico.R;
import gt.lea.usaid.perfiladorlinguistico.controller.FlipperActivity;
import gt.lea.usaid.perfiladorlinguistico.controller.IniciarEvaluacion;
import gt.lea.usaid.perfiladorlinguistico.controller.Verifica;
import gt.lea.usaid.perfiladorlinguistico.utils.interfaces.OnInitializeText;
import gt.lea.usaid.perfiladorlinguistico.utils.interfaces.OnInitializeComponent;

/**
 * Created by Bryan on 20/06/16.
 */
public class Interactua extends FlipperActivity implements OnInitializeComponent,OnInitializeText, View.OnClickListener  {

    private RadioButton respuesta1, respuesta2, respuesta3, respuesta4, respuesta5, respuesta6, respuesta7, respuesta8, respuesta9, respuesta10;
    private TextView intruduccion, respuesta_correcta, tvPregunta1, tvPregunta2, tvPregunta3, tvPregunta4, tvPregunta5;
    private static final String NOMBRE_TABLA = "interaccion";
    private static final String NOMBRE_TABLA_KICKE = "interaccion_kiche";
    private static final String NOMBRE_TABLA_MAN = "interaccion_man";
    private int serie = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.interpreta);
        setOnInit(null);
        Bundle b = getIntent().getExtras();
        serie = b.getInt(IniciarEvaluacion.KEY_EVALUACION);

        int textos_idiomas[][] = {
                //primer vector -- idioma Quiche
                {R.string.Ins_EspQui_SerD2, R.string.RespuestaCorrecta_EspQui,
                R.string.Pre1_EspQui_SerD_TabI, R.string.Pre2_EspQui_SerD_TabI, R.string.Pre3_EspQui_SerD_TabI,
                R.string.Pre4_EspQui_SerD_TabI, R.string.Pre5_EspQui_SerD_TabI},
                //Segundo vector
                //Agregar los string de cada idioma -- Man
                {R.string.Ins_MamEsp_SerD_I, R.string.RespCorr_MamEsp,
                        R.string.Pre1_MamEsp_SerD_I, R.string.Pre2_MamEsp_SerD_I, R.string.Pre3_MamEsp_SerD_I,
                        R.string.Pre4_MamEsp_SerD_I, R.string.Pre5_MamEsp_SerD_I},
                //string de idioma español
                {R.string.Ins_MamEsp_SerE_I, R.string.RespuestaCorrecta_Esp,
                R.string.Pre1_MamEsp_SerE_I, R.string.Pre2_MamEsp_SerE_I, R.string.Pre3_MamEsp_SerE_I,
                        R.string.Pre4_MamEsp_SerE_I, R.string.Pre5_MamEsp_SerE_I}};

        setTextCompoent(textos_idiomas);
    }

    @Override
    public void setTextCompoent(@IdRes int [][] textos){
        int vector[] = null, texto = 0;
        vector = textos[serie];
        for(int v = 0; v < vector.length; v++){
            texto = vector[v];
            intruduccion.setText(texto);
            respuesta_correcta.setText(texto);
            tvPregunta1.setText(texto);
            tvPregunta2.setText(texto);
            tvPregunta3.setText(texto);
            tvPregunta4.setText(texto);
            tvPregunta5.setText(texto);
        }
    }
    private void msg(String s){
        Toast.makeText(this, s ,Toast.LENGTH_SHORT).show();
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
        //Textos -- TextView
        intruduccion = (TextView) findViewById(R.id.tvInstrucionInteractua);
        respuesta_correcta = (TextView) findViewById(R.id.tvRespuestaInteractua);

        tvPregunta1 = (TextView) findViewById(R.id.tvPreguntaUnoComprende);
        tvPregunta2 = (TextView) findViewById(R.id.tvPreguntaDosInteractua);
        tvPregunta3 = (TextView) findViewById(R.id.tvPreguntaTresInteractua);
        tvPregunta4 = (TextView) findViewById(R.id.tvPreguntaCuatroInteractua);
        tvPregunta5 = (TextView) findViewById(R.id.tvPreguntaCincoInteractua);


        respuesta9.setOnClickListener(this);
        respuesta10.setOnClickListener(this);
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
        if(resultado >= (100/50) + 1)
            setNextContext(this, Interactua.class);
    }

    @Override
    protected void onPause() {
        super.onPause();
        finish();
    }
}