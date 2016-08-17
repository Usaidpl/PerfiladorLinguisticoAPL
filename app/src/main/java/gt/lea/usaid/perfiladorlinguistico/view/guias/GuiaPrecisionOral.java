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

public class GuiaPrecisionOral extends Activity {
    TabHost tabHost;
    Toolbar toolbar;
    private AdapterViewFlipper vfGuiaNavegacionEsp, vfGuiaNavegacionKiche, vfGuiaNavegacionMam;
    int[] ivGuiaNavegacionEsp = {R.mipmap.pato, R.mipmap.gato, R.mipmap.vaca, R.mipmap.arbol, R.mipmap.elote, R.mipmap.banano, R.mipmap.camioneta, R.mipmap.carro, R.mipmap.pantalon, R.mipmap.vestido, R.mipmap.zapato, R.mipmap.sombrero, R.mipmap.mesa, R.mipmap.escalera, R.mipmap.canasto, R.mipmap.peine, R.mipmap.libro};
    String tvGuiaNavegacionEsp[] = {"pato", "gato", "vaca", "arbol", "elote", "banano", "camioneta", "carro", "pantalon", "vestido", "zapato", "sombrero", "mesa", "escalera","canasto", "peine", "libro"};
    int[] ivGuiaNavegacionKiche = {R.mipmap.pato, R.mipmap.gato, R.mipmap.vaca, R.mipmap.arbol, R.mipmap.elote, R.mipmap.banano, R.mipmap.camioneta, R.mipmap.carro, R.mipmap.pantalon, R.mipmap.vestido, R.mipmap.zapato, R.mipmap.sombrero, R.mipmap.mesa, R.mipmap.escalera, R.mipmap.canasto, R.mipmap.peine, R.mipmap.libro};
    String tvGuiaNavegacionKiche[] = {"tat", "nan", "ali", "ti't", "mam", "aq", "imul", "chij", "pix", "aj", "oj", "wuj", "tijob'al", "tem","pas", "uq", "xot"};
    int[] ivGuiaNavegacionMam = {R.mipmap.pato, R.mipmap.gato, R.mipmap.vaca, R.mipmap.arbol, R.mipmap.elote, R.mipmap.banano, R.mipmap.camioneta, R.mipmap.carro, R.mipmap.pantalon, R.mipmap.vestido, R.mipmap.zapato, R.mipmap.sombrero, R.mipmap.mesa, R.mipmap.escalera, R.mipmap.canasto, R.mipmap.peine, R.mipmap.libro};
    String tvGuiaNavegacionMam[] = {"tat", "txin", "nan ya' / chmam", "tx'yan", "chmek' / choj", "ek' / ik'", "wix", "chej", "tze'", "ich", "kjo'n", "i'x", "b'ech", "wexj","xjab'", "xk'o'n", "k'il / k'wil / ok'il"};
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
        toolbar.setTitle("Guia Navegacion Aplicación");
        //setSupportActionBar(toolbar);

        toolbar.setNavigationIcon(R.drawable.btn_back);
        toolbar.setNavigationOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(GuiaPrecisionOral.this, "Regresando al Menu!", Toast.LENGTH_SHORT).show();
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