package gt.lea.usaid.perfiladorlinguistico.view.guias;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
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
public class GuiaVocabulario extends Activity {
    TabHost tabHost;
    private ViewFlipper vfGuiaEsp, vfGuiaMam, vfGuiaKiche;
    private float lastX;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.guia_vocabulario);
        vfGuiaEsp = (ViewFlipper) findViewById(R.id.vfGuiaVocabulario);
        vfGuiaMam = (ViewFlipper) findViewById(R.id.vfGuiaVocabularioMam);
        vfGuiaKiche = (ViewFlipper) findViewById(R.id.vfGuiaVocabularioKiche);

        initToolBar();

        Resources res = getResources();
        TabHost tabs = (TabHost) findViewById(R.id.tabHost);
        tabs.setup();

        //Tab 1
        TabHost.TabSpec spec = tabs.newTabSpec("Tab One");
        spec.setContent(R.id.tab1);
        spec.setIndicator("Español",
                res.getDrawable(android.R.drawable.btn_star_big_on));
        tabs.addTab(spec);



        //Tab 2
        spec = tabs.newTabSpec("Tab Two");
        spec.setContent(R.id.tab2);
        spec.setIndicator("Mam",
                res.getDrawable(android.R.drawable.ic_btn_speak_now));
        tabs.addTab(spec);


        //Tab 3
        spec = tabs.newTabSpec("Tab Three");
        spec.setContent(R.id.tab3);
        //spec.setIndicator("Kiche");
        spec.setIndicator("Kiche",
                res.getDrawable(android.R.drawable.ic_btn_speak_now));
        tabs.addTab(spec);

        tabs.setCurrentTab(0);

    }

    private void initToolBar() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle(R.string.guia_vocabulario);
        //setSupportActionBar(toolbar);
        toolbar.setTitleTextColor(getResources().getColor(R.color.myColorBasic));


        toolbar.setNavigationIcon(R.drawable.ic_arrow_back_black);
        toolbar.setNavigationOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(GuiaVocabulario.this, "Regresando al Menu!", Toast.LENGTH_SHORT).show();
                        Intent navigation_menu = new Intent(getApplication(), NavigationMenu.class);
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

                    vfGuiaEsp.setInAnimation(this, R.anim.slide_in_from_right);
                    vfGuiaMam.setInAnimation(this, R.anim.slide_in_from_right);
                    vfGuiaKiche.setInAnimation(this, R.anim.slide_in_from_right);

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