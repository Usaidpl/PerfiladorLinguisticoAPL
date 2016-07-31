package gt.lea.usaid.perfiladorlinguistico.view.mam;

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
import gt.lea.usaid.perfiladorlinguistico.controller.IniciarEvaluacion;
import gt.lea.usaid.perfiladorlinguistico.utils.interfaces.OnInitializeComponent;
import gt.lea.usaid.perfiladorlinguistico.view.espanol.Gramatica;

public class  SonidosEspecificosMam extends Activity implements OnInitializeComponent, View.OnClickListener, CompoundButton.OnCheckedChangeListener {
    private int pregunta = 0;
    //private int strings[] = {R.string.titulo_SonidosEspecificosMam_mam, R.string.inst_eva_expresion_oral},

    private int img[] = {R.mipmap.piedra, R.mipmap.estrella, R.mipmap.logolea, R.mipmap.libro, R.mipmap.jarra, R.mipmap.dinero, R.mipmap.plato, R.mipmap.fuego, R.mipmap.ayote, R.mipmap.cerdo};
    private int string_muestra[] = {R.string.v_ka2, R.string.v_chew, R.string.v_si2, R.string.v_uj, R.string.v_xar, R.string.v_pwaq, R.string.v_laq, R.string.v_qaq2, R.string.v_kum, R.string.v_boch};//iv_arbol
    private TextView tvSonidosEspecificosMam, tvRespuesta, nuPregunta;
    private ImageView ivSonidosEspecificosMam;
    private RadioButton rbSiSonidosEspecificosMam, rbNoSonidosEspecificosMam;
    private Switch swSonidosEspecificosMam;
    private String resultado ="";
    //private int pregunta = 0;
    private int serie = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sonidos_especificos_mam);
        setOnInit(null);
    }

    @Override
    public void setOnInit(@IdRes int[][] matriz) {
        rbSiSonidosEspecificosMam = (RadioButton) findViewById(R.id.rbSonidosEspecificosMamSi);
        rbNoSonidosEspecificosMam = (RadioButton) findViewById(R.id.rbSonidosEspecificosMamNo);
        ivSonidosEspecificosMam = (ImageView) findViewById(R.id.ivSonidosEspecificosMam);
        swSonidosEspecificosMam = (Switch) findViewById(R.id.swSonidosEspecificosMam);
        tvRespuesta =(TextView) findViewById(R.id.tvSonidosEspecificosMamRespuestaSwitch);
        nuPregunta = (TextView) findViewById(R.id.tvSonidosEspecificosMamNumero);
        tvSonidosEspecificosMam = (TextView) findViewById(R.id.tvSonidosEspecificosMamTitulo);
        String guarda_numero = "";
        guarda_numero += pregunta+1;
        nuPregunta.setText(guarda_numero);
        int i = string_muestra[pregunta],
                imgs = img[pregunta];//respuesta correcta

        tvRespuesta.setText("");
        ivSonidosEspecificosMam.setImageResource(imgs);
        swSonidosEspecificosMam.setOnCheckedChangeListener(this);
        rbSiSonidosEspecificosMam.setOnClickListener(this);
        rbNoSonidosEspecificosMam.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if ((pregunta +1) == img.length){
            setNextContext(this, Gramatica.class);
        } else {
            pregunta ++;
            setOnInit(null);
            swSonidosEspecificosMam.setChecked(false);
            rbSiSonidosEspecificosMam.setChecked(false);
            rbNoSonidosEspecificosMam.setChecked(false);
            if(rbSiSonidosEspecificosMam.isChecked()){
                resultado += 1;
            }else
                resultado += 0;

        }}
    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        if(swSonidosEspecificosMam.isChecked()){
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
        Bundle b = new Bundle();
        b.putInt(IniciarEvaluacion.KEY_EVALUACION, serie);
        Intent i = new Intent(context, next_context);
        i.putExtras(b);
        startActivity(i);
    }
}

