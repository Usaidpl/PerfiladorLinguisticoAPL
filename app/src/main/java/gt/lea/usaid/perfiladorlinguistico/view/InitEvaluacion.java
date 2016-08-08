package gt.lea.usaid.perfiladorlinguistico.view;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.view.View;
import android.widget.ImageView;

import gt.lea.usaid.perfiladorlinguistico.R;
import gt.lea.usaid.perfiladorlinguistico.controller.evaluacion.Interaccion;
import gt.lea.usaid.perfiladorlinguistico.utils.Lanzador;
import gt.lea.usaid.perfiladorlinguistico.utils.interfaces.OnInitializeComponent;

/**
 * Created by Bryan on 07/08/2016.
 */
public class InitEvaluacion extends Activity implements OnInitializeComponent{

    public static String KEY_EVALUACION = "Evalua";
    private ImageView ivEspanolEva, ivMamEva, ivKicheEva;
    private Lanzador l = new Lanzador(this, Interaccion.class);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.iniciar_evaluacion);
        setOnInit(null);
    }

    @Override
    public void setOnInit(@IdRes int[][] matriz) {
        ivMamEva =(ImageView) findViewById(R.id.ivMamEva);
        ivKicheEva =(ImageView) findViewById(R.id.ivKicheEva);
        ivMamEva.setOnClickListener(click);
        ivKicheEva.setOnClickListener(click);
    }

    private View.OnClickListener click = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            int evalua = -9;
            switch (v.getId()) {
                case R.id.ivMamEva:
                    evalua = 0;
                    break;
                case R.id.ivKicheEva:
                    evalua = 1;
                    break;
            }
            l.addLanguage(evalua);
        }
    };
}
