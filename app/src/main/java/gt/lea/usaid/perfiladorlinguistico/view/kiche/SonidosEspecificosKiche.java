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

public class  SonidosEspecificosKiche extends Activity implements OnInitializeComponent, View.OnClickListener, CompoundButton.OnCheckedChangeListener {
    private int pregunta_toca = 0;
    //private int strings[] = {R.string.titulo_SonidosEspecificosKiche_mam, R.string.inst_eva_expresion_oral},

    private int img[] = {R.mipmap.piedra, R.mipmap.logolea, R.mipmap.arbol, R.mipmap.barrilete, R.mipmap.pavo, R.mipmap.cama, R.mipmap.logolea, R.mipmap.flor, R.mipmap.escalera, R.mipmap.fuego};
    private int string_muestra[] = {R.string.v_ka, R.string.v_si, R.string.v_che, R.string.v_papalot, R.string.v_nos, R.string.v_chat, R.string.v_tzunum, R.string.v_kotzij, R.string.v_qam, R.string.v_qaq};
    private TextView tvSonidosEspecificosKiche, tvRespuesta, nuPregunta;
    private ImageView ivSonidosEspecificosKiche;
    private RadioButton rbSiSonidosEspecificosKiche, rbNoSonidosEspecificosKiche;
    private Switch swSonidosEspecificosKiche;
    private String resultado ="";
    private int pregunta = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sonidos_especificos_kiche);
        setOnInit(null);
    }

    @Override
    public void setOnInit(@IdRes int[][] matriz) {
        rbSiSonidosEspecificosKiche = (RadioButton) findViewById(R.id.rbSonidosEspecificosKicheSi);
        rbNoSonidosEspecificosKiche = (RadioButton) findViewById(R.id.rbSonidosEspecificosKicheNo);
        ivSonidosEspecificosKiche = (ImageView) findViewById(R.id.ivSonidosEspecificosKiche);
        swSonidosEspecificosKiche = (Switch) findViewById(R.id.swSonidosEspecificosKiche);
        tvRespuesta =(TextView) findViewById(R.id.tvSonidosEspecificosKicheRespuestaSwitch);
        nuPregunta = (TextView) findViewById(R.id.tvSonidosEspecificosKicheNumero);
        tvSonidosEspecificosKiche = (TextView) findViewById(R.id.tvSonidosEspecificosKicheTitulo);
        String guarda_numero = "";
        guarda_numero += pregunta;
        nuPregunta.setText(guarda_numero);
        int i = string_muestra[pregunta_toca],
                imgs = img[pregunta_toca];//respuesta correcta

        tvRespuesta.setText("");
        ivSonidosEspecificosKiche.setImageResource(imgs);
        swSonidosEspecificosKiche.setOnCheckedChangeListener(this);
        rbSiSonidosEspecificosKiche.setOnClickListener(this);
        rbNoSonidosEspecificosKiche.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        pregunta_toca ++;
        pregunta ++;
        setOnInit(null);
        swSonidosEspecificosKiche.setChecked(false);
        rbSiSonidosEspecificosKiche.setChecked(false);
        rbNoSonidosEspecificosKiche.setChecked(false);

        if(rbSiSonidosEspecificosKiche.isChecked()){
            resultado += 1;
        }else
            resultado += 0;
        Toast.makeText(this, resultado, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        if(swSonidosEspecificosKiche.isChecked()){
            int i = string_muestra[pregunta_toca];
            tvRespuesta.setText(i);
        }else
            tvRespuesta.setText("");
    }
}

