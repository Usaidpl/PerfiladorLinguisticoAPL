package gt.lea.usaid.perfiladorlinguistico.view.espanol;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import gt.lea.usaid.perfiladorlinguistico.R;

/**
 * Created by Roberto on 19/06/2016.
 */
public class PruebasDos extends Fragment {
    Context context;
    Button btnpruebas;
    private OnFragmentInteractionListener mListener;

        @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View vista  = inflater.inflate(R.layout.pruebasdos, container, false);
        btnpruebas = (Button) vista.findViewById(R.id.btnpruebas);
        btnpruebas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), Pruebas.class);
                startActivity(intent);
            }
        });
        return vista;
    }

    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    public interface OnFragmentInteractionListener {

        void onFragmentInteraction(Uri uri);
    }

}
