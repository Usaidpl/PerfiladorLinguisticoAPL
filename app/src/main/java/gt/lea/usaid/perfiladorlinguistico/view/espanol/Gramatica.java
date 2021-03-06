package gt.lea.usaid.perfiladorlinguistico.view.espanol;

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
import gt.lea.usaid.perfiladorlinguistico.utils.Lanzador;
import gt.lea.usaid.perfiladorlinguistico.utils.interfaces.OnInitializeComponent;

public class Gramatica extends Activity implements OnInitializeComponent, View.OnClickListener, CompoundButton.OnCheckedChangeListener {
    private int pregunta = 0;
    //private int strings[] = {R.string.titulo_Gramatica_mam, R.string.inst_eva_expresion_oral},

    private int img[] = {R.mipmap.pelotabasketball, R.mipmap.logolea, R.mipmap.logolea, R.mipmap.lapiz, R.mipmap.abuelo, R.mipmap.maestro, R.mipmap.doctor, R.mipmap.cocinero};
    private int string_muestra[] = {R.string.vi_pelota, R.string.vi_pelotas, R.string.vi_lapices, R.string.vi_lapiz, R.string.vi_abuelo, R.string.vi_maestra, R.string.vi_doctora, R.string.vi_cocinera};
    private TextView tvGramatica, tvRespuesta, nuPregunta;
    private ImageView ivGramatica;
    private RadioButton rbSiGramatica, rbNoGramatica;
    private Switch swGramatica;
    private String resultado = "";
    //private int pregunta = 0;
    private int serie = 0;
    private String resultado_sonidos = "";
    private RadioGroup rgGramatica;
    private String recupera_sonidos ="";
    private Lanzador l;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gramatica);
        l = new Lanzador(this, ExpresionOral.class);
        recupera_sonidos = l.getBundleStringDouble();
        setOnInit(null);
    }

    @Override
    public void setOnInit(@IdRes int[][] matriz) {
        rbSiGramatica = (RadioButton) findViewById(R.id.rbGramaticaSi);
        rbNoGramatica = (RadioButton) findViewById(R.id.rbGramaticaNo);
        ivGramatica = (ImageView) findViewById(R.id.ivGramatica);
        swGramatica = (Switch) findViewById(R.id.swGramatica);
        tvRespuesta = (TextView) findViewById(R.id.tvGramaticaRespuestaSwitch);
        nuPregunta = (TextView) findViewById(R.id.tvGramaticaNumero);
        tvGramatica = (TextView) findViewById(R.id.tvGramaticaTitulo);
        rgGramatica = (RadioGroup) findViewById(R.id.rgGramatica);

        String guarda_numero = "";
        guarda_numero += pregunta + 1;
        nuPregunta.setText(guarda_numero);
        int i = string_muestra[pregunta],
                imgs = img[pregunta];//respuesta correcta

        tvRespuesta.setText("");
        ivGramatica.setImageResource(imgs);
        swGramatica.setOnCheckedChangeListener(this);
        rbSiGramatica.setOnClickListener(this);
        rbNoGramatica.setOnClickListener(this);
        rgGramatica.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        na();
        if ((pregunta + 1) == img.length) {
            recupera_sonidos += resultado;
            l.agregarValores(recupera_sonidos, 100.0);


        } else {
            pregunta++;
            setOnInit(null);
            //rbSiGramatica.setChecked(false);
            //rbNoGramatica.setChecked(false);
        }
        Toast.makeText(this, resultado, Toast.LENGTH_SHORT).show();
    }
public void na(){
    if (rbSiGramatica.isChecked()) {

        swGramatica.setChecked(false);
        rgGramatica.clearCheck();
        resultado += 1;
    } else
        //rbSiGramatica.setChecked(false);
        //rbNoGramatica.setChecked(false);
        resultado += 0;
}
    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        if (swGramatica.isChecked()) {
            int i = string_muestra[pregunta];
            tvRespuesta.setText(i);
        } else
            tvRespuesta.setText("");
        Toast.makeText(this, resultado, Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onPause() {
        super.onPause();
        finish();
    }


}

