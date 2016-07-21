package gt.lea.usaid.perfiladorlinguistico.view;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.view.View;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import gt.lea.usaid.perfiladorlinguistico.R;
import gt.lea.usaid.perfiladorlinguistico.controller.IniciarEvaluacion;
import gt.lea.usaid.perfiladorlinguistico.controller.Verifica;
import gt.lea.usaid.perfiladorlinguistico.utils.interfaces.OnInitializeComponent;
import gt.lea.usaid.perfiladorlinguistico.utils.interfaces.OnInitializeText;
import gt.lea.usaid.perfiladorlinguistico.utils.interfaces.OnStartNextContext;
import gt.lea.usaid.perfiladorlinguistico.view.espanol.Interaccion;

/**
 * Created by programadormd on 07-21-16.
 */
/*
public class Comprension extends Activity implements OnStartNextContext,OnInitializeComponent,OnInitializeText, View.OnClickListener{
    private RadioButton respuesta1, respuesta2, respuesta3, respuesta4, respuesta5, respuesta6, respuesta7, respuesta8, respuesta9, respuesta10;
    private static final String NOMBRE_TABLA = "comprencion";
    private static final String NOMBRE_TABLA_KICHE = "compresion_kiche";
    private static final String NOMBRE_TABLA_MAN = "compresion_man";

    private int serie = 0;
    private TextView intruduccion, respuesta_correcta, tvPregunta1, tvPregunta2,tvPregunta3,tvPregunta4,tvPregunta5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle b = getIntent().getExtras();
        try{
            serie = b.getInt(IniciarEvaluacion.KEY_EVALUACION);
        }catch (Exception e){
            msg(e.getMessage());
        }
        setOnInit(null);
    }

    private void msg(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void setTextCompoent(@IdRes int[][] matriz_id_texto) {
        int vector[] = matriz_id_texto[serie];
        int  id_intro = 0, id_resp = 0,id_text1 = 0, id_text2 = 0, id_text3 = 0, id_text4 = 0, id_text5 = 0;
        id_intro = vector[0];
        id_resp = vector[1];
        id_text1 = vector[2];
        id_text2 = vector[3];
        id_text3 = vector[4];
        id_text4 = vector[5];
        id_text5 = vector[6];
        intruduccion.setText(id_intro);
        respuesta_correcta.setText(id_resp);
        tvPregunta1.setText(id_text1);
        tvPregunta2.setText(id_text2);
        tvPregunta3.setText(id_text3);
        tvPregunta4.setText(id_text4);
        tvPregunta5.setText(id_text5);

    }

    @Override
    public void setOnInit(@IdRes int[][] matriz) {
        respuesta1 =(RadioButton) findViewById(R.id.rbRespuesta11);
        respuesta2 = (RadioButton) findViewById(R.id.rbRespuesta12);
        respuesta3 =(RadioButton) findViewById(R.id.rbRespuesta13);
        respuesta4 = (RadioButton) findViewById(R.id.rbRespuesta14);
        respuesta5 =(RadioButton) findViewById(R.id.rbRespuesta15);
        respuesta6 = (RadioButton) findViewById(R.id.rbRespuesta16);
        respuesta7 =(RadioButton) findViewById(R.id.rbRespuesta17);
        respuesta8 = (RadioButton) findViewById(R.id.rbRespuesta18);
        respuesta9 =(RadioButton) findViewById(R.id.rbRespuesta19);
        respuesta10 = (RadioButton) findViewById(R.id.rbRespuesta20);

        intruduccion = (TextView) findViewById(R.id.tvInstrucionComprende);
        respuesta_correcta = (TextView) findViewById(R.id.tvRespuestaComprende);

        tvPregunta1 = (TextView) findViewById(R.id.tvPreguntaUnoComprende);
        tvPregunta2 = (TextView) findViewById(R.id.tvPreguntaDosComprende);
        tvPregunta3 = (TextView) findViewById(R.id.tvPreguntaTresComprende);
        tvPregunta4 = (TextView) findViewById(R.id.tvPreguntaCuatroComprende);
        tvPregunta5 = (TextView) findViewById(R.id.tvPreguntaCincoComprende);
        texto();
        respuesta9.setOnClickListener(this);
        respuesta10.setOnClickListener(this);
    }

    private void texto(){
        int txt[][] =
                {{R.string.tituto_dos_kiche, R.string.i_respusta_correcta_kiche,R.string.ii_pregunta_uno_kiche,
                        R.string.ii_pregunta_dos_kiche, R.string.ii_pregunta_tres_kiche, R.string.ii_pregunta_cuatro_kiche,
                        R.string.ii_pregunta_cinco_kiche},
                        {R.string.comprension, R.string.i_respuesta_man, R.string.ii_pregunta_uno_man,
                                R.string.ii_pregunta_dos_man, R.string.ii_pregunta_tres_man, R.string.ii_pregunta_cuatro_man,
                                R.string.ii_pregunta_cinco_man},
                        {R.string.comprension_sp, R.string.respuesta_sp,
                                R.string.ii_pregunta_uno_sp, R.string.ii_pregunta_dos_sp,
                                R.string.ii_pregunta_tres_sp, R.string.ii_pregunta_cuatro_sp, R.string.ii_pregunta_cinco_sp}};
        setTextCompoent(txt);
    }

    @Override
    public void onClick(View v) {
        boolean[][] radios_selected = {
                {respuesta1.isChecked(),respuesta3.isChecked(), respuesta5.isChecked(), respuesta7.isChecked(), respuesta9.isChecked()},
                {respuesta2.isChecked(),respuesta4.isChecked(), respuesta6.isChecked(), respuesta8.isChecked(), respuesta10.isChecked()}};
        Verifica vr = new Verifica(radios_selected, null);
        try {
            float resultado = vr.getResultado();
            descition(resultado);
            setNextContext(Comprension.this, Precision.class);
        } catch (Exception e) {

            Toast.makeText(this, e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

    private void descition(float resultado){
        if(resultado >= (Verifica.TOTAL_SERIE/50) + 1){
            setNextContext(Comprension.this, Precision.class);
        }
        else{
            setNextContext(this, Interaccion.class);
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        finish();
    }

    @Override
    public void setNextContext(Context context, Class<?> next_context) {
        Bundle b = new Bundle();
        b.putInt(IniciarEvaluacion.KEY_EVALUACION, serie);
        Intent i = new Intent(context, next_context);
        i.putExtras(b);
        startActivity(i);
    }

}*/
