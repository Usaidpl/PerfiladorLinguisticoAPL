package gt.lea.usaid.perfiladorlinguistico;

import android.app.Activity;

/**
 * Created by programadormd on 12/08/16.
 */
public class AdapterFlipper extends Activity{

    int imageFlipper;
    String textFlipper;

    public AdapterFlipper(int imageFlipper, String textFlipper) {
        this.imageFlipper = imageFlipper;
        this.textFlipper = textFlipper;
    }

    public int getImageFlipper() {
        return imageFlipper;
    }

    public String getTextFlipper() {
        return textFlipper;
    }

    public int getId(){
        return textFlipper.hashCode();
    }

    public static AdapterFlipper[] ITEMS ={
            new AdapterFlipper(android.R.drawable.star_big_off, "d"),
            new AdapterFlipper(android.R.drawable.star_big_off, "a"),
            new AdapterFlipper(android.R.drawable.star_big_off, "d"),
            new AdapterFlipper(android.R.drawable.star_big_off, "f"),
            new AdapterFlipper(android.R.drawable.star_big_off, "g")
    };

    public static AdapterFlipper getItem(int id){
        for (AdapterFlipper item : ITEMS){
            if (item.getId()==id){
                return item;
            }
        }
        return null;
    }
}
