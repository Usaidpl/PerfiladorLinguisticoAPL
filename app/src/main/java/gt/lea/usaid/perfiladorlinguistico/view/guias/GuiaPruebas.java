package gt.lea.usaid.perfiladorlinguistico.view.guias;

import android.app.Activity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterViewFlipper;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ViewFlipper;

import java.util.List;

import gt.lea.usaid.perfiladorlinguistico.AdapterFlipper;
import gt.lea.usaid.perfiladorlinguistico.Dos;
import gt.lea.usaid.perfiladorlinguistico.R;

/**
 * Created by programadormd on 11/08/16.
 */

public class GuiaPruebas extends Activity /*implements OnInitializeComponent*/{

    private ViewFlipper myViewFlipper;
    private AdapterViewFlipper adapterViewFlipper;
    private float initialXPoint;
    private int image[] = {R.mipmap.nina, R.mipmap.pollito, R.mipmap.abuelo, R.mipmap.logolea, R.mipmap.anciana, R.mipmap.logolea, R.mipmap.aguacate, R.mipmap.logolea, R.mipmap.barrilete, R.mipmap.avion};
    private String texto_guias[] = {String.valueOf(R.string.manzana), String.valueOf(R.string.manzana), String.valueOf(R.string.manzana), String.valueOf(R.string.manzana), String.valueOf(R.string.manzana), String.valueOf(R.string.manzana), String.valueOf(R.string.manzana), String.valueOf(R.string.manzana), String.valueOf(R.string.gallo), String.valueOf(R.string.avion)};
    private ImageView ivGuiaPrueba;
    private TextView tvGuiaPrueba;
    private int pregunta = 0;
    private List<AdapterFlipper> itemlist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.guia_pruebas);
       // setOnInit(null);
        Dos dos = new Dos(this);
        myViewFlipper = (ViewFlipper) findViewById(R.id.vfPrueba);
        myViewFlipper.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return false;
            }
        });
        adapterViewFlipper.setAdapter(dos);
    }

/*
    @Override
    public boolean onTouchEvent(MotionEvent event) {

        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                initialXPoint = event.getX();
                break;
            case MotionEvent.ACTION_UP:
                float finalx = event.getX();
                if (initialXPoint > finalx) {
                    if (myViewFlipper.getDisplayedChild() == image.length)
                        break;
                    pregunta ++;

                    setOnInit(null);
                    myViewFlipper.showNext();
                } else {
                    if (myViewFlipper.getDisplayedChild() == 0)
                        break;
                    //pregunta --;
                    myViewFlipper.showPrevious();
                }
                break;
        }

        return false;
    }


    @Override
    public void setOnInit(@IdRes int[][] matriz) {
        myViewFlipper = (ViewFlipper) findViewById(R.id.vfGuiaPrecisionOral001);
        tvGuiaPrueba = (TextView) findViewById(R.id.tvGuiaGramatica);
        ivGuiaPrueba = (ImageView) findViewById(R.id.ivGuiaGramatica);

        //ImageView imageView = new ImageView(GuiaPruebas.this);
        */
/*String guarda_numero = "";
        guarda_numero += pregunta + 1 ;
        tvGuiaPrueba.setText(texto_guias);
        int i = texto_guias[pregunta],
                imgs = image[pregunta];*//*

        */
/*
        ivGuiaPrueba.setImageResource(imgs);
        // ImageView imageView = (ImageView) findViewById(R.id.practica);
        if (pregunta ==1)
            //imageView.setImageResource(image[pregunta]);
        *//*



        //

        //for (int i = 0; i < image.length; i++) {
         //I
        //myViewFlipper.addView(imageView);
        //}
    }
*/

}