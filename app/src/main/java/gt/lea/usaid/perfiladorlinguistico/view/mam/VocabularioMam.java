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
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import gt.lea.usaid.perfiladorlinguistico.R;
import gt.lea.usaid.perfiladorlinguistico.utils.Lanzador;
import gt.lea.usaid.perfiladorlinguistico.utils.interfaces.OnInitializeComponent;

public class VocabularioMam extends Activity implements OnInitializeComponent, View.OnClickListener, CompoundButton.OnCheckedChangeListener {
    private int pregunta = 0;
    //private int strings[] = {R.string.titulo_VocabularioMam_mam, R.string.inst_eva_expresion_oral},
    private int img[] = {R.mipmap.casa, R.mipmap.cama, R.mipmap.conejo, R.mipmap.caballlo, R.mipmap.huevo, R.mipmap.pollito, R.mipmap.pescado2, R.mipmap.volcan, R.mipmap.camino, R.mipmap.nube};
    private int string_muestra[] = {R.string.iv_jat, R.string.iv_watbil, R.string.iv_xik, R.string.iv_chej, R.string.iv_jos, R.string.iv_bix, R.string.iv_kyix, R.string.iv_witz, R.string.iv_be, R.string.iv_muj};//iv_arbol

    private TextView tvVocabularioMam, tvRespuesta, nuPregunta;
    private ImageView ivVocabularioMam;
    private RadioButton rbSiVocabularioMam, rbNoVocabularioMam;
    private Switch swVocabularioMam;
    private String resultado = "";
    //private int pregunta = 0;
    private int serie = 0;
    //private String resultado_precisiona_mam = "";
    private RadioGroup rgVocabularioMam;
    private String recupera_comprension_mam = "";
    private Lanzador l;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vocabulario_mam);
        l = new Lanzador(this, SonidosEspecificosMam.class);
        recupera_comprension_mam = l.getBundleStringDouble();
        setOnInit(null);
    }

    @Override
    public void setOnInit(@IdRes int[][] matriz) {
        rbSiVocabularioMam = (RadioButton) findViewById(R.id.rbVocabularioMamSi);
        rbNoVocabularioMam = (RadioButton) findViewById(R.id.rbVocabularioMamNo);
        ivVocabularioMam = (ImageView) findViewById(R.id.ivVocabularioMam);
        swVocabularioMam = (Switch) findViewById(R.id.swVocabularioMam);
        tvRespuesta = (TextView) findViewById(R.id.tvVocabularioMamRespuestaSwitch);
        nuPregunta = (TextView) findViewById(R.id.tvVocabularioMamNumero);
        tvVocabularioMam = (TextView) findViewById(R.id.tvVocabularioMamTitulo);
        rgVocabularioMam = (RadioGroup) findViewById(R.id.rgVocabularioMam);
        String guarda_numero = "";
        guarda_numero += pregunta + 1;
        nuPregunta.setText(guarda_numero);
        int i = string_muestra[pregunta],
                imgs = img[pregunta];//respuesta correcta

        tvRespuesta.setText("");
        ivVocabularioMam.setImageResource(imgs);
        swVocabularioMam.setOnCheckedChangeListener(this);
        rbSiVocabularioMam.setOnClickListener(this);
        rbNoVocabularioMam.setOnClickListener(this);
        rgVocabularioMam.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        na();
        if ((pregunta + 1) == img.length) {
            recupera_comprension_mam += resultado;
            l.agregarValores(recupera_comprension_mam, 50.0);
        } else {
            pregunta++;
            setOnInit(null);
            Toast.makeText(this, resultado, Toast.LENGTH_SHORT).show();
            //1010010101
        }
    }

    public void na() {

        if (rbSiVocabularioMam.isChecked()) {
            swVocabularioMam.setChecked(false);
            rgVocabularioMam.clearCheck();
            resultado += 1;
        } else {
            rbSiVocabularioMam.setChecked(false);
            rbNoVocabularioMam.setChecked(false);
            resultado += 0;
        }
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        if (swVocabularioMam.isChecked()) {
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

}

