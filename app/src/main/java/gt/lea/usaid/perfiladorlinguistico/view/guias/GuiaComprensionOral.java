package gt.lea.usaid.perfiladorlinguistico.view.guias;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TabHost;
import android.widget.Toast;
import android.widget.ViewFlipper;

import gt.lea.usaid.perfiladorlinguistico.NavigationMenu;
import gt.lea.usaid.perfiladorlinguistico.R;

/**
 * Created by Roberto on 23/06/2016.
 */
public class GuiaComprensionOral extends Activity {

    private static final int SWIPE_MIN_DISTANCE = 120;
    private static final int SWIPE_THRESHOLD_VELOCITY = 200;
    private ViewFlipper viewflipper;
    private Animation.AnimationListener mAnimationListener;
    private Context mContext;
    private final GestureDetector detector = new GestureDetector(new SwipeGestureDetector());

    private View preguntas;
    TabHost tabHost;
    Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.guia_comprension_oral);
        initToolBar();
        TabHost host = (TabHost)findViewById(R.id.tabHost);
        host.setup();


        viewflipper = (ViewFlipper) this.findViewById(R.id.viewflipper);
        viewflipper.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(final View view, final MotionEvent event) {
                detector.onTouchEvent(event);
                return true;
            }
        });

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

        toolbar.setNavigationIcon(R.mipmap.back3);
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
    class SwipeGestureDetector extends GestureDetector.SimpleOnGestureListener {
        @Override
        public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
            try {
                if (e1.getX() - e2.getX() > SWIPE_MIN_DISTANCE && Math.abs(velocityX) > SWIPE_THRESHOLD_VELOCITY) {
                    viewflipper.setInAnimation(AnimationUtils.loadAnimation(mContext, R.anim.left_in));
                    viewflipper.setOutAnimation(AnimationUtils.loadAnimation(mContext, R.anim.left_out));
                    viewflipper.getInAnimation().setAnimationListener(mAnimationListener);
                    viewflipper.showNext();
                    return true;
                } else if (e2.getX() - e1.getX() > SWIPE_MIN_DISTANCE && Math.abs(velocityX) > SWIPE_THRESHOLD_VELOCITY) {
                    viewflipper.setInAnimation(AnimationUtils.loadAnimation(mContext, R.anim.right_in));
                    viewflipper.setOutAnimation(AnimationUtils.loadAnimation(mContext, R.anim.right_out));
                    viewflipper.getInAnimation().setAnimationListener(mAnimationListener);
                    viewflipper.showPrevious();
                    return true;
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
            return false;
        }
    }
    @Override
    protected void onPause() {
        super.onPause();
        finish();
    }
}