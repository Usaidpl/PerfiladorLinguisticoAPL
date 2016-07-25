package gt.lea.usaid.perfiladorlinguistico.view.mam;

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

public class  VocabularioMam extends Activity implements OnInitializeComponent, View.OnClickListener, CompoundButton.OnCheckedChangeListener {
    private int pregunta_toca = 0;
    //private int strings[] = {R.string.titulo_VocabularioMam_mam, R.string.inst_eva_expresion_oral},

    private int img[] = {R.mipmap.casa, R.mipmap.cama, R.mipmap.avion, R.mipmap.silla, R.mipmap.conejo, R.mipmap.caballlo, R.mipmap.zanahoria, R.mipmap.guisquil, R.mipmap.pollito, R.mipmap.manzana};
    private int string_muestra[] = {R.string.casa, R.string.cama, R.string.avion, R.string.silla, R.string.conejo, R.string.caballo, R.string.zanahoria, R.string.guisquil, R.string.gallo, R.string.manzana};//iv_arbol
    private TextView tvVocabularioMam, tvRespuesta, nuPregunta;
    private ImageView ivVocabularioMam;
    private RadioButton rbSiVocabularioMam, rbNoVocabularioMam;
    private Switch swVocabularioMam;
    private String resultado ="";
    private int pregunta = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vocabulario_mam);
        setOnInit(null);
    }

    @Override
    public void setOnInit(@IdRes int[][] matriz) {
        rbSiVocabularioMam = (RadioButton) findViewById(R.id.rbVocabularioMamSi);
        rbNoVocabularioMam = (RadioButton) findViewById(R.id.rbVocabularioMamNo);
        ivVocabularioMam = (ImageView) findViewById(R.id.ivVocabularioMam);
        swVocabularioMam = (Switch) findViewById(R.id.swVocabularioMam);
        tvRespuesta =(TextView) findViewById(R.id.tvVocabularioMamRespuestaSwitch);
        nuPregunta = (TextView) findViewById(R.id.tvVocabularioMamNumero);
        tvVocabularioMam = (TextView) findViewById(R.id.tvVocabularioMamTitulo);
        String guarda_numero = "";
        guarda_numero += pregunta;
        nuPregunta.setText(guarda_numero);
        int i = string_muestra[pregunta_toca],
                imgs = img[pregunta_toca];//respuesta correcta

        tvRespuesta.setText("");
        ivVocabularioMam.setImageResource(imgs);
        swVocabularioMam.setOnCheckedChangeListener(this);
        rbSiVocabularioMam.setOnClickListener(this);
        rbNoVocabularioMam.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        pregunta_toca ++;
        pregunta ++;
        setOnInit(null);
        swVocabularioMam.setChecked(false);
        rbSiVocabularioMam.setChecked(false);
        rbNoVocabularioMam.setChecked(false);

        if(rbSiVocabularioMam.isChecked()){
            resultado += 1;
        }else
            resultado += 0;
        Toast.makeText(this, resultado, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        if(swVocabularioMam.isChecked()){
            int i = string_muestra[pregunta_toca];
            tvRespuesta.setText(i);
        }else
            tvRespuesta.setText("");
    }
}

