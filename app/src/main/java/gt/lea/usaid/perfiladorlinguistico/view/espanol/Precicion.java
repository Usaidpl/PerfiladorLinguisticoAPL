package gt.lea.usaid.perfiladorlinguistico.view.espanol;

import android.os.Bundle;
import android.support.annotation.IdRes;
import android.view.View;
import android.widget.ImageView;
import android.widget.ViewFlipper;

import gt.lea.usaid.perfiladorlinguistico.R;
import gt.lea.usaid.perfiladorlinguistico.controller.FlipperActivity;
import gt.lea.usaid.perfiladorlinguistico.utils.interfaces.OnInitializeComponent;

/**
 * Created by Bryan on 20/06/16.
 */
public class Precicion extends FlipperActivity implements OnInitializeComponent, View.OnClickListener {

    private int pregunta = 0;
    private ImageView image, image2, image3;
    private ViewFlipper flipper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.presicion);
        // int[][] ids = {{R.id.ivPo, R.id.ivPat, R.id.ivPav},{R.id.ivCon, R.id.ivPer, R.id.Gat},{},{}};
    }

    @Override
    public void setOnInit(@IdRes int[][] matriz) {
        flipper = getFlipper(R.id.flipperP);
        int vector[] = matriz[pregunta], imagen = 0;
        for(int v = 0; v < vector.length; v ++){
            imagen = vector[v];
            if(image == null)
                addId(image, imagen);
            else if(image != null && image2 == null)
                addId(image2, imagen);
            else if(image2 != null && image3 == null)
                addId(image3, imagen);

            image.setOnClickListener(this);
            image2.setOnClickListener(this);
            image3.setOnClickListener(this);
        }
    }

    protected void addId(ImageView imageView, @IdRes int id){
        imageView = (ImageView) findViewById(id);
    }

    @Override
    public void onClick(View v) {

    }
}
