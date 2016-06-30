package gt.lea.usaid.perfiladorlinguistico.controller;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.location.Location;
import android.location.LocationListener;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.widget.ViewFlipper;

import gt.lea.usaid.perfiladorlinguistico.utils.interfaces.OnStartNextContext;

/**
 * Created by Bryan on 20/06/16.
 */
public class FlipperActivity extends Activity implements OnStartNextContext {
    private ViewFlipper flipper;
    private double longitud, latitud;

    public void setFlipperId(@IdRes int flipperId){
        flipper = (ViewFlipper) findViewById(flipperId);
    }

    protected ViewFlipper getFlipper(){
        return   flipper;
    }

    protected  ViewFlipper getFlipper(@IdRes int flipperId){
        flipper = (ViewFlipper) findViewById(flipperId);
        return flipper;
    }

    @Override
    public void setNextContext(Context context, Class<?> next_context) {
        Intent i = new Intent(context, next_context);
        startActivity(i);
    }

    public static final class Localization implements LocationListener{

        @Override
        public void onLocationChanged(Location location) {
             double longi = location.getLongitude(), lat = location.getLatitude();
        }

        @Override
        public void onStatusChanged(String provider, int status, Bundle extras) {

        }

        @Override
        public void onProviderEnabled(String provider) {

        }

        @Override
        public void onProviderDisabled(String provider) {

        }
    }

    private void setLongitud(double longi, double lat){
        longitud = longi;
        latitud = lat;
    }


}
