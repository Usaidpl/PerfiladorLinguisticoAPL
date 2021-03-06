package gt.lea.usaid.perfiladorlinguistico.view.kiche;

import android.app.Activity;
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
import gt.lea.usaid.perfiladorlinguistico.controller.control_vista.Verifica;
import gt.lea.usaid.perfiladorlinguistico.utils.Lanzador;
import gt.lea.usaid.perfiladorlinguistico.utils.interfaces.OnInitializeComponent;

public class VocabularioKiche extends Activity implements OnInitializeComponent, View.OnClickListener, CompoundButton.OnCheckedChangeListener {
    private int pregunta = 0;
    //private int strings[] = {R.string.titulo_VocabularioKiche_mam, R.string.inst_eva_expresion_oral},

    private int img[] = {R.mipmap.pescado2, R.mipmap.casa, R.mipmap.tortillas, R.mipmap.culebra, R.mipmap.caballlo, R.mipmap.mono, R.mipmap.perro, R.mipmap.guisquil, R.mipmap.ayote, R.mipmap.hongo};
    private int string_muestra[] = {R.string.iv_kar, R.string.iv_ja, R.string.iv_lej, R.string.iv_kumatz, R.string.iv_kej, R.string.iv_kyo, R.string.iv_tzi, R.string.iv_kix, R.string.iv_mukun, R.string.iv_qatzu};//iv_arbol
    private TextView tvVocabularioKiche, tvRespuesta, nuPregunta;
    private ImageView ivVocabularioKiche;
    private RadioButton rbSiVocabularioKiche, rbNoVocabularioKiche;
    private Switch swVocabularioKiche;
    private String resultado = "";
    private int serie = 0;
    private RadioGroup rgVocabularioKiche;

    private String recupera_comprension_kiche = "";
    private Lanzador l;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vocabulario_kiche);
        l = new Lanzador(this, SonidosEspecificosKiche.class);
        recupera_comprension_kiche = l.getBundleStringDouble();
        Toast.makeText(this, recupera_comprension_kiche, Toast.LENGTH_LONG).show();
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
        rgVocabularioKiche = (RadioGroup) findViewById(R.id.rgVocabularioKiche);
        String guarda_numero = "";
        guarda_numero += pregunta + 1;
        nuPregunta.setText(guarda_numero);
        int i = string_muestra[pregunta],
                imgs = img[pregunta];//respuesta correcta

        tvRespuesta.setText("");
        ivVocabularioKiche.setImageResource(imgs);
        swVocabularioKiche.setOnCheckedChangeListener(this);
        rbSiVocabularioKiche.setOnClickListener(this);
        rbNoVocabularioKiche.setOnClickListener(this);
        rgVocabularioKiche.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        na();
        if ((pregunta + 1) == img.length) {
            String rs = "";
            rs = Verifica.concat(resultado);
            recupera_comprension_kiche += rs;
            l.agregarValores(recupera_comprension_kiche, 50.0);
            String s = l.getBundleStringDouble();
            Toast.makeText(this, s, Toast.LENGTH_LONG).show();

        } else {
            pregunta++;
            setOnInit(null);
            //na();
            Toast.makeText(this, resultado, Toast.LENGTH_SHORT).show();
            //1010010101
        }
    }

    public void na() {
        if (rbSiVocabularioKiche.isChecked()) {
            swVocabularioKiche.setChecked(false);
            rgVocabularioKiche.clearCheck();
            resultado += 1;
        } else {
            rbSiVocabularioKiche.setChecked(false);
            rbNoVocabularioKiche.setChecked(false);
            resultado += 0;//1010101
        }
    }


    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        if (swVocabularioKiche.isChecked()) {
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

