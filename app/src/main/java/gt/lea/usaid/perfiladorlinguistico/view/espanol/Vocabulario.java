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

public class Vocabulario extends Activity implements OnInitializeComponent, View.OnClickListener, CompoundButton.OnCheckedChangeListener {
    //private int pregunta_toca = 0;
    //private int strings[] = {R.string.titulo_vocabulario_mam, R.string.inst_eva_expresion_oral},
    private static final int img[] = {R.mipmap.casa, R.mipmap.cama, R.mipmap.avion, R.mipmap.silla, R.mipmap.conejo, R.mipmap.caballlo, R.mipmap.zanahoria, R.mipmap.guisquil, R.mipmap.pollito, R.mipmap.manzana};
    private int string_muestra[] = {R.string.iv_casa, R.string.iv_cama, R.string.iv_avion, R.string.iv_silla, R.string.iv_conejo, R.string.iv_caballo, R.string.iv_zanahoria, R.string.iv_guisquil, R.string.iv_gallo, R.string.iv_manzana};//iv_arbol

    private TextView tvVocabulario, tvRespuesta, nuPregunta;
    private ImageView ivVocabulario;
    //private RadioGroup rgVocabulario, rgVocabulario2;
    private RadioButton rbSiVocabulario, rbNoVocabulario;
    private Switch swVocabulario;
    private String resultado = "";
    private int pregunta = 0;
    private int serie = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vocabulario);
        setOnInit(null);
    }

    @Override
    public void setOnInit(@IdRes int[][] matriz) {
        rbSiVocabulario = (RadioButton) findViewById(R.id.rbVocabularioSi);
        rbNoVocabulario = (RadioButton) findViewById(R.id.rbVocabularioNo);
        ivVocabulario = (ImageView) findViewById(R.id.ivVocabulario);
        swVocabulario = (Switch) findViewById(R.id.swVocabulario);
        tvRespuesta = (TextView) findViewById(R.id.tvVocabularioRespuestaSwitch);
        nuPregunta = (TextView) findViewById(R.id.tvVocabularioNumero);
        tvVocabulario = (TextView) findViewById(R.id.tvVocabularioTitulo);
        String guarda_numero = "";
        guarda_numero += pregunta+1;
        nuPregunta.setText(guarda_numero);
        int i = string_muestra[pregunta],
                imgs = img[pregunta];//respuesta correcta

        tvRespuesta.setText("");
        ivVocabulario.setImageResource(imgs);
        swVocabulario.setOnCheckedChangeListener(this);
        rbNoVocabulario.setOnClickListener(this);
        rbSiVocabulario.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        //pregunta_toca ++;
        /*
       */
        if ((pregunta +1) == img.length){
            setNextContext(this, SonidosEspecificos.class);
        } else {
            pregunta ++;
            setOnInit(null);
            swVocabulario.setChecked(false);
            rbSiVocabulario.setChecked(false);
            rbNoVocabulario.setChecked(false);
            if(rbSiVocabulario.isChecked()){
                resultado += 1;
            }else
                resultado += 0;

        }

        //Toast.makeText(this, resultado, Toast.LENGTH_SHORT).show();
    }


    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        if (swVocabulario.isChecked()) {
            int i = string_muestra[pregunta];
            tvRespuesta.setText(i);
        } else
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

