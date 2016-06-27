package gt.lea.usaid.perfiladorlinguistico.view.espanol;

import android.os.Bundle;
import android.support.annotation.IdRes;
import android.view.View;
import android.widget.RadioButton;

import gt.lea.usaid.perfiladorlinguistico.R;
import gt.lea.usaid.perfiladorlinguistico.controller.FlipperActivity;
import gt.lea.usaid.perfiladorlinguistico.utils.interfaces.OnInitializeComponent;

/**
 * Created by Bryan on 20/06/16.
 */
public class Comprende extends FlipperActivity implements OnInitializeComponent, View.OnClickListener{
    private RadioButton respuesta1, respuesta2, respuesta3, respuesta4, respuesta5, respuesta6, respuesta7, respuesta8, respuesta9, respuesta10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.comprende);
        setOnInit(null);
    }

    @Override
    public void onClick(View v) {

    }

    @Override
    public void setOnInit(@IdRes int[][] matriz) {

    }
/*
    @Override
    public void setOnInit(@IdRes int[][] matriz) {
        addId(respuesta1, R.id.rbResp1);
        addId(respuesta3, R.id.rbResp3);
        addId(respuesta5, R.id.rbResp5);
        addId(respuesta7, R.id.rbResp7);
        addId(respuesta9, R.id.rbResp9);
//        respuesta9.setOnClickListener(this);
        //      respuesta10.setOnClickListener(this);
    }

    protected void addId(RadioButton rb, @IdRes int id_radio){
        rb = (RadioButton) findViewById(id_radio);
    }

    @Override
    public void onClick(View v) {
        boolean[][] radios_selected = {
                {respuesta1.isChecked(),respuesta3.isChecked(), respuesta5.isChecked(), respuesta7.isChecked(), respuesta9.isChecked()},
                {respuesta2.isChecked(),respuesta4.isChecked(), respuesta6.isChecked(), respuesta8.isChecked(), respuesta10.isChecked()}};
        Verifica vr = new Verifica(radios_selected);
        try {
            float resultado = vr.getResultado();
            descition(resultado);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void descition(float resultado){
        if(resultado >= (Verifica.TOTAL_SERIE/50) + 1){
            setNextContext(this, Interactua.class);
            //Clase de conexion a base de datos
            //db.insert(resultado);
        }
        else{
            setNextContext(this, Interactua.class);
            //Clase de conexion a base de datos
            //db.insert(resultado);
        }

    }
    */
}
