package gt.lea.usaid.perfiladorlinguistico.utils;

/**
 * Created by administracion on 30/07/2016.
 */

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.Environment;
import android.support.v4.app.ActivityCompat;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

import gt.lea.usaid.perfiladorlinguistico.R;
import gt.lea.usaid.perfiladorlinguistico.controller.evaluacion.Interaccion;

public class Localizacion extends Activity {

    private TextView tv;
    private String direccion_final;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.localiza);
        LocationManager milocManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        LocationListener milocListener = new MiLocationListener();
        tv = (TextView) findViewById(R.id.tvLocaliza);
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) !=
                PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this,
                Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        milocManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, milocListener);
    }

    public class MiLocationListener implements LocationListener {
        public void onLocationChanged(Location loc) {
            loc.getLatitude();
            loc.getLongitude();
            String coordenadas = "Mis coordenadas son: " + "Latitud = " + loc.getLatitude() + "Longitud = " + loc.getLongitude();

            setLocation(loc);
        }

        public void onProviderDisabled(String provider) {
            Toast.makeText(getApplicationContext(), "Gps Desactivado", Toast.LENGTH_SHORT).show();
        }

        public void onProviderEnabled(String provider) {
            Toast.makeText(getApplicationContext(), "Gps Activo", Toast.LENGTH_SHORT).show();
        }

        public void onStatusChanged(String provider, int status, Bundle extras) {
        }

        public void setLocation(Location loc) {

            if (loc.getLatitude() != 0.0 && loc.getLongitude() != 0.0) {
                String SALTO_LINE = "\n", ESPACIO = "  ", COMA = ",";

                try {
                    Geocoder geocoder = new Geocoder(Localizacion.this, Locale.getDefault());
                    List<Address> list = geocoder.getFromLocation(loc.getLatitude(), loc.getLongitude(), 1);
                    if (!list.isEmpty()) {
                        Address address = list.get(0);
                        String direccion =  "Mi direccion es: \n" + address.getAddressLine(0) +
                                COMA + address.getAddressLine(1) + SALTO_LINE +
                                address.getSubAdminArea() +  "," + address.getSubLocality() + COMA +
                                address.getSubThoroughfare();
                        tv.setText(direccion);
                        direccion_final = direccion;
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public String getDireccion(){
        return direccion_final;
    }
}