package gt.lea.usaid.perfiladorlinguistico.view;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import gt.lea.usaid.perfiladorlinguistico.R;
import gt.lea.usaid.perfiladorlinguistico.controller.IniciarEvaluacion;
import gt.lea.usaid.perfiladorlinguistico.utils.interfaces.OnInitializeComponent;
import gt.lea.usaid.perfiladorlinguistico.utils.interfaces.OnStartNextContext;
import gt.lea.usaid.perfiladorlinguistico.view.espanol.Vocabulario;

/**
 * @author Bryan
 */
public class Precisiona extends Activity implements OnInitializeComponent, OnStartNextContext{

    private int pregunta = 0;
    private ImageView image, image2, image3;
    private TextView tv;
    private int idoma = 0;

    //área estatica
    private static final int PREGUNTA = 3;

    private  int[][] images = {
            {R.mipmap.pollito, R.mipmap.pato, R.mipmap.pavo},
            {R.mipmap.conejo, R.mipmap.perro, R.mipmap.gato},
            {R.mipmap.caballlo,R.mipmap.vaca, R.mipmap.oveja}};
    private int serie = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.precision);
        setOnInit(images);
    }

    private View.OnClickListener click = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
           if((pregunta + 1) == images.length){
                setNextContext(Precisiona.this, Vocabulario.class);
           }else{
               pregunta ++;
               setOnInit(images);
           }
        }
    };

    @Override
    public void setOnInit(@IdRes int[][] matriz) {
        boolean terminado = false;
        int vector[] = matriz[pregunta];
        String texto[] = {"PATO", "GATO","VACA"};
        tv = (TextView) findViewById(R.id.tvTituloPresicion);
        tv.setText(texto[pregunta]);
        image = (ImageView) findViewById(R.id.ivImagen1);
        image2 = (ImageView) findViewById(R.id.ivImagen2);
        image3 = (ImageView) findViewById(R.id.ivImagen3);
        image.setImageResource(vector[0]);
        image2.setImageResource(vector[1]);
        image3.setImageResource(vector[2]);
        image.setOnClickListener(click);
        image2.setOnClickListener(click);
        image3.setOnClickListener(click);
    }

    private void question(){
    }

    @Override
    public void setNextContext(Context context, Class<?> next_context) {
        Intent i = new Intent(context, next_context);
        startActivity(i);
        Bundle b = new Bundle();
        b.putInt(IniciarEvaluacion.KEY_EVALUACION, serie);
        i.putExtras(b);
        startActivity(i);
    }
}
