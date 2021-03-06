package gt.lea.usaid.perfiladorlinguistico.controller.evaluacion;

import android.app.Activity;
import android.content.Context;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.os.Bundle;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

/**
 * Created by Bryan on 01/08/2016.
 */
public abstract class Ubicacion implements LocationListener{

    private android.content.Context context;
    private static final double  LOCALIZACION_NULL = 0.0;


    public Ubicacion(android.app.Activity activity)
    {
        context = activity;
    }

    public Context getActivityGPS(){
        return context;
    }

    @Override
    public void onLocationChanged(Location location) {
        location.getLongitude();
        location.getLatitude();
        locality(location);
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

    private void locality(Location loc){

        if (loc.getLatitude() != 0.0 && loc.getLongitude() != 0.0) {
            String SALTO_LINE = "\n", ESPACIO = "  ", COMA = ", ";
            try {
                Geocoder geocoder = new Geocoder(context,Locale.getDefault());
                List<Address> list = geocoder.getFromLocation(loc.getLatitude(), loc.getLongitude(), 1);
                if (!list.isEmpty()) {
                    Address address = list.get(0);
                    String direccion =  "Mi direccion es: \n" + address.getAddressLine(0) +
                            COMA + address.getAddressLine(1) + SALTO_LINE +
                            address.getSubAdminArea() +  "," + address.getSubLocality() + COMA +
                            address.getSubThoroughfare();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
