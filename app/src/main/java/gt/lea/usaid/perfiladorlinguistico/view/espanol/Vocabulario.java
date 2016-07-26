package gt.lea.usaid.perfiladorlinguistico.view.espanol;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import gt.lea.usaid.perfiladorlinguistico.R;
import gt.lea.usaid.perfiladorlinguistico.utils.interfaces.OnInitializeComponent;

public class Vocabulario extends Activity implements OnInitializeComponent, View.OnClickListener, CompoundButton.OnCheckedChangeListener {
    private int pregunta_toca = 0;
    //private int strings[] = {R.string.titulo_vocabulario_mam, R.string.inst_eva_expresion_oral},
    private static final int img[] = {R.mipmap.casa, R.mipmap.cama, R.mipmap.avion, R.mipmap.silla, R.mipmap.conejo, R.mipmap.caballlo, R.mipmap.zanahoria, R.mipmap.guisquil, R.mipmap.pollito, R.mipmap.manzana};
    private int string_muestra[] = {R.string.iv_casa, R.string.iv_cama, R.string.iv_avion, R.string.iv_silla, R.string.iv_conejo, R.string.iv_caballo, R.string.iv_zanahoria, R.string.iv_guisquil, R.string.iv_gallo, R.string.iv_manzana};//iv_arbol

    private TextView tvVocabulario, tvRespuesta, nuPregunta;
    private ImageView ivVocabulario;
    //private RadioGroup rgVocabulario, rgVocabulario2;
    private RadioButton rbSiVocabulario, rbNoVocabulario;
    private Switch swVocabulario;
    private String resultado = "";
    private int pregunta = 1;

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
        //rgVocabulario = (RadioGroup) findViewById(R.id.rgVocabulario);
        String guarda_numero = "";
        guarda_numero += pregunta;
        nuPregunta.setText(guarda_numero);
        int i = string_muestra[pregunta_toca],
                imgs = img[pregunta_toca];//respuesta correcta

        tvRespuesta.setText("");
        ivVocabulario.setImageResource(imgs);
        swVocabulario.setOnCheckedChangeListener(this);
        //rgVocabulario.setOnClickListener(this);
        //rgVocabulario2.setOnClickListener(this);
        rbSiVocabulario.setOnClickListener(this);
        rbNoVocabulario.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        pregunta_toca++;
        pregunta++;
        setOnInit(null);
        swVocabulario.setChecked(false);
        //rgVocabulario.setClickable(false);
        rbSiVocabulario.setChecked(false);
        rbNoVocabulario.setChecked(false);
        if((pregunta + 1) != img.length)
        //if (pregunta == arreglo.length) setOnNextText(this,class);
        //else setOnInit(arreglo);



        if (rbSiVocabulario.isChecked()) {
            resultado += 1;
        } else
            resultado += 0;
        Toast.makeText(this, resultado, Toast.LENGTH_SHORT).show();
        //Intent i = new Intent(this, SonidosEspecificos.class );
        //startActivity(i);
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        if (swVocabulario.isChecked()) {
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
}

