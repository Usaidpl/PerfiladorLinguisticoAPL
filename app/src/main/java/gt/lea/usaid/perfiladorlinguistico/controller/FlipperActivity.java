package gt.lea.usaid.perfiladorlinguistico.controller;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.IdRes;
import android.widget.ViewFlipper;

import gt.lea.usaid.perfiladorlinguistico.utils.interfaces.OnStartNextContext;

/**
 * Created by Bryan on 20/06/16.
 */
public class FlipperActivity extends Activity implements OnStartNextContext {
    private ViewFlipper flipper;

    public void setFlipperId(@IdRes int flipperId){
        flipper = (ViewFlipper) findViewById(flipperId);
    }

    protected ViewFlipper getFlipper(){
        return   flipper;
    }

    protected  ViewFlipper getFlipper(@IdRes int flipperId){
        flipper = (ViewFlipper) findViewById(flipperId);
        return flipper;
    }

    @Override
    public void setNextContext(Context context, Class<?> next_context) {
        Intent i = new Intent(context, next_context);
        startActivity(i);
    }


}
