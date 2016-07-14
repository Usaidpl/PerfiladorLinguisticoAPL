package gt.lea.usaid.perfiladorlinguistico.utils;

import android.app.Activity;
import android.location.Location;
import android.location.LocationListener;
import android.os.Bundle;

import gt.lea.usaid.perfiladorlinguistico.controller.Verifica;
import gt.lea.usaid.perfiladorlinguistico.view.espanol.Interactua;

/**
 * Created by Bryan on 11/07/2016.
 */
public class Localiza  implements LocationListener {

    private Interactua i;

    public void interactua(Interactua i){
        this.i = i;
    }

    public Activity getInteractua(){
        return i;
    }

    @Override
    public void onLocationChanged(Location location) {
        String s = "" + location.getLongitude() + " " + location.getLatitude();
        //i.msg(s);
        i.setMsg(s);
    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {

    }

    @Override
    public void onProviderEnabled(String provider) {
        i.msg("Activado");
    }

    @Override
    public void onProviderDisabled(String provider) {
        i.msg("Desactivado");
    }
}
