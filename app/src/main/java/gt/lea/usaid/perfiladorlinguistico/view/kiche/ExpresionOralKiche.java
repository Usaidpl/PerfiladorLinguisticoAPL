package gt.lea.usaid.perfiladorlinguistico.view.kiche;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ViewFlipper;

import gt.lea.usaid.perfiladorlinguistico.R;

/**
 * Created by Roberto on 19/06/2016.
 */
public class ExpresionOralKiche extends Activity  {


    private static final int SWIPE_MIN_DISTANCE = 120;
    private static final int SWIPE_THRESHOLD_VELOCITY = 200;
    private ViewFlipper viewflipper;
    private Animation.AnimationListener mAnimationListener;
    private Context mContext;
    private final GestureDetector detector = new GestureDetector(new SwipeGestureDetector());

    private View preguntas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.expresion_oral);


        mContext = this;
        preguntas = findViewById(R.id.seccion_preguntas);
        viewflipper = (ViewFlipper) this.findViewById(R.id.viewflipper);
        viewflipper.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(final View view, final MotionEvent event) {
                detector.onTouchEvent(event);
                return true;
            }
        });

        View pregunta = findViewById(R.id.header1);

        pregunta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (preguntas.getVisibility() == View.GONE) {
                    preguntas.setVisibility(View.VISIBLE);
                } else {
                    preguntas.setVisibility(View.GONE);
                }
            }
        });

        mAnimationListener = new Animation.AnimationListener() {
            public void onAnimationStart(Animation animation) {
            }

            public void onAnimationRepeat(Animation animation) {
            }

            public void onAnimationEnd(Animation animation) {
            }
        };
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