package gt.lea.usaid.perfiladorlinguistico.controller.usaid;

import android.os.Bundle;

/**
 * Created by programadormd on 22/06/16.
 */
public class ResultadosAula extends android.support.v4.app.Fragment {

    public static final String KEY = "resultados";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle b = new Bundle();
        String arreglo[] = {"KICHE","bryan","51","80","85","50","70","80","60"};
        b.putStringArray(KEY, arreglo);
    }

    public interface OnFragmentInteractionListener {
    }
}
