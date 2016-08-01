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

public class  GramaticaKiche extends Activity implements OnInitializeComponent, View.OnClickListener, CompoundButton.OnCheckedChangeListener {
    private int pregunta = 0;
    //private int strings[] = {R.string.titulo_GramaticaKiche_mam, R.string.inst_eva_expresion_oral},

    private int img[] = {R.mipmap.sandalia, R.mipmap.logolea, R.mipmap.gato, R.mipmap.gatos, R.mipmap.senior, R.mipmap.seniora, R.mipmap.abuelo, R.mipmap.logolea};
    private int string_muestra[] = {R.string.vi_xajab, R.string.vi_taqxajab, R.string.vi_mes, R.string.vi_taqmes, R.string.vi_ali, R.string.vi_tat, R.string.vi_mam, R.string.vi_pendiente};
    private TextView tvGramaticaKiche, tvRespuesta, nuPregunta;
    private ImageView ivGramaticaKiche;
    private RadioButton rbSiGramaticaKiche, rbNoGramaticaKiche;
    private Switch swGramaticaKiche;
    private String resultado ="";
   // private int pregunta = 0;
    private int serie = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gramatica_kiche);
        setOnInit(null);
    }

    @Override
    public void setOnInit(@IdRes int[][] matriz) {
        rbSiGramaticaKiche = (RadioButton) findViewById(R.id.rbGramaticaKicheSi);
        rbNoGramaticaKiche = (RadioButton) findViewById(R.id.rbGramaticaKicheNo);
        ivGramaticaKiche = (ImageView) findViewById(R.id.ivGramaticaKiche);
        swGramaticaKiche = (Switch) findViewById(R.id.swGramaticaKiche);
        tvRespuesta =(TextView) findViewById(R.id.tvGramaticaKicheRespuestaSwitch);
        nuPregunta = (TextView) findViewById(R.id.tvGramaticaKicheNumero);
        tvGramaticaKiche = (TextView) findViewById(R.id.tvGramaticaKicheTitulo);
        String guarda_numero = "";
        guarda_numero += pregunta +1;
        nuPregunta.setText(guarda_numero);
        int i = string_muestra[pregunta],
                imgs = img[pregunta];//respuesta correcta

        tvRespuesta.setText("");
        ivGramaticaKiche.setImageResource(imgs);
        swGramaticaKiche.setOnCheckedChangeListener(this);
        rbSiGramaticaKiche.setOnClickListener(this);
        rbNoGramaticaKiche.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if ((pregunta +1) == img.length){
            setNextContext(this, ExpresionOralKiche.class);
        } else {
        pregunta ++;
        setOnInit(null);
        swGramaticaKiche.setChecked(false);
        rbSiGramaticaKiche.setChecked(false);
        rbNoGramaticaKiche.setChecked(false);
        if(rbSiGramaticaKiche.isChecked()){
            resultado += 1;
        }else
            resultado += 0;

    }}


    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        if(swGramaticaKiche.isChecked()){
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
        Bundle b = new Bundle();
        b.putInt(IniciarEvaluacion.KEY_EVALUACION, serie);
        Intent i = new Intent(context, next_context);
        i.putExtras(b);
        startActivity(i);
    }

}

