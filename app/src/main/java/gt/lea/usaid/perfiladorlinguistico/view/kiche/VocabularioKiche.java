package gt.lea.usaid.perfiladorlinguistico.view.kiche;

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
import gt.lea.usaid.perfiladorlinguistico.view.espanol.SonidosEspecificos;

public class VocabularioKiche extends Activity implements OnInitializeComponent, View.OnClickListener, CompoundButton.OnCheckedChangeListener {
    private int pregunta_toca = 0;
    private int serie = 0;
    //private int strings[] = {R.string.titulo_VocabularioKiche_mam, R.string.inst_eva_expresion_oral},

    private int img[] = {R.mipmap.pescado2, R.mipmap.casa, R.mipmap.tortillas, R.mipmap.culebra, R.mipmap.caballlo, R.mipmap.mono, R.mipmap.perro, R.mipmap.guisquil, R.mipmap.ayote, R.mipmap.hongo};
    private int string_muestra[] = {R.string.iv_kar, R.string.iv_ja, R.string.iv_lej, R.string.iv_kumatz, R.string.iv_kej, R.string.iv_kyo, R.string.iv_tzi, R.string.iv_kix, R.string.iv_mukun, R.string.iv_qatzu};//iv_arbol
    private TextView tvVocabularioKiche, tvRespuesta, nuPregunta;
    private ImageView ivVocabularioKiche;
    private RadioButton rbSiVocabularioKiche, rbNoVocabularioKiche;
    private Switch swVocabularioKiche;
    private String resultado = "";
    private int pregunta = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vocabulario_kiche);
        setOnInit(null);
    }

    @Override
    public void setOnInit(@IdRes int[][] matriz) {
        rbSiVocabularioKiche = (RadioButton) findViewById(R.id.rbVocabularioKicheSi);
        rbNoVocabularioKiche = (RadioButton) findViewById(R.id.rbVocabularioKicheNo);
        ivVocabularioKiche = (ImageView) findViewById(R.id.ivVocabularioKiche);
        swVocabularioKiche = (Switch) findViewById(R.id.swVocabularioKiche);
        tvRespuesta = (TextView) findViewById(R.id.tvVocabularioKicheRespuestaSwitch);
        nuPregunta = (TextView) findViewById(R.id.tvVocabularioKicheNumero);
        tvVocabularioKiche = (TextView) findViewById(R.id.tvVocabularioKicheTitulo);
        String guarda_numero = "";
        guarda_numero += pregunta;
        nuPregunta.setText(guarda_numero);
        int i = string_muestra[pregunta_toca],
                imgs = img[pregunta_toca];//respuesta correcta

        tvRespuesta.setText("");
        ivVocabularioKiche.setImageResource(imgs);
        swVocabularioKiche.setOnCheckedChangeListener(this);
        rbSiVocabularioKiche.setOnClickListener(this);
        rbNoVocabularioKiche.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        pregunta_toca++;
        pregunta++;
        setOnInit(null);
        swVocabularioKiche.setChecked(false);
        rbSiVocabularioKiche.setChecked(false);
        rbNoVocabularioKiche.setChecked(false);

        if (rbSiVocabularioKiche.isChecked()) {
            resultado += 1;
            setNextContext(VocabularioKiche.this, SonidosEspecificos.class);
        } else
            resultado += 0;
        setNextContext(VocabularioKiche.this, SonidosEspecificos.class);
        //Toast.makeText(this, resultado, Toast.LENGTH_SHORT).show();

    }


    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        if (swVocabularioKiche.isChecked()) {
            int i = string_muestra[pregunta_toca];
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
        Bundle b = new Bundle();
        b.putInt(IniciarEvaluacion.KEY_EVALUACION, serie);
        Intent i = new Intent(context, next_context);
        i.putExtras(b);
        startActivity(i);
    }
}

