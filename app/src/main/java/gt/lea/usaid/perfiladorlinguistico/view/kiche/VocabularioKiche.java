package gt.lea.usaid.perfiladorlinguistico.view.kiche;

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

public class  VocabularioKiche extends Activity implements OnInitializeComponent, View.OnClickListener, CompoundButton.OnCheckedChangeListener {
    private int pregunta_toca = 0;
    //private int strings[] = {R.string.titulo_VocabularioKiche_mam, R.string.inst_eva_expresion_oral},

    private int img[] = {R.mipmap.casa, R.mipmap.cama, R.mipmap.avion, R.mipmap.silla, R.mipmap.conejo, R.mipmap.caballlo, R.mipmap.zanahoria, R.mipmap.guisquil, R.mipmap.pollito, R.mipmap.manzana};
    private int string_muestra[] = {R.string.casa, R.string.cama, R.string.avion, R.string.silla, R.string.conejo, R.string.caballo, R.string.zanahoria, R.string.guisquil, R.string.gallo, R.string.manzana};//iv_arbol
    private TextView tvVocabularioKiche, tvRespuesta, nuPregunta;
    private ImageView ivVocabularioKiche;
    private RadioButton rbSiVocabularioKiche, rbNoVocabularioKiche;
    private Switch swVocabularioKiche;
    private String resultado ="";
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
        tvRespuesta =(TextView) findViewById(R.id.tvVocabularioKicheRespuestaSwitch);
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
        pregunta_toca ++;
        pregunta ++;
        setOnInit(null);
        swVocabularioKiche.setChecked(false);
        rbSiVocabularioKiche.setChecked(false);
        rbNoVocabularioKiche.setChecked(false);

        if(rbSiVocabularioKiche.isChecked()){
            resultado += 1;
        }else
            resultado += 0;
        Toast.makeText(this, resultado, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        if(swVocabularioKiche.isChecked()){
            int i = string_muestra[pregunta_toca];
            tvRespuesta.setText(i);
        }else
            tvRespuesta.setText("");
    }
}

