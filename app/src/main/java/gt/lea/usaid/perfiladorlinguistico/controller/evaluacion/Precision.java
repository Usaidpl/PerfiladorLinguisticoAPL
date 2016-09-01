package gt.lea.usaid.perfiladorlinguistico.controller.evaluacion;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import gt.lea.usaid.perfiladorlinguistico.R;
import gt.lea.usaid.perfiladorlinguistico.controller.control_vista.Respuesta;
import gt.lea.usaid.perfiladorlinguistico.utils.ArregloMultiDimensional;
import gt.lea.usaid.perfiladorlinguistico.utils.Lanzador;
import gt.lea.usaid.perfiladorlinguistico.utils.interfaces.OnInitializeComponent;
import gt.lea.usaid.perfiladorlinguistico.view.espanol.Vocabulario;
import gt.lea.usaid.perfiladorlinguistico.view.kiche.VocabularioKiche;
import gt.lea.usaid.perfiladorlinguistico.view.mam.VocabularioMam;

/**
 * @author Bryan
 */
public class Precision extends Activity implements OnInitializeComponent{

    //área de variables privadas
    private ImageView image, image2, image3;
    private TextView tv;
    private int idioma = 0, pregunta = 0, imagenes[][];
    private Lanzador l;
    private Class<?> clase;

    //área declaraciones de matricez
    private int serie = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.precision);
        opcionIdioma();
    }

    private void opcionIdioma(){
        switch (idioma){
            case 0: imagenes = ArregloMultiDimensional.ArregloPrecision.IMAGENES[0];break;
            case 1: imagenes = ArregloMultiDimensional.ArregloPrecision.IMAGENES[1];break;
            case 2: imagenes = ArregloMultiDimensional.ArregloPrecision.IMAGENES[2];break;
        }
        switch (idioma){
            case 0: clase = VocabularioKiche.class;break;
            case 1: clase = VocabularioMam.class;break;
            case 2: clase = Vocabulario.class;break;
        }
        setOnInit(imagenes);
    }

    @Override
    public void setOnInit(@IdRes int[][] matriz) {
        recuperaIdioma();
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
        recuperaIdioma();
        switch (idioma){
            case 0: vector = ArregloMultiDimensional.ArregloPrecision.TEXTOS[0];break;
            case 1: vector = ArregloMultiDimensional.ArregloPrecision.TEXTOS[1];break;
            case 2: vector = ArregloMultiDimensional.ArregloPrecision.TEXTOS[2];break;
        }
        return vector;
    }

    private void recuperaIdioma(){
        l = new Lanzador(this, clase);
        serie = l.getBundleLanguage();
    }

    private Respuesta click = new Respuesta(idioma) {

        @Override
        public void onClick(View v) {
           // this.addClass(Precision.this, clase);
                    boolean condicion = pregunta + 1 == 17;
            String valor_final = "";
            int sf = 0;
            //msg(this.result(pregunta, v));
            if(condicion){
                valor_final = l.getBundleStringDouble() + getString();
                l.agregarValores(valor_final, getDouble());
                valor_final = l.getBundleStringDouble();
                //msg(valor_final);
            }else{
                pregunta ++;
                opcionIdioma();
            }
        }
    };

    @Override
    protected void onPause() {
        super.onPause();
        finish();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        finish();
    }


}
