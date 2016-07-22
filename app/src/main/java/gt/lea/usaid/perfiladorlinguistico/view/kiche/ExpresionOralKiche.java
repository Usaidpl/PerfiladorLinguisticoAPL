package gt.lea.usaid.perfiladorlinguistico.view.kiche;

import android.content.Context;
import android.content.Intent;
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

import gt.lea.usaid.perfiladorlinguistico.controller.IniciarEvaluacion;
import gt.lea.usaid.perfiladorlinguistico.controller.Verifica;
import gt.lea.usaid.perfiladorlinguistico.utils.interfaces.OnInitializeComponent;
import gt.lea.usaid.perfiladorlinguistico.view.evaluacion.Interaccion;

/**
 * Created by Roberto on 19/06/2016.
 */
public class ExpresionOralKiche extends FlipperActivity implements OnInitializeComponent, View.OnClickListener{
    private RadioButton RespNoPregunta1, RespSiPregunta1, RespNoPregunta2, RespSiPregunta2, RespNoPregunta3, RespSiPregunta3, RespNoPregunta4, RespSiPregunta4;
    private ViewFlipper vfEvaExpresionOralKiche;
    private float lastX;

    //public static final String KEY = "ESPAÑOL";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.expresion_oral_kiche);
        vfEvaExpresionOralKiche = (ViewFlipper) findViewById(R.id.vfEvaExpresionOralKiche);
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
            setNextContext(ExpresionOralKiche.this, Interaccion.class);
        } catch (Exception e) {
            //e.printStackTrace();
            Toast.makeText(this, e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

    private void descition(float resultado){
        if(resultado >= (100/40) + 1) {
            setNextContext(ExpresionOralKiche.this, NavigationMenu.class);
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

                    if (vfEvaExpresionOralKiche.getDisplayedChild() == 0)
                        break;

                    vfEvaExpresionOralKiche.setInAnimation(this, R.anim.slide_in_from_left);

                    vfEvaExpresionOralKiche.setOutAnimation(this, R.anim.slide_out_to_right);

                    vfEvaExpresionOralKiche.showNext();
                }

                if (lastX > currentX) {

                    if (vfEvaExpresionOralKiche.getDisplayedChild() == 1)
                        break;

                    vfEvaExpresionOralKiche.setInAnimation(this, R.anim.slide_in_from_right);
                    vfEvaExpresionOralKiche.setOutAnimation(this, R.anim.slide_out_to_left);

                    vfEvaExpresionOralKiche.showPrevious();
                }
                break;
        }
        return false;
    }

    @Override
    public void setNextContext(Context context, Class<?> next_context) {
        Intent i = new Intent(context, next_context);
        Bundle b = new Bundle();
        b.putInt(IniciarEvaluacion.KEY_EVALUACION, 2);
        i.putExtras(b);
        startActivity(i);
    }
}