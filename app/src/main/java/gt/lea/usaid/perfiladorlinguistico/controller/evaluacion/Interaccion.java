package gt.lea.usaid.perfiladorlinguistico.controller.evaluacion;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.v4.app.ActivityCompat;
import android.view.View;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import gt.lea.usaid.perfiladorlinguistico.R;
import gt.lea.usaid.perfiladorlinguistico.controller.control_vista.Verifica;
import gt.lea.usaid.perfiladorlinguistico.utils.Consts;
import gt.lea.usaid.perfiladorlinguistico.utils.Lanzador;
import gt.lea.usaid.perfiladorlinguistico.utils.interfaces.OnInitializeComponent;
import gt.lea.usaid.perfiladorlinguistico.utils.interfaces.OnInitializeText;

/**
 * Created by Bryan on 20/06/16.
 */
public class Interaccion
        extends Activity
        implements OnInitializeComponent, OnInitializeText, View.OnClickListener {

    private RadioButton respuesta1, respuesta2, respuesta3, respuesta4, respuesta5, respuesta6, respuesta7, respuesta8, respuesta9, respuesta10;
    private TextView intruduccion, tvPregunta1, tvPregunta2, tvPregunta3, tvPregunta4, tvPregunta5;
    private static final String NOMBRE_TABLA = "interaccion";
    //public static final String KEY_RESULTADO = "resultado";

    private Lanzador l;
    private int serie = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.interaccion);
        setOnInit(null);
    }

    private void leeIdioma(){
        l = new Lanzador(this, Comprension.class);

        try{
            serie = l.getBundleLanguage();
            onPermission();
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    private void onPermission() throws Exception{
        LocationManager lm = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        lm.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, ubicacion);
    }

    @Override
    public void setOnInit(@IdRes int[][] matriz) {
        leeIdioma();
        respuesta1 = (RadioButton) findViewById(R.id.rbRespuesta1);
        respuesta2 = (RadioButton) findViewById(R.id.rbRespuesta2);
        respuesta3 = (RadioButton) findViewById(R.id.rbRespuesta3);
        respuesta4 = (RadioButton) findViewById(R.id.rbRespuesta4);
        respuesta5 = (RadioButton) findViewById(R.id.rbRespuesta5);
        respuesta6 = (RadioButton) findViewById(R.id.rbRespuesta6);
        respuesta7 = (RadioButton) findViewById(R.id.rbRespuesta7);
        respuesta8 = (RadioButton) findViewById(R.id.rbRespuesta8);
        respuesta9 = (RadioButton) findViewById(R.id.rbRespuesta9);
        respuesta10 = (RadioButton) findViewById(R.id.rbRespuesta10);
        intruduccion = (TextView) findViewById(R.id.tvInstrucionInteractua);
        tvPregunta1 = (TextView) findViewById(R.id.tvPreguntaUnoInteractua);
        tvPregunta2 = (TextView) findViewById(R.id.tvPreguntaDosInteractua);
        tvPregunta3 = (TextView) findViewById(R.id.tvPreguntaTresInteractua);
        tvPregunta4 = (TextView) findViewById(R.id.tvPreguntaCuatroInteractua);
        tvPregunta5 = (TextView) findViewById(R.id.tvPreguntaCincoInteractua);

        textos();

        respuesta9.setOnClickListener(this);
        respuesta10.setOnClickListener(this);
    }

    private void textos(){

        setTextCompoent(Consts.ArregloInteraccion.TEXTOS);
    }

    @Override
    public void setTextCompoent(@IdRes int [][] textos){
        int vector[] = textos[serie];
        int  id_intro = 0, id_resp = 0,id_text1 = 0, id_text2 = 0, id_text3 = 0, id_text4 = 0, id_text5 = 0;
        id_intro = vector[0];
        id_resp = vector[1];
        id_text1 = vector[2];
        id_text2 = vector[3];
        id_text3 = vector[4];
        id_text4 = vector[5];
        id_text5 = vector[6];

        intruduccion.setText(id_intro);
        tvPregunta1.setText(id_text1);
        tvPregunta2.setText(id_text2);
        tvPregunta3.setText(id_text3);
        tvPregunta4.setText(id_text4);
        tvPregunta5.setText(id_text5);
    }

    @Override
    public void onClick(View v) {
        boolean[][] radios_selected = {
                {respuesta1.isChecked(),respuesta3.isChecked(), respuesta5.isChecked(), respuesta7.isChecked(), respuesta9.isChecked()},
                {respuesta2.isChecked(),respuesta4.isChecked(), respuesta6.isChecked(), respuesta8.isChecked(), respuesta10.isChecked()}};
        Verifica vr;
        try {
            vr = new Verifica(radios_selected, NOMBRE_TABLA);
            double resultado = vr.getResultado();
            l.agregarValores(vr.concat(), resultado);
            l.addLanguage(serie);
            l.setLanza(true);
        } catch (Exception e) {
            Toast.makeText(this, e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        finish();
    }

    private Ubicacion ubicacion = new Ubicacion(this) {

        private void msg(String s){
            Toast.makeText(getActivityGPS(), s, Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onProviderEnabled(String provider) {
            msg("GPS ACTIVADO");
        }

        @Override
        public void onProviderDisabled(String provider) {
            msg("GPS DESACTIVADO");
        }
    };
}