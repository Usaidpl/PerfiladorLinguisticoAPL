package gt.lea.usaid.perfiladorlinguistico.view.espanol;

import android.os.Bundle;
import android.support.annotation.IdRes;
import android.view.MotionEvent;
import android.view.View;
import android.widget.RadioButton;
import android.widget.Toast;
import android.widget.ViewFlipper;

import gt.lea.usaid.perfiladorlinguistico.NavigationMenu;
import gt.lea.usaid.perfiladorlinguistico.R;
import gt.lea.usaid.perfiladorlinguistico.controller.FlipperActivity;
import gt.lea.usaid.perfiladorlinguistico.controller.Verifica;
import gt.lea.usaid.perfiladorlinguistico.utils.interfaces.OnInitializeComponent;

/**
 * Created by Roberto on 19/06/2016.
 */
public class ExpresionOral extends FlipperActivity implements OnInitializeComponent, View.OnClickListener{
    private RadioButton RespNoPregunta1, RespSiPregunta1, RespNoPregunta2, RespSiPregunta2, RespNoPregunta3, RespSiPregunta3, RespNoPregunta4, RespSiPregunta4;
    private ViewFlipper vfEvaExpresionOral;
    private float lastX;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.expresion_oral);
        vfEvaExpresionOral = (ViewFlipper) findViewById(R.id.vfEvaExpresionOral);
        setOnInit(null);


    }

    public void setOnInit(@IdRes int[][] matriz) {
        RespNoPregunta1 =(RadioButton) findViewById(R.id.RespNoPregunta1);
        RespSiPregunta1 = (RadioButton) findViewById(R.id.RespSiPregunta1);
        RespNoPregunta2 =(RadioButton) findViewById(R.id.RespNoPregunta2);
        RespSiPregunta2 = (RadioButton) findViewById(R.id.RespSiPregunta2);
        RespNoPregunta3 =(RadioButton) findViewById(R.id.RespNoPregunta3);
        RespSiPregunta3 = (RadioButton) findViewById(R.id.RespSiPregunta3);
        RespNoPregunta4 =(RadioButton) findViewById(R.id.RespNoPregunta4);
        RespSiPregunta4 = (RadioButton) findViewById(R.id.RespSiPregunta4);
        RespNoPregunta4.setOnClickListener(this);
        RespSiPregunta4.setOnClickListener(this);

    }
    @Override
    public void onClick(View v) {
        boolean[][] radios_selected = {
                {RespNoPregunta1.isChecked(),RespNoPregunta2.isChecked(), RespNoPregunta3.isChecked(), RespNoPregunta4.isChecked()},
                {RespSiPregunta1.isChecked(),RespSiPregunta2.isChecked(), RespSiPregunta3.isChecked(), RespSiPregunta4.isChecked()}};
        Verifica vr = new Verifica(radios_selected, null);
        try {
            float resultado = vr.getResultado(Verifica.Pregunta.Expresa.PREGUNTA);
            descition(resultado);
            setNextContext(ExpresionOral.this, NavigationMenu.class);
        } catch (Exception e) {
            //e.printStackTrace();
            Toast.makeText(this, e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

    private void descition(float resultado){
        if(resultado >= (100/40) + 1) {
            setNextContext(ExpresionOral.this, NavigationMenu.class);
        }
        else{
            setNextContext(this, Interaccion.class);
        }
    }


    @Override
    protected void onPause() {
        super.onPause();
        finish();
    }

    public boolean onTouchEvent(MotionEvent touchevent) {
        switch (touchevent.getAction()) {

            case MotionEvent.ACTION_DOWN:
                lastX = touchevent.getX();
                break;
            case MotionEvent.ACTION_UP:
                float currentX = touchevent.getX();

                if (lastX < currentX) {

                    if (vfEvaExpresionOral.getDisplayedChild() == 0)
                        break;

                    vfEvaExpresionOral.setInAnimation(this, R.anim.slide_in_from_left);

                    vfEvaExpresionOral.setOutAnimation(this, R.anim.slide_out_to_right);

                    vfEvaExpresionOral.showNext();
                }

                if (lastX > currentX) {

                    if (vfEvaExpresionOral.getDisplayedChild() == 1)
                        break;

                    vfEvaExpresionOral.setInAnimation(this, R.anim.slide_in_from_right);
                    vfEvaExpresionOral.setOutAnimation(this, R.anim.slide_out_to_left);

                    vfEvaExpresionOral.showPrevious();
                }
                break;
        }
        return false;
    }


}