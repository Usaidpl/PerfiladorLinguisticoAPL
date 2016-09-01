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
import gt.lea.usaid.perfiladorlinguistico.controller.control_vista.TouchFlipper;
import gt.lea.usaid.perfiladorlinguistico.controller.control_vista.Verifica;
import gt.lea.usaid.perfiladorlinguistico.utils.Lanzador;
import gt.lea.usaid.perfiladorlinguistico.utils.interfaces.OnInitializeComponent;

public class ExpresionOral extends TouchFlipper implements OnInitializeComponent, View.OnClickListener {
    private RadioButton RespNoPregunta1, RespSiPregunta1, RespNoPregunta2, RespSiPregunta2, RespNoPregunta3, RespSiPregunta3, RespNoPregunta4, RespSiPregunta4;
    private ViewFlipper vfEvaExpresionOral;
    private float lastX;
    private String resultado_gramatica="";

    private String recupera_gramatica;
    private Lanzador l;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_expresion_oral);
        vfEvaExpresionOral = (ViewFlipper) findViewById(R.id.vfEvaExpresionOral);
        recuperaIntento();
        setOnInit(null);
    }
    private void recuperaIntento(){
        l = new Lanzador(this);
        recupera_gramatica = l.getBundleStringDouble();
    }

    @Override
    public void onClick(View v) {
        boolean[][] radios_selected = {
                {RespSiPregunta1.isChecked(), RespSiPregunta2.isChecked(), RespSiPregunta3.isChecked(), RespSiPregunta4.isChecked()},
                {RespNoPregunta1.isChecked(), RespNoPregunta2.isChecked(), RespNoPregunta3.isChecked(), RespNoPregunta4.isChecked()}};
        Verifica vr = new Verifica(radios_selected, null);
        try {
            float resultado = vr.getResultado(Verifica.Pregunta.Expresa.PREGUNTA);
            String datos = recupera_gramatica + "&&" +vr.concat();
            msg(datos);
            descition(resultado, vr);

            //setNextContext(ExpresionOralKiche.this, Vocabulario.class);
        } catch (Exception e) {
            //e.printStackTrace();
            Toast.makeText(this, e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

    private void descition(float resultado, Verifica v) {
        l.agregarValores(v.concat(), resultado);
        resultado_gramatica += l.getBundleStringDouble();
        l = new Lanzador(this, NavigationMenu.class);
        l.setLanza(true);
    }
    private void msg(String msg){
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void setOnInit(@IdRes int[][] matriz) {
        RespNoPregunta1 = (RadioButton) findViewById(R.id.RespNoPregunta1);
        RespSiPregunta1 = (RadioButton) findViewById(R.id.RespSiPregunta1);
        RespNoPregunta2 = (RadioButton) findViewById(R.id.RespNoPregunta2);
        RespSiPregunta2 = (RadioButton) findViewById(R.id.RespSiPregunta2);
        RespNoPregunta3 = (RadioButton) findViewById(R.id.RespNoPregunta3);
        RespSiPregunta3 = (RadioButton) findViewById(R.id.RespSiPregunta3);
        RespNoPregunta4 = (RadioButton) findViewById(R.id.RespNoPregunta4);
        RespSiPregunta4 = (RadioButton) findViewById(R.id.RespSiPregunta4);
        RespNoPregunta4.setOnClickListener(this);
        RespSiPregunta4.setOnClickListener(this);
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
                    vfEvaExpresionOral.showPrevious();
                    vfEvaExpresionOral.showPrevious();
                    vfEvaExpresionOral.showPrevious();
                }
                if (lastX > currentX) {
                    vfEvaExpresionOral.showNext();
                    vfEvaExpresionOral.showNext();
                    vfEvaExpresionOral.showNext();
                }
                break;
        }
        return false;
    }
}