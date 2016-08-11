package gt.lea.usaid.perfiladorlinguistico.view.guias;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TabHost;
import android.widget.Toast;
import android.widget.ViewFlipper;

import gt.lea.usaid.perfiladorlinguistico.NavigationMenu;
import gt.lea.usaid.perfiladorlinguistico.R;
import gt.lea.usaid.perfiladorlinguistico.controller.control_vista.TouchFlipper;

/**
 * Created by Roberto on 23/06/2016.
 */
public class GuiaComprensionOral extends TouchFlipper {
    private ViewFlipper vfGuiaEsp, vfGuiaMam, vfGuiaKiche;
    private float lastX;

    TabHost tabHost;
    Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.guia_comprension_oral);
        vfGuiaEsp = (ViewFlipper) findViewById(R.id.vfGuiaComprensionOral);
        vfGuiaMam = (ViewFlipper) findViewById(R.id.vfGuiaComprensionOralMam);
        vfGuiaKiche = (ViewFlipper) findViewById(R.id.vfGuiaComprensionOralKiche);

        initToolBar();
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
                        Toast.makeText(GuiaComprensionOral.this, "Regresando al Menu!", Toast.LENGTH_SHORT).show();
                        Intent navigation_menu = new Intent(getApplication(),NavigationMenu.class );
                        startActivity(navigation_menu);
                    }
                }
        );
    }

    @Override
    protected void onPause() {
        super.onPause();
        finish();
    }
}


