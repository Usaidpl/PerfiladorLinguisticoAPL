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
public class Precision extends Activity implements OnInitializeComponent, OnStartNextContext{

    private int pregunta = 0;
    private ImageView image, image2, image3;
    private TextView tv;
    private int idoma = 0;

    //área estatica
    private static final int PREGUNTA = 3;
    private static final int RESPUESTA_UNO = 1;
    private static final int RESPUESTA_DOS = 2;
    private static final int RESPUESTA_TRES = 3;

    private  int[][] images = {
            {R.mipmap.pollito, R.mipmap.pato, R.mipmap.pavo},
            {R.mipmap.conejo, R.mipmap.perro, R.mipmap.gato},
            {R.mipmap.caballlo,R.mipmap.oveja, R.mipmap.vaca},
            {R.mipmap.arbol, R.mipmap.rosa, R.mipmap.milpa},
            {R.mipmap.ejote, R.mipmap.elote, R.mipmap.ayote},
            {R.mipmap.elote, R.mipmap.zanahoria, R.mipmap.banano},
            {R.mipmap.carro,R.mipmap.camioneta, R.mipmap.camioncito},
            {R.mipmap.carro, R.mipmap.carreta, R.mipmap.mototaxi},
            {R.mipmap.falda, R.mipmap.calceta, R.mipmap.pantalon},
            {R.mipmap.blusa, R.mipmap.vestido, R.mipmap.pantalon},
            {R.mipmap.sombrero, R.mipmap.zapato, R.mipmap.guante},
            {R.mipmap.gorra, R.mipmap.sombrilla, R.mipmap.sombrero},
            {R.mipmap.cama, R.mipmap.mesa, R.mipmap.silla},
            {R.mipmap.escalera, R.mipmap.cubeta, R.mipmap.banco},
            {R.mipmap.canasto, R.mipmap.soplador, R.mipmap.caja},
            {R.mipmap.peine, R.mipmap.cepillo, R.mipmap.logolea},
            {R.mipmap.lapiz, R.mipmap.sacapuntas, R.mipmap.libro},
            {R.mipmap.bicicleta, R.mipmap.moto, R.mipmap.mototaxi}};
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
                setNextContext(Precision.this, Vocabulario.class);
           }else{
               ques(pregunta, v);
               pregunta ++;
               setOnInit(images);
           }
        }

        private int ques(int opcion, View v)
        {
            int resultado = 0, op = des(opcion);
            if((op  + 1 )== (1)){
                switch (v.getId()){
                    case R.id.ivImagen1:
                        resultado = 1;
                        break;
                    default:
                        resultado = 0;
                }
            }else if((op + 1) == (2)){
                switch (v.getId()){
                    case R.id.ivImagen2:
                        resultado = 1;
                        break;
                    default:
                        resultado = 0;
                }
            }else if(op == 3){
                switch (v.getId()){
                    case R.id.ivImagen3:
                        resultado = 1;
                        break;
                    default:
                        resultado =0;
                }
            }
        return  resultado;
        }

        private int  des(int valor){
            int dev_val = 0;
            switch (valor){
                case 0: dev_val = 2;break;
                case 1: dev_val = 3;break;
                case 2: dev_val = 3;break;
                case 3: dev_val = 1;break;
                case 4: dev_val = 2;break;
                case 5: dev_val = 3;break;
                case 6: dev_val = 2;break;
                case 7: dev_val = 1;break;
                case 8: dev_val = 3;break;
                case 9: dev_val = 2;break;
                case 10: dev_val = 2;break;
                case 11: dev_val = 3;break;
                case 12: dev_val = 2;break;
                case 13: dev_val = 1;break;
                case 14: dev_val = 1;break;
                case 15: dev_val = 1;break;
                case 16: dev_val = 3;break;
                case 17: dev_val = 1;break;
            }
            return dev_val;
        }
    };

    @Override
    public void setOnInit(@IdRes int[][] matriz) {
        boolean terminado = false;
        int vector[] = matriz[pregunta];
        String texto[] = {"pato","gato","vaca","arbol","elote","banano","camioneta","carro","pantalon",
        "vestido","zapato","sombrero","mesa","escalera","canasta","peine","libro","bicicleta"};
        tv = (TextView) findViewById(R.id.tvPreguntaIII);
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
