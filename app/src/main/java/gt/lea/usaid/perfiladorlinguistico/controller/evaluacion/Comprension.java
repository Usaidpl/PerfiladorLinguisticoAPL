package gt.lea.usaid.perfiladorlinguistico.controller.evaluacion;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.view.View;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import gt.lea.usaid.perfiladorlinguistico.NavigationMenu;
import gt.lea.usaid.perfiladorlinguistico.R;
import gt.lea.usaid.perfiladorlinguistico.controller.control_vista.Verifica;
import gt.lea.usaid.perfiladorlinguistico.utils.ArregloMultiDimensional;
import gt.lea.usaid.perfiladorlinguistico.utils.Lanzador;
import gt.lea.usaid.perfiladorlinguistico.utils.interfaces.OnInitializeComponent;
import gt.lea.usaid.perfiladorlinguistico.utils.interfaces.OnInitializeText;
import gt.lea.usaid.perfiladorlinguistico.view.espanol.Vocabulario;

/**
 * Created by Bryan on 20/06/16.
 */
public class Comprension
        extends Activity
        implements OnInitializeComponent,OnInitializeText, View.OnClickListener  {

    private RadioButton respuesta1, respuesta2, respuesta3, respuesta4, respuesta5, respuesta6, respuesta7, respuesta8, respuesta9, respuesta10;
    private TextView intruduccion,  tvPregunta1, tvPregunta2, tvPregunta3, tvPregunta4, tvPregunta5;
    private static final String NOMBRE_TABLA = "interaccion";

    private Lanzador l;
    private int serie = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.interaccion);
        setOnInit(null);
    }

    private void leeIdioma(){
        l = new Lanzador(this, Precision.class);
        try{
            serie = l.getBundleLanguage();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    protected void msg(String s){
        Toast.makeText(this, s ,Toast.LENGTH_SHORT).show();
    }

    protected void msgL(String msg){
        Toast.makeText(this, msg, Toast.LENGTH_LONG).show();
    }
    @Override
    public void setOnInit(@IdRes int[][] matriz) {
        leeIdioma();
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
        // respuesta_correcta = (TextView) findViewById(R.id.tvRespuestaInteractua);
        tvPregunta1 = (TextView) findViewById(R.id.tvPreguntaUnoInteractua);
        tvPregunta2 = (TextView) findViewById(R.id.tvPreguntaDosInteractua);
        tvPregunta3 = (TextView) findViewById(R.id.tvPreguntaTresInteractua);
        tvPregunta4 = (TextView) findViewById(R.id.tvPreguntaCuatroInteractua);
        tvPregunta5 = (TextView) findViewById(R.id.tvPreguntaCincoInteractua);
        //método encargado de agregar los textos correpondientes con base al idioma seleccionado
        texto();
        //evento de click
        respuesta9.setOnClickListener(this);
        respuesta10.setOnClickListener(this);
    }

    private void texto(){

        setTextCompoent(ArregloMultiDimensional.ArregloComprension.TEXTOS);
    }

    @Override
    public void setTextCompoent(@IdRes int [][] textos){
        int vector[] = textos[serie];
        int  id_intro = 0, id_resp = 0,id_text1 = 0, id_text2 = 0, id_text3 = 0, id_text4 = 0, id_text5 = 0;
        id_intro = vector[0];
        id_resp = vector[1];
        id_text1 = vector[2];
        id_text2 = vector[3];
        id_text3 = vector[4];
        id_text4 = vector[5];
        id_text5 = vector[6];
        intruduccion.setText(id_intro);
        //respuesta_correcta.setText(id_resp);
        tvPregunta1.setText(id_text1);
        tvPregunta2.setText(id_text2);
        tvPregunta3.setText(id_text3);
        tvPregunta4.setText(id_text4);
        tvPregunta5.setText(id_text5);
    }

    @Override
    public void onClick(View v) {
        boolean[][] radios_selected = {
                {respuesta1.isChecked(),respuesta3.isChecked(), respuesta5.isChecked(), respuesta7.isChecked(), respuesta9.isChecked()},
                {respuesta2.isChecked(),respuesta4.isChecked(), respuesta6.isChecked(), respuesta8.isChecked(), respuesta10.isChecked()}};
        Verifica vr;
        try {
            vr = new Verifica(radios_selected, NOMBRE_TABLA);
            float resultado = vr.getResultado();
            descition(resultado, vr);
        } catch (Exception e) {
            Toast.makeText(this, e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

    private void descition(float resultado, Verifica verifica){
        double total = (l.getTotal() + resultado) / 2;
        boolean negativo = (total <= 50);
        String interaccion = "";
        if((total > 50) && (serie == 0 || serie == 1 || serie == 2)){
            interaccion = l.getBundleStringDouble() + verifica.concat();
            l.agregarValores(interaccion, resultado);
            l.addLanguage(serie);
            l.setLanza(true);
        }
        else if(negativo && (serie == 0 || serie == 1)){
            serie = 2;
            l = new Lanzador(this, Interaccion.class);
            l.addLanguage(serie);
        }else if(negativo && (serie == 2)){
            l = new Lanzador(this, NavigationMenu.class);
            l.setLanza(true);
        }
        interaccion = l.getBundleStringDouble();
        msgL(interaccion);
    }

    @Override
    protected void onPause() {
        super.onPause();
        finish();
        //01010 56

        //01010101010 | 20 && 1010101 | 50
    }

    private void msg(float f){
        String s = "";
        s += f;
        Toast.makeText(this, s, Toast.LENGTH_SHORT).show();}


}