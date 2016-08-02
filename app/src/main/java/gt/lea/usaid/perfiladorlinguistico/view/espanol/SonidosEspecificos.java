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

public class  SonidosEspecificos extends Activity implements OnInitializeComponent, View.OnClickListener, CompoundButton.OnCheckedChangeListener {
    private int pregunta = 0;
    //private int strings[] = {R.string.titulo_SonidosEspecificos_mam, R.string.inst_eva_expresion_oral},

    private int img[] = {R.mipmap.pelotabasketball, R.mipmap.bota, R.mipmap.naranja, R.mipmap.elote, R.mipmap.machete, R.mipmap.moto, R.mipmap.helado, R.mipmap.telefono, R.mipmap.gallina, R.mipmap.perro};
    private int string_muestra[] = {R.string.v_pelota, R.string.v_bota, R.string.v_naranja, R.string.v_elote, R.string.v_machete, R.string.v_moto, R.string.v_helado, R.string.v_telefono, R.string.v_gallina, R.string.v_perro};//iv_arbol
    private TextView tvSonidosEspecificos, tvRespuesta, nuPregunta;
    private ImageView ivSonidosEspecificos;
    private RadioButton rbSiSonidosEspecificos, rbNoSonidosEspecificos;
    private Switch swSonidosEspecificos;
    private String resultado ="";
    //private int pregunta = 0;
    private int serie = 0;
    private String resultado_vocabulario = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sonidos_especificos);
        Bundle b = getIntent().getExtras();
        resultado_vocabulario = b.getString("evaluacion");

        setOnInit(null);
    }

    @Override
    public void setOnInit(@IdRes int[][] matriz) {
        rbSiSonidosEspecificos = (RadioButton) findViewById(R.id.rbSonidosEspecificosSi);
        rbNoSonidosEspecificos = (RadioButton) findViewById(R.id.rbSonidosEspecificosNo);
        ivSonidosEspecificos = (ImageView) findViewById(R.id.ivSonidosEspecificos);
        swSonidosEspecificos = (Switch) findViewById(R.id.swSonidosEspecificos);
        tvRespuesta =(TextView) findViewById(R.id.tvSonidosEspecificosRespuestaSwitch);
        nuPregunta = (TextView) findViewById(R.id.tvSonidosEspecificosNumero);
        tvSonidosEspecificos = (TextView) findViewById(R.id.tvSonidosEspecificosTitulo);
        String guarda_numero = "";
        guarda_numero += pregunta+1;
        nuPregunta.setText(guarda_numero);
        int i = string_muestra[pregunta],
                imgs = img[pregunta];//respuesta correcta

        tvRespuesta.setText("");
        ivSonidosEspecificos.setImageResource(imgs);
        swSonidosEspecificos.setOnCheckedChangeListener(this);
        rbSiSonidosEspecificos.setOnClickListener(this);
        rbNoSonidosEspecificos.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if ((pregunta +1) == img.length){
            String resultado_sonido = "";
            resultado_sonido += resultado;
            resultado_vocabulario +=
                    "&&" +resultado_sonido;
            Bundle b = new Bundle();
            b.putString("evaluacion", resultado_sonido);
            Intent i = new Intent(this,Gramatica.class);
            i.putExtras(b);
            startActivity(i);
            //setNextContext(this, Gramatica.class);
        } else {
            pregunta ++;
            setOnInit(null);
            swSonidosEspecificos.setChecked(false);
            rbSiSonidosEspecificos.setChecked(false);
            rbNoSonidosEspecificos.setChecked(false);
            if(rbSiSonidosEspecificos.isChecked()){
                resultado += 1;
            }else
                resultado += 0;

        }
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        if(swSonidosEspecificos.isChecked()){
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

