package gt.lea.usaid.perfiladorlinguistico.view.espanol;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.Switch;
import android.widget.TextView;

import gt.lea.usaid.perfiladorlinguistico.R;
import gt.lea.usaid.perfiladorlinguistico.utils.interfaces.OnInitializeComponent;

public class  Gramatica extends Activity implements OnInitializeComponent, View.OnClickListener, CompoundButton.OnCheckedChangeListener {
    private int pregunta = 0;
    //private int strings[] = {R.string.titulo_Gramatica_mam, R.string.inst_eva_expresion_oral},

    private int img[] = {R.mipmap.pelotabasketball, R.mipmap.logolea, R.mipmap.logolea, R.mipmap.lapiz, R.mipmap.abuelo, R.mipmap.maestro, R.mipmap.doctor, R.mipmap.cocinero};
    private int string_muestra[] = {R.string.vi_pelota, R.string.vi_pelotas, R.string.vi_lapices, R.string.vi_lapiz, R.string.vi_abuelo, R.string.vi_maestra, R.string.vi_doctora, R.string.vi_cocinera};
    private TextView tvGramatica, tvRespuesta, nuPregunta;
    private ImageView ivGramatica;
    private RadioButton rbSiGramatica, rbNoGramatica;
    private Switch swGramatica;
    private String resultado ="";
    //private int pregunta = 0;
    private int serie = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gramatica);
        setOnInit(null);
    }

    @Override
    public void setOnInit(@IdRes int[][] matriz) {
        rbSiGramatica = (RadioButton) findViewById(R.id.rbGramaticaSi);
        rbNoGramatica = (RadioButton) findViewById(R.id.rbGramaticaNo);
        ivGramatica = (ImageView) findViewById(R.id.ivGramatica);
        swGramatica = (Switch) findViewById(R.id.swGramatica);
        tvRespuesta =(TextView) findViewById(R.id.tvGramaticaRespuestaSwitch);
        nuPregunta = (TextView) findViewById(R.id.tvGramaticaNumero);
        tvGramatica = (TextView) findViewById(R.id.tvGramaticaTitulo);
        String guarda_numero = "";
        guarda_numero += pregunta +1;
        nuPregunta.setText(guarda_numero);
        int i = string_muestra[pregunta],
                imgs = img[pregunta];//respuesta correcta

        tvRespuesta.setText("");
        ivGramatica.setImageResource(imgs);
        swGramatica.setOnCheckedChangeListener(this);
        rbSiGramatica.setOnClickListener(this);
        rbNoGramatica.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if ((pregunta +1) == img.length){
            setNextContext(this, ExpresionOral.class);
        } else {
            pregunta ++;
            setOnInit(null);
            swGramatica.setChecked(false);
            rbSiGramatica.setChecked(false);
            rbNoGramatica.setChecked(false);
            if(rbSiGramatica.isChecked()){
                resultado += 1;
            }else
                resultado += 0;

        }
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        if(swGramatica.isChecked()){
            int i = string_muestra[pregunta];
            tvRespuesta.setText(i);
        }else
            tvRespuesta.setText("");
    }
    @Override
    protected void onPause() {
        super.onPause();
        finish();
    }


    public void setNextContext(Context context, Class<?> next_context) {
        Intent i = new Intent(context, next_context);
        startActivity(i);
    }
}

