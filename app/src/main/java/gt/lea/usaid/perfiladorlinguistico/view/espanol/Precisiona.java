package gt.lea.usaid.perfiladorlinguistico.view.espanol;

import android.os.Bundle;
import android.support.annotation.IdRes;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;
import android.widget.ViewFlipper;

import gt.lea.usaid.perfiladorlinguistico.R;
import gt.lea.usaid.perfiladorlinguistico.controller.FlipperActivity;
import gt.lea.usaid.perfiladorlinguistico.utils.interfaces.OnInitializeComponent;

/**
 * Created by Bryan on 20/06/16.
 *
 */
public class Precisiona extends FlipperActivity implements OnInitializeComponent {

    private static final int TOTAL_SERIE = 5;//18;
    private int pregunta = 0;
    private ImageView image, image2, image3;
    private ViewFlipper flipper;
    private int[][] ids = {
            {R.id.ivPoll, R.id.ivPat, R.id.ivPav},
            {R.id.ivCon, R.id.ivPerr, R.id.ivGat},{R.id.ivCaball,R.id.ivOvej,R.id.ivVac},
            {R.id.ivArb,R.id.ivRosa,R.id.ivMazorca},{R.id.Ejote, R.id.ivElet, R.id.ivCalaza},
            {R.id.ivElo, R.id.ivZona, R.id.ivBanano}};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.precisiona);
        setOnInit(ids);
    }

    @Override
    public void setOnInit(@IdRes int[][] matriz) {
        this.setFlipperId(R.id.flipper);
        flipper = getFlipper();

            int vector[] = matriz[pregunta], imagen;
            for(int v = 0; v < vector.length; v ++){
                imagen = vector[v];
                if(image == null)
                    image =(ImageView) findViewById(imagen);
                else if(image != null && image2 == null)
                    image2 =(ImageView) findViewById(imagen);
                else if(image2 != null && image3 == null)
                    image3 =(ImageView) findViewById(imagen);
            }
        image.setOnClickListener(click);
        image2.setOnClickListener(click);
        image3.setOnClickListener(click);
    }


    private View.OnClickListener click = new View.OnClickListener(){
        int resultado = 0;
        @Override
        public void onClick(View v) {
            this.selectImageView(v);
            //setNextContext(Precisiona.this, ExpresionOral.class);

            if(pregunta == TOTAL_SERIE){
                resultado += selectImageView(v);
                String s = String.valueOf(resultado);
                Toast.makeText(Precisiona.this,s,Toast.LENGTH_SHORT).show();
                setNextContext(Precisiona.this, Gramatica.class);
            }
            else{
                resultado += this.selectImageView(v);
                pregunta ++;
                clearImage();
                setOnInit(ids);
                flipper.showNext();
            }
        //selectImageView(v);

        }

        private int selectImageView(View v){
            int result = 0, sub_result = 0, count = 0;
            switch (v.getId()){
                case R.id.ivPat:
                    sub_result ++;

                    break;
                case R.id.ivGat:
                         sub_result ++;
                    break;
                case R.id.ivVac:
                    sub_result ++;
                    break;
                 case R.id.ivArb:
                    sub_result ++;
                     break;
                 case R.id.ivElet:
                    sub_result ++;
                     break;
                 case R.id.ivBanano:
                    sub_result ++;
                     break;
                 /*case R.id.ivBus:
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
                    sub_result ++;*/
                default:
                    sub_result += 0;
            }

            result = sub_result;
            //setNextContext(Precisiona.this, Vocabulario.class);
            return result;
        }
        private int getResult(){
            return resultado;
        }
    };

    @Override
    protected void onPause() {
        super.onPause();
        finish();
    }

    private void clearImage(){
        image = null;
        image2 = null;
        image3 = null;
    }
}//end class
