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

public class Vocabulario extends Activity implements OnInitializeComponent, View.OnClickListener, CompoundButton.OnCheckedChangeListener {
    //private int pregunta_toca = 0;
    //private int strings[] = {R.string.titulo_vocabulario_mam, R.string.inst_eva_expresion_oral},
    private static final int img[] = {R.mipmap.casa, R.mipmap.cama, R.mipmap.avion, R.mipmap.silla, R.mipmap.conejo, R.mipmap.caballlo, R.mipmap.zanahoria, R.mipmap.guisquil, R.mipmap.pollito, R.mipmap.manzana};
    private int string_muestra[] = {R.string.iv_casa, R.string.iv_cama, R.string.iv_avion, R.string.iv_silla, R.string.iv_conejo, R.string.iv_caballo, R.string.iv_zanahoria, R.string.iv_guisquil, R.string.iv_gallo, R.string.iv_manzana};//iv_arbol

    private TextView tvVocabulario, tvRespuesta, nuPregunta;
    private ImageView ivVocabulario;
    //private RadioGroup rgVocabulario, rgVocabulario2;
    private RadioButton rbSiVocabulario, rbNoVocabulario;
    private RadioGroup rgVocabulario;
    private Switch swVocabulario;
    private String resultado = "";
    private int pregunta = 0;
    private int serie = 0;
    private String recupera_comprension = "";
    private Lanzador l;
    /*
    private String resultado_precisiona ="";
    //private String valores_vocabulario;
*/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vocabulario);
        l = new Lanzador(this, SonidosEspecificos.class);
        recupera_comprension = l.getBundleStringDouble();
        /*
        Bundle b = getIntent().getExtras();
        resultado_precisiona = b.getString("evaluacion");
        setOnInit(null);
        */
        setOnInit(null);
    }
/*
    public void agregar(RadioButton rb, Switch sw){
        rbSiVocabulario = rb;
        swVocabulario = sw;
        //sw = swVocabulario;

    }

    public RadioButton getrb(int id){
        rbNoVocabulario = (RadioButton) findViewById(id);
        return rbNoVocabulario;
    }
  */

    @Override
    public void setOnInit(@IdRes int[][] matriz) {
        rbSiVocabulario = (RadioButton) findViewById(R.id.rbVocabularioSi);
        rbNoVocabulario = (RadioButton) findViewById(R.id.rbVocabularioNo);
        ivVocabulario = (ImageView) findViewById(R.id.ivVocabulario);
        swVocabulario = (Switch) findViewById(R.id.swVocabulario);
        tvRespuesta = (TextView) findViewById(R.id.tvVocabularioRespuestaSwitch);
        nuPregunta = (TextView) findViewById(R.id.tvVocabularioNumero);
        tvVocabulario = (TextView) findViewById(R.id.tvVocabularioTitulo);
        rgVocabulario = (RadioGroup) findViewById(R.id.rgVocabulario);

        String guarda_numero = "";
        guarda_numero += pregunta+1;
        nuPregunta.setText(guarda_numero);
        int i = string_muestra[pregunta],
                imgs = img[pregunta];//respuesta correcta

        tvRespuesta.setText("");
        ivVocabulario.setImageResource(imgs);
        swVocabulario.setOnCheckedChangeListener(this);
        rbNoVocabulario.setOnClickListener(this);
        rbSiVocabulario.setOnClickListener(this);
        rgVocabulario.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        na();
        if ((pregunta +1) == img.length){
            /*
            Bundle b = new Bundle();
            b.putString("evaluacion", resultado);
            Intent i = new Intent(this, SonidosEspecificos.class);
            i.putExtras(b);
            Toast.makeText(this, resultado, Toast.LENGTH_SHORT).show();
            startActivity(i);*/
            //setNextContext(this, SonidosEspecificos.class);
            //swVocabulario.setChecked(false);
            //rbSiVocabulario.setChecked(false);
            //rbNoVocabulario.setChecked(false);

            recupera_comprension += resultado;
            l.agregarValores(recupera_comprension, 50.0);
            /*
            recupera_comprension = l.getBundleStringDouble();
            String[] linea = recupera_comprension.split(" | ");
            for(int l = 0; l <linea.length; l++){
                String r = linea[l];
                Toast.makeText(this, r, Toast.LENGTH_SHORT).show();
            }
            */
            //Toast.makeText(this, recupera_comprension, Toast.LENGTH_LONG).show();

        } else {
            pregunta ++;
            setOnInit(null);
            Toast.makeText(this, resultado, Toast.LENGTH_SHORT).show();
            //1010010101
        }

    }
    private void na(){
        if(rbSiVocabulario.isChecked()){
            swVocabulario.setChecked(false);
            rgVocabulario.clearCheck();
            resultado += 1;
        }else{
            rbSiVocabulario.setChecked(false);
            rbNoVocabulario.setChecked(false);
            resultado += 0;
        }
    }



    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        if (swVocabulario.isChecked()) {
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
    /*
    public void setNextContext(Context context, Class<?> next_context) {
        Intent i = new Intent(context, next_context);
        startActivity(i);
    }
    */
}

