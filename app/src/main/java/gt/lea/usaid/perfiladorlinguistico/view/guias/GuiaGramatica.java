package gt.lea.usaid.perfiladorlinguistico.view.guias;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterViewFlipper;
import android.widget.TabHost;
import android.widget.Toast;

import gt.lea.usaid.perfiladorlinguistico.NavigationMenu;
import gt.lea.usaid.perfiladorlinguistico.R;

/**
 * Created by Roberto on 16/08/2016.
 */
public class GuiaGramatica extends Activity {
    TabHost tabHost;
    Toolbar toolbar;
    private AdapterViewFlipper vfGuiaNavegacionEsp, vfGuiaNavegacionKiche, vfGuiaNavegacionMam;
    int[] ivGuiaNavegacionEsp = {R.mipmap.logolea, R.mipmap.pelotabasketball, R.mipmap.logolea, R.mipmap.logolea, R.mipmap.lapiz, R.mipmap.logolea, R.mipmap.abuelita, R.mipmap.maestro, R.mipmap.doctor, R.mipmap.cocinero};
    String tvGuiaNavegacionEsp[] = {"inst", "pelota", "pelotas", "lápices", "lápiz", "inst 2", "Esta es una abuela, si fuera hombre  ¿cómo se diría?\nRespuesta: abuelo", "Este es un maestro, si fuera mujer ¿cómo se diría?\nRespusta: maestra", "Este es un doctor, (señale al doctor) si fuera mujer ¿cómo se diría?\nRespuesta: doctora", "Este es un cocinero, si fuera mujer ¿cómo se diría?\nRespuesta: cocinera / chef"};
    int[] ivGuiaNavegacionKiche = {R.mipmap.logolea, R.mipmap.sandalia, R.mipmap.logolea, R.mipmap.gato, R.mipmap.gatos, R.mipmap.logolea, R.mipmap.perro, R.mipmap.logolea, R.mipmap.carnero, R.mipmap.padre};
    String tvGuiaNavegacionKiche[] = {"inst", "xajab'", "taq xajab", "me's", "taq me's", "inst 2", "Are jun ala, ¿Su ub'ixik we k'o ruq?\nRespuesta: ali" , "Are jun chichu', ¿Su ub'ixik we k'o rismachi?\nRespuesta: tat / achi", "Are jun ti't, ¿Su ub'ixik we k'o upwi?\nRespuesta: mam / tat", "pendiente"};
    int[] ivGuiaNavegacionMam = {R.mipmap.pato, R.mipmap.elote, R.mipmap.logolea, R.mipmap.gato, R.mipmap.gatos, R.mipmap.logolea, R.mipmap.perro, R.mipmap.logolea, R.mipmap.carnero, R.mipmap.padre};
    //String tvGuiaNavegacionMam[] = {"pato", "gato", "vaca", "arbol", "elote", "banano", "camioneta", "carro", "pantalon", "vestido"};
    String tvGuiaNavegacionMam[] = {"inst 1", "i'x", "qe'ox / kyaj i'x", "wix", "qe'wix / ox wix / oxe wix", "inst 2", "ti tb'i lu\ntx'ya'n.\nQa at tal, ti tbi'\nRespuesta: ttxu tx'ya'n ", "ti tb'i lu\nek' / ik\nqa npaqin, ti tb'i\nRespuesta: ttxu ek' / ttxu ik'", "ti tb'i lu\nrit / kne'l.\nQa at tal, ti tb'i\nRespuesta: ttxu rit / kne'l", "Ti tb'i lu\nmanb'aj.\nQa xu'j / qya, ti tb'i\nRespuesta: txub'aj"};
    private float lastX;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.guia_adapter_flipper);
        flipper_esp();
        flipper_kiche();
        flipper_mam();
        initToolBar();
        initTabHost();
    }

    public void flipper_esp(){
        vfGuiaNavegacionEsp = (AdapterViewFlipper) findViewById(R.id.vfGuiaNavegacionEsp);
        CustomAdapter customAdapter = new CustomAdapter(getApplicationContext(), tvGuiaNavegacionEsp, ivGuiaNavegacionEsp);
        vfGuiaNavegacionEsp.setAdapter(customAdapter);
    }
    public void flipper_kiche(){
        vfGuiaNavegacionKiche = (AdapterViewFlipper) findViewById(R.id.vfGuiaNavegacionKiche);
        CustomAdapter customAdapter = new CustomAdapter(getApplicationContext(), tvGuiaNavegacionKiche, ivGuiaNavegacionKiche);
        vfGuiaNavegacionKiche.setAdapter(customAdapter);
    }
    public void flipper_mam(){
        vfGuiaNavegacionMam = (AdapterViewFlipper) findViewById(R.id.vfGuiaNavegacionMam);
        CustomAdapter customAdapter = new CustomAdapter(getApplicationContext(), tvGuiaNavegacionMam, ivGuiaNavegacionMam);
        vfGuiaNavegacionMam.setAdapter(customAdapter);
    }
    private void initToolBar() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Guia Gramática");
        //setSupportActionBar(toolbar);

        toolbar.setNavigationIcon(R.drawable.btn_back);
        toolbar.setNavigationOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(GuiaGramatica.this, "Regresando al Menu!", Toast.LENGTH_SHORT).show();
                        Intent navigation_menu = new Intent(getApplication(),NavigationMenu.class );
                        startActivity(navigation_menu);
                    }
                }
        );
    }
    private void initTabHost() {
        TabHost host = (TabHost)findViewById(R.id.tabHost);
        host.setup();

        //Tab 1
        TabHost.TabSpec spec = host.newTabSpec("Tab One");
        spec.setContent(R.id.tab1);
        spec.setIndicator("Español");
        host.addTab(spec);

        //Tab 2
        spec = host.newTabSpec("Tab Two");
        spec.setContent(R.id.tab2);
        spec.setIndicator("Mam");
        host.addTab(spec);

        //Tab 3
        spec = host.newTabSpec("Tab Three");
        spec.setContent(R.id.tab3);
        spec.setIndicator("Kiche");
        host.addTab(spec);
    }
    public boolean onTouchEvent(MotionEvent touchevent) {
        switch (touchevent.getAction()) {

            case MotionEvent.ACTION_DOWN:
                lastX = touchevent.getX();
                break;
            case MotionEvent.ACTION_UP:
                float currentX = touchevent.getX();

                if (lastX < currentX) {
                    vfGuiaNavegacionEsp.showPrevious();
                    vfGuiaNavegacionKiche.showPrevious();
                    vfGuiaNavegacionMam.showPrevious();
                }

                if (lastX > currentX) {

                    vfGuiaNavegacionEsp.showNext();
                    vfGuiaNavegacionKiche.showNext();
                    vfGuiaNavegacionMam.showNext();
                }
                break;
        }
        return false;
    }

}