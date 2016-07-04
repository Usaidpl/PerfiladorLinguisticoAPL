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
import gt.lea.usaid.perfiladorlinguistico.utils.ConectaInternet;
import gt.lea.usaid.perfiladorlinguistico.utils.interfaces.OnInitializeComponent;
import gt.lea.usaid.perfiladorlinguistico.utils.interfaces.OnInitializeText;

/**
 * Created by Bryan on 20/06/16.
 */
public class Comprende extends FlipperActivity implements OnInitializeComponent,OnInitializeText,View.OnClickListener{

    private RadioButton respuesta1, respuesta2, respuesta3, respuesta4, respuesta5, respuesta6, respuesta7, respuesta8, respuesta9, respuesta10;
    private static final String NOMBRE_TABLA = "comprencion";
    private static final String NOMBRE_TABLA_KICHE = "compresion_kiche";
    private static final String NOMBRE_TABLA_MAN = "compresion_man";
    private int serie = 0;
    private TextView intruduccion, respuesta_correcta, tvPregunta1, tvPregunta2,tvPregunta3,tvPregunta4,tvPregunta5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.comprende);
        setOnInit(null);
    }

    @Override
    public void setTextCompoent(@IdRes int[][] matriz_id_texto) {

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
        //Modificar ID correspientes al layout
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
        Verifica vr = new Verifica(radios_selected, null);
        try {
            float resultado = vr.getResultado();
            descition(resultado);
            setNextContext(Comprende.this, Precisiona.class);
        } catch (Exception e) {
            //e.printStackTrace();
            Toast.makeText(this, e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

    private void descition(float resultado){
        if(resultado >= (Verifica.TOTAL_SERIE/50) + 1){
            setNextContext(Comprende.this, Precisiona.class);
        }
        else{
            setNextContext(this, Interactua.class);
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        finish();
    }


}
