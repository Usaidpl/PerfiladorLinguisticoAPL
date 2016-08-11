package gt.lea.usaid.perfiladorlinguistico.controller.control_vista;

import android.app.Activity;
import android.view.MotionEvent;
import android.widget.ViewFlipper;

import gt.lea.usaid.perfiladorlinguistico.R;

/**
 * Created by programadormd on 11/08/16.
 */
public class TouchFlipper extends Activity {
    private float lastX;
    private ViewFlipper vfGuiaEsp, vfGuiaMam, vfGuiaKiche;

    public void add(ViewFlipper[] s){
        if(s != null ){
            vfGuiaEsp = s[0];
            vfGuiaKiche = s[1];
            vfGuiaMam = s[2];
        }
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

