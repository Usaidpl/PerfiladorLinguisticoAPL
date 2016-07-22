package gt.lea.usaid.perfiladorlinguistico.model;

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
    private int strings[] = {R.string.titulo_vocabulario_mam, R.string.inst_eva_expresion_oral},
            img[] = {R.mipmap.casa, R.mipmap.cama, R.mipmap.avion, R.mipmap.silla, R.mipmap.conejo, R.mipmap.caballlo, R.mipmap.zanahoria, R.mipmap.guisquil, R.mipmap.pollito, R.mipmap.manzana};
    private int string_muestra[] = {R.string.casa, R.string.cama, R.string.avion, R.string.silla, R.string.conejo, R.string.caballo, R.string.zanahoria, R.string.guisquil, R.string.gallo, R.string.manzana};//iv_arbol
    private TextView tv, tv2, nuPregunta;
    private ImageView iv;
    private RadioButton rbSi, rbNo;
    private Switch st;
    private String resultado ="";
    private int pregunta = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vocabulario);
        setOnInit(null);
    }

    @Override
    public void setOnInit(@IdRes int[][] matriz) {
        rbSi = (RadioButton) findViewById(R.id.rbVocabularioSi);
        rbNo = (RadioButton) findViewById(R.id.rbVocabularioNo);
        iv = (ImageView) findViewById(R.id.ivVocabulario);
        st = (Switch) findViewById(R.id.swVocabulario);
        tv2 =(TextView) findViewById(R.id.tvVocabularioRespuestaSwitch);
        nuPregunta = (TextView) findViewById(R.id.tvVocabularioNumero);
        String guarda_numero = "";
        guarda_numero += pregunta;
        nuPregunta.setText(guarda_numero);
        int i = strings[pregunta_toca],
                imgs = img[pregunta_toca];//respuesta correcta
        tv = (TextView) findViewById(R.id.tvVocabularioTitulo);
        tv.setText(i);
        tv2.setText("");
        iv.setImageResource(imgs);
        st.setOnCheckedChangeListener(this);
        rbSi.setOnClickListener(this);
        rbNo.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        pregunta_toca ++;
        pregunta ++;
        setOnInit(null);
        st.setChecked(false);
        rbSi.setChecked(false);
        rbNo.setChecked(false);

        if(rbSi.isChecked()){
            resultado += 1;
        }else
            resultado += 0;
        Toast.makeText(this, resultado, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        if(st.isChecked()){
            int i = string_muestra[pregunta_toca];
            tv2.setText(i);
        }else
            tv2.setText("");
    }
    }

