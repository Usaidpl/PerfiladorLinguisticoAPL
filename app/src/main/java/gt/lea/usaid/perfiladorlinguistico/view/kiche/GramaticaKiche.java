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
import gt.lea.usaid.perfiladorlinguistico.utils.Lanzador;
import gt.lea.usaid.perfiladorlinguistico.utils.interfaces.OnInitializeComponent;

public class GramaticaKiche extends Activity implements OnInitializeComponent, View.OnClickListener, CompoundButton.OnCheckedChangeListener {
    private int pregunta = 0;
    //private int strings[] = {R.string.titulo_GramaticaKiche_mam, R.string.inst_eva_expresion_oral},

    private int img[] = {R.mipmap.sandalia, R.mipmap.logolea, R.mipmap.logolea, R.mipmap.logolea, R.mipmap.senior, R.mipmap.seniora, R.mipmap.abuelo, R.mipmap.logolea};
    private int string_muestra[] = {R.string.vi_xajab, R.string.vi_taqxajab, R.string.vi_mes, R.string.vi_taqmes, R.string.vi_ali, R.string.vi_tat, R.string.vi_mam, R.string.vi_pendiente};
    private TextView tvGramaticaKiche, tvRespuesta, nuPregunta;
    private ImageView ivGramaticaKiche;
    private RadioButton rbSiGramaticaKiche, rbNoGramaticaKiche;
    private Switch swGramaticaKiche;
    private String resultado = "";
    // private int pregunta = 0;
    private int serie = 0;
    private String resultado_sonidos_kiche = "";
    private RadioGroup rgGramaticaKiche;
    private String recupera_sonidos_kiche ="";
    private Lanzador l;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gramatica_kiche);
        l = new Lanzador(this, ExpresionOralKiche.class);
        recupera_sonidos_kiche = l.getBundleStringDouble();
        setOnInit(null);
    }

    @Override
    public void setOnInit(@IdRes int[][] matriz) {
        rbSiGramaticaKiche = (RadioButton) findViewById(R.id.rbGramaticaKicheSi);
        rbNoGramaticaKiche = (RadioButton) findViewById(R.id.rbGramaticaKicheNo);
        ivGramaticaKiche = (ImageView) findViewById(R.id.ivGramaticaKiche);
        swGramaticaKiche = (Switch) findViewById(R.id.swGramaticaKiche);
        tvRespuesta = (TextView) findViewById(R.id.tvGramaticaKicheRespuestaSwitch);
        nuPregunta = (TextView) findViewById(R.id.tvGramaticaKicheNumero);
        tvGramaticaKiche = (TextView) findViewById(R.id.tvGramaticaKicheTitulo);
        rgGramaticaKiche = (RadioGroup) findViewById(R.id.rgGramaticaKiche);
        String guarda_numero = "";
        guarda_numero += pregunta + 1;
        nuPregunta.setText(guarda_numero);
        int i = string_muestra[pregunta],
                imgs = img[pregunta];//respuesta correcta

        tvRespuesta.setText("");
        ivGramaticaKiche.setImageResource(imgs);
        swGramaticaKiche.setOnCheckedChangeListener(this);
        rbSiGramaticaKiche.setOnClickListener(this);
        rbNoGramaticaKiche.setOnClickListener(this);
        rgGramaticaKiche.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        na();
        if ((pregunta + 1) == img.length) {
            recupera_sonidos_kiche += resultado;
            l.agregarValores(recupera_sonidos_kiche, 100.0);
        } else {
            pregunta++;
            setOnInit(null);
        }
        Toast.makeText(this, resultado, Toast.LENGTH_SHORT).show();
    }
    public void na() {
        if (rbSiGramaticaKiche.isChecked()) {
            swGramaticaKiche.setChecked(false);
            rgGramaticaKiche.clearCheck();
            resultado += 1;
        } else
            resultado += 0;
            rbSiGramaticaKiche.setChecked(false);
            rbNoGramaticaKiche.setChecked(false);
    }


    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        if (swGramaticaKiche.isChecked()) {
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

