package gt.lea.usaid.perfiladorlinguistico.view.evaluacion;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import gt.lea.usaid.perfiladorlinguistico.R;
import gt.lea.usaid.perfiladorlinguistico.controller.IniciarEvaluacion;

import gt.lea.usaid.perfiladorlinguistico.controller.Respuesta;
import gt.lea.usaid.perfiladorlinguistico.utils.ArregloMultiDimensional;
import gt.lea.usaid.perfiladorlinguistico.utils.interfaces.OnInitializeComponent;
import gt.lea.usaid.perfiladorlinguistico.utils.interfaces.OnStartNextContext;
import gt.lea.usaid.perfiladorlinguistico.view.espanol.Vocabulario;

/**
 * @author Bryan
 */
public class Precision extends Activity implements OnInitializeComponent, OnStartNextContext{

    //área de variables privadas
    private ImageView image, image2, image3;
    private TextView tv;
    private int idioma = 0, pregunta = 0, imagenes[][];


    //área declaraciones de matricez

    private int serie = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.precision);
        opcionIdioma();
    }

    private void opcionIdioma(){
        setIdioma();
        switch (idioma){
            case 0: imagenes = ArregloMultiDimensional.ArregloPrecision.IMAGENES[0];break;
            case 1: imagenes = ArregloMultiDimensional.ArregloPrecision.IMAGENES[1];break;
            case 2: imagenes = ArregloMultiDimensional.ArregloPrecision.IMAGENES[2];break;
        }
        setOnInit(imagenes);
    }

    @Override
    public void setOnInit(@IdRes int[][] matriz) {
        try{
            int vector[] = matriz[pregunta];
            int i = optineImage()[pregunta];
            tv = (TextView) findViewById(R.id.tvPreguntaIII);
            tv.setText(i);
            image = (ImageView) findViewById(R.id.ivImagen1);
            image2 = (ImageView) findViewById(R.id.ivImagen2);
            image3 = (ImageView) findViewById(R.id.ivImagen3);
            image.setImageResource(vector[0]);
            image2.setImageResource(vector[1]);
            image3.setImageResource(vector[2]);
            image.setOnClickListener(click);
            image2.setOnClickListener(click);
            image3.setOnClickListener(click);
        }catch (Exception e){
            String msg = e.getMessage() + " Erro de arreglo imagen";
            Toast.makeText(this,e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

    private int[] optineImage(){
        int vector[] = null;
        setIdioma();
        switch (idioma){
            case 0: vector = ArregloMultiDimensional.ArregloPrecision.TEXTOS[0];break;
            case 1: vector = ArregloMultiDimensional.ArregloPrecision.TEXTOS[1];break;
            case 2: vector = ArregloMultiDimensional.ArregloPrecision.TEXTOS[2];break;
        }
        return vector;}

    //private View.OnClickListener click = new View.OnClickListener() {
    //};
    private Respuesta click = new Respuesta() {
        @Override
        public void onClick(View v) {
            boolean condicion = (pregunta + 1) == 18;
            if(condicion){
                setNextContext(Precision.this, Vocabulario.class);
            }else{
                pregunta ++;
                //setOnInit(imagenes);
                opcionIdioma();
            }
        }
    };

    @Override
    public void setNextContext(Context context, Class<?> next_context) {
        Intent i = new Intent(context, next_context);
        startActivity(i);
        Bundle b = new Bundle();
        b.putInt(IniciarEvaluacion.KEY_EVALUACION, serie);
        i.putExtras(b);
        startActivity(i);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        finish();
    }

    private void setIdioma()
    {
        Bundle b = getIntent().getExtras();
        idioma = b.getInt(IniciarEvaluacion.KEY_EVALUACION);
    }
}
