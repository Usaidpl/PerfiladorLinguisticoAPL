package gt.lea.usaid.perfiladorlinguistico.view.guias;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TabHost;
import android.widget.Toast;
import android.widget.ViewFlipper;

import gt.lea.usaid.perfiladorlinguistico.NavigationMenu;
import gt.lea.usaid.perfiladorlinguistico.R;

/**
 * Created by Roberto on 23/06/2016.
 */
public class GuiaExpresionOral extends Activity {
    private ViewFlipper vfGuiaEsp, vfGuiaMam, vfGuiaKiche;
    private float lastX;
    Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.guia_expresion_oral);
        vfGuiaEsp = (ViewFlipper) findViewById(R.id.vfGuiaExpresionOral);
        vfGuiaMam = (ViewFlipper) findViewById(R.id.vfGuiaExpresionOralMam);
        vfGuiaKiche = (ViewFlipper) findViewById(R.id.vfGuiaExpresionOralKiche);

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
        toolbar.setTitle(R.string.guia_expresion_oral);
        //setSupportActionBar(toolbar);

        toolbar.setNavigationIcon(R.drawable.ic_arrow_back_black);
        toolbar.setTitleTextColor(getResources().getColor(R.color.myColorBasic));
        toolbar.setNavigationOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(GuiaExpresionOral.this, "Regresando al Menu!", Toast.LENGTH_SHORT).show();
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

    public boolean onTouchEvent(MotionEvent touchevent) {
        switch (touchevent.getAction()) {

            case MotionEvent.ACTION_DOWN:
                lastX = touchevent.getX();
                break;
            case MotionEvent.ACTION_UP:
                float currentX = touchevent.getX();

                if (lastX < currentX) {

                    if (vfGuiaEsp.getDisplayedChild() == 0)
                        break;
                    if (vfGuiaMam.getDisplayedChild() == 0)
                        break;
                    if (vfGuiaKiche.getDisplayedChild() == 0)
                        break;

                    vfGuiaEsp.setInAnimation(this, R.anim.slide_in_from_left);
                    vfGuiaMam.setInAnimation(this, R.anim.slide_in_from_left);
                    vfGuiaKiche.setInAnimation(this, R.anim.slide_in_from_left);

                    vfGuiaEsp.setOutAnimation(this, R.anim.slide_out_to_right);
                    vfGuiaMam.setOutAnimation(this, R.anim.slide_out_to_right);
                    vfGuiaKiche.setOutAnimation(this, R.anim.slide_out_to_right);

                    vfGuiaEsp.showNext();
                    vfGuiaMam.showNext();
                    vfGuiaKiche.showNext();
                }

                if (lastX > currentX) {

                    if (vfGuiaEsp.getDisplayedChild() == 1)
                        break;
                    if (vfGuiaMam.getDisplayedChild() == 1)
                        break;
                    if (vfGuiaKiche.getDisplayedChild() == 1)
                        break;

                    // Next screen comes in from right.
                    vfGuiaEsp.setInAnimation(this, R.anim.slide_in_from_right);
                    vfGuiaMam.setInAnimation(this, R.anim.slide_in_from_right);
                    vfGuiaKiche.setInAnimation(this, R.anim.slide_in_from_right);
                    // Current screen goes out from left.
                    vfGuiaEsp.setOutAnimation(this, R.anim.slide_out_to_left);
                    vfGuiaMam.setOutAnimation(this, R.anim.slide_out_to_left);
                    vfGuiaKiche.setOutAnimation(this, R.anim.slide_out_to_left);

                    vfGuiaEsp.showPrevious();
                    vfGuiaMam.showPrevious();
                    vfGuiaKiche.showPrevious();
                }
                break;
        }
        return false;
    }
}