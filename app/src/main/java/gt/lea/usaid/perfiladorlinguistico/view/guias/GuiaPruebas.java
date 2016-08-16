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
 * Created by Roberto on 11/08/16.
 */
//public class GuiaPruebas extends Activity /*implements OnInitializeComponent*/ {
public class GuiaPruebas extends Activity  {
    TabHost tabHost;
    Toolbar toolbar;
    private AdapterViewFlipper vfGuiaNavegacion;
    int[] ivGuiaNavegacion = {R.mipmap.logolea, R.mipmap.gallina, R.mipmap.fuego, R.mipmap.aguacate, R.mipmap.anciana};
    String tvGuiaNavegacion[] = {"Logo Lea", "Gallina", "Fuego", "Aguacate", "Anciana"};
    private float lastX;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.guia_pruebas);
        flip();
        initToolBar();
        initTabHost();
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

    private void initToolBar() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle(R.string.guia_comprension_oral);
        //setSupportActionBar(toolbar);

        toolbar.setNavigationIcon(R.drawable.btn_back);
        toolbar.setNavigationOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(GuiaPruebas.this, "Regresando al Menu!", Toast.LENGTH_SHORT).show();
                        Intent navigation_menu = new Intent(getApplication(),NavigationMenu.class );
                        startActivity(navigation_menu);
                    }
                }
        );
    }

    public void flip(){
        vfGuiaNavegacion = (AdapterViewFlipper) findViewById(R.id.vfGuiaNavegacion);
        CustomAdapter customAdapter = new CustomAdapter(getApplicationContext(), tvGuiaNavegacion, ivGuiaNavegacion);
        vfGuiaNavegacion.setAdapter(customAdapter);
    }

    public boolean onTouchEvent(MotionEvent touchevent) {
        switch (touchevent.getAction()) {

            case MotionEvent.ACTION_DOWN:
                lastX = touchevent.getX();
                break;
            case MotionEvent.ACTION_UP:
                float currentX = touchevent.getX();

                if (lastX < currentX) {
                    vfGuiaNavegacion.showPrevious();
                }

                if (lastX > currentX) {

                    vfGuiaNavegacion.showNext();
                }
                break;
        }
        return false;
    }

}