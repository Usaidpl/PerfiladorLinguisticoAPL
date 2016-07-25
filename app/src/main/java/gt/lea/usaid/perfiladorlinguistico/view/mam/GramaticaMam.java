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

public class GramaticaMam extends Activity implements OnInitializeComponent, View.OnClickListener, CompoundButton.OnCheckedChangeListener {
    private int pregunta_toca = 0;
    //private int strings[] = {R.string.titulo_GramaticaMam_mam, R.string.inst_eva_expresion_oral},

    private int img[] = {R.mipmap.pelotabasketball, R.mipmap.logolea, R.mipmap.logolea, R.mipmap.lapiz, R.mipmap.abuelo, R.mipmap.maestro, R.mipmap.doctor, R.mipmap.cocinero};
    private int string_muestra[] = {R.string.vi_pelota, R.string.vi_pelotas, R.string.vi_lapices, R.string.vi_lapiz, R.string.vi_abuelo, R.string.vi_maestra, R.string.vi_doctora, R.string.vi_cocinera};
    private TextView tvGramaticaMam, tvRespuesta, nuPregunta;
    private ImageView ivGramaticaMam;
    private RadioButton rbSiGramaticaMam, rbNoGramaticaMam;
    private Switch swGramaticaMam;
    private String resultado ="";
    private int pregunta = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gramatica_mam);
        setOnInit(null);
    }

    @Override
    public void setOnInit(@IdRes int[][] matriz) {
        rbSiGramaticaMam = (RadioButton) findViewById(R.id.rbGramaticaMamSi);
        rbNoGramaticaMam = (RadioButton) findViewById(R.id.rbGramaticaMamNo);
        ivGramaticaMam = (ImageView) findViewById(R.id.ivGramaticaMam);
        swGramaticaMam = (Switch) findViewById(R.id.swGramaticaMam);
        tvRespuesta =(TextView) findViewById(R.id.tvGramaticaMamRespuestaSwitch);
        nuPregunta = (TextView) findViewById(R.id.tvGramaticaMamNumero);
        tvGramaticaMam = (TextView) findViewById(R.id.tvGramaticaMamTitulo);
        String guarda_numero = "";
        guarda_numero += pregunta;
        nuPregunta.setText(guarda_numero);
        int i = string_muestra[pregunta_toca],
                imgs = img[pregunta_toca];//respuesta correcta

        tvRespuesta.setText("");
        ivGramaticaMam.setImageResource(imgs);
        swGramaticaMam.setOnCheckedChangeListener(this);
        rbSiGramaticaMam.setOnClickListener(this);
        rbNoGramaticaMam.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        pregunta_toca ++;
        pregunta ++;
        setOnInit(null);
        swGramaticaMam.setChecked(false);
        rbSiGramaticaMam.setChecked(false);
        rbNoGramaticaMam.setChecked(false);

        if(rbSiGramaticaMam.isChecked()){
            resultado += 1;
        }else
            resultado += 0;
        Toast.makeText(this, resultado, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        if(swGramaticaMam.isChecked()){
            int i = string_muestra[pregunta_toca];
            tvRespuesta.setText(i);
        }else
            tvRespuesta.setText("");
    }
}

