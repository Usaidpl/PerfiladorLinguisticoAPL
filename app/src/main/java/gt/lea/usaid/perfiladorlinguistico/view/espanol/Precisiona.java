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
import gt.lea.usaid.perfiladorlinguistico.view.kiche.VocabularioKiche;
import gt.lea.usaid.perfiladorlinguistico.view.mam.VocabularioMam;

/**
 * Created by Bryan on 20/06/16.
 *
 */
public class Precisiona extends FlipperActivity implements OnInitializeComponent {

    private static final int TOTAL_SERIE = 5;//18;
    private static final long PAUSA = 5000;
    private int pregunta = 0;
    private ImageView image, image2, image3;
    private ViewFlipper flipper;
    private int[][] ids = {
            {R.id.ivPoll, R.id.ivPat, R.id.ivPav}, {R.id.ivCon, R.id.ivPerr, R.id.ivGat},
            {R.id.ivCaball,R.id.ivOvej,R.id.ivVac}, {R.id.ivArb,R.id.ivRosa,R.id.ivMazorca},
            {R.id.ivElet, R.id.ivElet, R.id.ivCalaza}, {R.id.ivElo, R.id.ivZona, R.id.ivBanano}};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.precisiona);
        setOnInit(ids);
    }

    @Override
    public void setOnInit(@IdRes final int[][] matriz) {
        try{
            this.setFlipperId(R.id.flipper);
            flipper = getFlipper();
        }catch (RuntimeException e){
            String s = e.getMessage() + " flipper";
            Toast.makeText(this, e.getMessage(), Toast.LENGTH_SHORT).show();
        }
        Thread t = new Thread(new Runnable() {
            int[][] m = matriz;
            @Override
            public void run() {
                int vector[], imagen;
                try {
                    vector = m[pregunta];
                    image = (ImageView) findViewById(vector[0]);
                    image2 = (ImageView) findViewById(vector[1]);
                    image3 = (ImageView) findViewById(vector[2]);

                    image.setOnClickListener(click);
                    image2.setOnClickListener(click);
                    image3.setOnClickListener(click);
                    Thread.sleep(PAUSA);
                } catch (InterruptedException e) {
                    String s = e.getMessage() + " Vector";
                    Toast.makeText(Precisiona.this, s, Toast.LENGTH_LONG).show();
                }
            }
        });
        t.start();
    }

    private View.OnClickListener click = new View.OnClickListener(){
        int resultado = 0;
        String s = null;
        @Override
        public void onClick(View v) {
            this.selectImageView(v);

            if(pregunta == TOTAL_SERIE){
                int serie = 0;
                switch (serie){
                    case 0:
                        resultado += selectImageView(v);
                        s = String.valueOf(resultado);
                        setNextContext(Precisiona.this, VocabularioKiche.class);break;
                    case 1:
                        resultado += selectImageView(v);
                        s = String.valueOf(resultado);
                        setNextContext(Precisiona.this, Vocabulario.class);break;
                    case 2:
                        resultado += selectImageView(v);
                        s = String.valueOf(resultado);
                        setNextContext(Precisiona.this, VocabularioMam.class);break;
                }
            }
            else{
                resultado += this.selectImageView(v);

                pregunta ++;
                clearImage();
                setOnInit(ids);
                flipper.showNext();
            }
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
            return result;
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
