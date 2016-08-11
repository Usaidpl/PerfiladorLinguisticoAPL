package gt.lea.usaid.perfiladorlinguistico.view.guias;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.view.MotionEvent;
import android.widget.ImageView;
import android.widget.ViewFlipper;

import gt.lea.usaid.perfiladorlinguistico.R;
import gt.lea.usaid.perfiladorlinguistico.utils.interfaces.OnInitializeComponent;

/**
 * Created by programadormd on 11/08/16.
 */

public class GuiaPruebas extends Activity implements OnInitializeComponent{

    private ViewFlipper myViewFlipper;
    private float initialXPoint;
    int[] image = {R.mipmap.nina, R.mipmap.pollito,
            R.mipmap.abuelo, R.mipmap.logolea, R.mipmap.anciana,
            R.mipmap.logolea, R.mipmap.aguacate, R.mipmap.logolea,
            R.mipmap.barrilete, R.mipmap.avion};

    private int cuenta = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.guia_pruebas);
        setOnInit(null);
    }

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
                    cuenta ++;
                    myViewFlipper.showNext();
                } else {
                    if (myViewFlipper.getDisplayedChild() == 0)
                        break;
                    //cuenta --;
                    myViewFlipper.showPrevious();
                }
                break;
        }
        setOnInit(null);

        return false;
    }


    @Override
    public void setOnInit(@IdRes int[][] matriz) {
        myViewFlipper = (ViewFlipper) findViewById(R.id.vfGuiaPrecisionOral001);
        ImageView imageView = (ImageView) findViewById(R.id.practica);
        if (cuenta ==9)
            imageView.setImageResource(image[cuenta]);


        //

        //for (int i = 0; i < image.length; i++) {
         //ImageView imageView = new ImageView(GuiaPruebas.this);
        //myViewFlipper.addView(imageView);
        //}
    }
}