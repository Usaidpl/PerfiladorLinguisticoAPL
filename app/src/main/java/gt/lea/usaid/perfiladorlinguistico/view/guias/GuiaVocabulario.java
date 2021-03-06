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
public class GuiaVocabulario extends Activity {
    TabHost tabHost;
    Toolbar toolbar;
    private AdapterViewFlipper vfGuiaNavegacionEsp, vfGuiaNavegacionKiche, vfGuiaNavegacionMam;
    int[] ivGuiaNavegacionEsp = {R.mipmap.logolea, R.mipmap.casa, R.mipmap.cama, R.mipmap.avion, R.mipmap.silla, R.mipmap.conejo, R.mipmap.caballlo, R.mipmap.zanahoria, R.mipmap.guisquil, R.mipmap.logolea, R.mipmap.manzana};
    String tvGuiaNavegacionEsp[] = {"inst", "casa", "cama", "avión", "silla", "conejo", "caballo", "zanahoria", "güisquil", "gallo", "manzana"};
    int[] ivGuiaNavegacionKiche = {R.mipmap.logolea, R.mipmap.pescado2, R.mipmap.casa, R.mipmap.tortillas, R.mipmap.culebra, R.mipmap.caballlo, R.mipmap.mono, R.mipmap.perro, R.mipmap.guisquil, R.mipmap.ayote, R.mipmap.hongo};
    String tvGuiaNavegacionKiche[] = {"inst", "kar'", "ja", "lej", "kumatz", "kej", "k'oy", "tz'i'", "k'ix", "mukun / k'um", "q'atzu / q'anxul"};
    int[] ivGuiaNavegacionMam = {R.mipmap.logolea, R.mipmap.casa, R.mipmap.caballlo, R.mipmap.conejo, R.mipmap.caballlo, R.mipmap.huevo, R.mipmap.pollito, R.mipmap.pescado2, R.mipmap.volcan, R.mipmap.camino, R.mipmap.nube};
    String tvGuiaNavegacionMam[] = {"inst 1", "ja'", "watb'il / kuxli'l","xik / kiky","chej", "jos / tpaq ik' / tjos ek'", "b'i'x / b'ich / tal ek'", "kyix", "witz", "b'e", "muj"};
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
        toolbar.setTitle("Guia Vocabulario");
        //setSupportActionBar(toolbar);

        toolbar.setNavigationIcon(R.drawable.btn_back);
        toolbar.setNavigationOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(GuiaVocabulario.this, "Regresando al Menu!", Toast.LENGTH_SHORT).show();
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