package gt.lea.usaid.perfiladorlinguistico.view.mam;

import android.app.Activity;
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
import gt.lea.usaid.perfiladorlinguistico.utils.interfaces.OnInitializeComponent;

public class GramaticaMam extends Activity implements OnInitializeComponent, View.OnClickListener, CompoundButton.OnCheckedChangeListener {
    private int pregunta = 0;
    //private int strings[] = {R.string.titulo_GramaticaMam_mam, R.string.inst_eva_expresion_oral},

    private int img[] = {R.mipmap.elote, R.mipmap.logolea, R.mipmap.gato, R.mipmap.gatos, R.mipmap.perro, R.mipmap.logolea, R.mipmap.carnero, R.mipmap.padre};
    private int string_muestra[] = {R.string.vi_ix, R.string.vi_qeox, R.string.vi_wix, R.string.vi_qewix, R.string.vi_ttxutxyan, R.string.vi_ttxuek, R.string.vi_ttxurit, R.string.vi_txubaj};
    private TextView tvGramaticaMam, tvRespuesta, nuPregunta;
    private ImageView ivGramaticaMam;
    private RadioButton rbSiGramaticaMam, rbNoGramaticaMam;
    private Switch swGramaticaMam;
    private String resultado ="";
    private String resultado_sonidos_mam = "";
    private RadioGroup rgGramaticaMam;

   // private int pregunta = 0;
    private int serie = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gramatica_mam);
        Bundle b = getIntent().getExtras();
        resultado_sonidos_mam = b.getString("evaluacion");
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
        rgGramaticaMam = (RadioGroup) findViewById(R.id.rgGramaticaMam);
        String guarda_numero = "";
        guarda_numero += pregunta+1;
        nuPregunta.setText(guarda_numero);
        int i = string_muestra[pregunta],
                imgs = img[pregunta];//respuesta correcta

        tvRespuesta.setText("");
        ivGramaticaMam.setImageResource(imgs);
        swGramaticaMam.setOnCheckedChangeListener(this);
        rbSiGramaticaMam.setOnClickListener(this);
        rbNoGramaticaMam.setOnClickListener(this);
        rgGramaticaMam.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        na();
        if ((pregunta +1) == img.length){
            resultado_sonidos_mam +=
                    "&&" + resultado;
            Toast mensaje_toast =
                    Toast.makeText(getApplicationContext(),
                            resultado_sonidos_mam, Toast.LENGTH_SHORT);
            mensaje_toast.show();
            Bundle b = new Bundle();
            b.putString("evaluacion", resultado_sonidos_mam);
            Intent i = new Intent(this, ExpresionOralMam.class);
            i.putExtras(b);
            startActivity(i);
        } else {
            pregunta ++;
            setOnInit(null);
        }
        Toast.makeText(this, resultado, Toast.LENGTH_SHORT).show();
    }
public void na(){
    if(rbSiGramaticaMam.isChecked()){
        swGramaticaMam.setChecked(false);
        rgGramaticaMam.clearCheck();
        resultado += 1;
    }else
        resultado += 0;
        rbSiGramaticaMam.setChecked(false);
        rbNoGramaticaMam.setChecked(false);
}
    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        if(swGramaticaMam.isChecked()){
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
}

