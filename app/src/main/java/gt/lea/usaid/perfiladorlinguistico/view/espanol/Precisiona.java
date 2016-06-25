package gt.lea.usaid.perfiladorlinguistico.view.espanol;

//package gt.lea.usaid.perfiladorlinguistico.view;

import android.os.Bundle;
import android.support.annotation.IdRes;
import android.view.View;
import android.widget.ImageView;
import android.widget.ViewFlipper;

import gt.lea.usaid.perfiladorlinguistico.R;
import gt.lea.usaid.perfiladorlinguistico.controller.FlipperActivity;
import gt.lea.usaid.perfiladorlinguistico.utils.anotacion.DocumentAutor;
import gt.lea.usaid.perfiladorlinguistico.utils.interfaces.OnInitializeComponent;

/**
 * Created by Bryan on 20/06/16.
 *
 */
public class Precisiona extends FlipperActivity implements OnInitializeComponent {

    private static final int TOTAL_SERIE = 18;
    private int pregunta = 0;
    private ImageView image, image2, image3;
    private ViewFlipper flipper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.precisiona);
        //int[][] ids = {{R.id.ivPoll, R.id.ivPat, R.id.ivPav},{R.id.ivBonny, R.id.ivDog, R.id.ivGat},{},{}};
    }

    @Override
    public void setOnInit(@IdRes int[][] matriz) {
        flipper = getFlipper(R.id.viewflipper);
        int vector[] = matriz[pregunta], imagen;
        for(int v = 0; v < vector.length; v ++){
            imagen = vector[v];
            if(image == null)
                addId(image, imagen);
            else if(image != null && image2 == null)
                addId(image2, imagen);
            else if(image2 != null && image3 == null)
                addId(image3, imagen);
            // OnClickImage ci = new ();
            //image.setOnClickListener(new OnClickImage(){});
            //image2.setOnClickListener(new OnClickImage());
            //image3.setOnClickListener(new OnClickImage());
            image.setOnClickListener(click);
            image2.setOnClickListener(click);
            image3.setOnClickListener(click);
        }
    }

    protected void addId(ImageView imageView, @IdRes int id){
        imageView = (ImageView) findViewById(id);
    }

    @DocumentAutor(autor = "Bryan", tipy_create = 'F')
    private OnClickImage click = new OnClickImage(){
        int resultado = 0;
        @Override
        public void onClick(View v) {
            if(pregunta == TOTAL_SERIE){
                /*
                 *db.insert(resultado);
                 */
                setNextContext(Precisiona.this, Gramatica.class);
            }
            else{
                resultado += this.selectImageView(v);
                pregunta ++;
            }
        }

        private int getResult(){
            return resultado;
        }
    };

    @DocumentAutor(autor = "Bryan", tipy_create = 'A')
    private abstract class OnClickImage implements View.OnClickListener{

        protected int selectImageView(@DocumentAutor(autor = "Bryan", tipy_create = 'P') View v){
            int result = 0, sub_result = 0, count = 0;

            switch (v.getId()){
                // case R.id.ivPat:
                //    sub_result ++;
                // case R.id.ivGat:
                //     sub_result ++;
                 /*   case R.id.ivVac:
                 case R.id.ivThree:
                    sub_result ++;
                 case R.id.ivElot:
                    sub_result ++;
                 case R.id.iv.banano:
                    sub_result ++;
                 case R.id.ivBus:
                    sub_result ++;
                 case R.id.ivCar:
                    sub_result ++;
                 case R.id.ivPantalon:
                    sub_result ++;
                 case R.id.ivVestido:
                    sub_result ++;
                 case R.id.ivZapat:
                    sub_result ++;
                 case R.id.ivSombrero:
                    sub_result ++;
                 case R.id.ivTable:
                    sub_result ++;
                 case R.id.ivEscalera:
                    sub_result ++;
                 case R.id.ivCanasta:
                    sub_result ++;
                 case R.id.ivPeine:
                    sub_result ++;
                 case R.id.ivBook:
                    sub_result ++;
                 case R.id.ivBicicleta:
                    sub_result ++;
                 default:
                    sub_result += 0;
                  */
            }
            return result;
        }
    }

}//end class
