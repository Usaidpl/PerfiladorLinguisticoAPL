package gt.lea.usaid.perfiladorlinguistico.utils;


import android.os.Bundle;
import android.preference.PreferenceActivity;

import gt.lea.usaid.perfiladorlinguistico.R;

/**
 * Created by Bryan on 03/07/2016.
 */
public class Preferencia extends PreferenceActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.prefs);
    }
}
