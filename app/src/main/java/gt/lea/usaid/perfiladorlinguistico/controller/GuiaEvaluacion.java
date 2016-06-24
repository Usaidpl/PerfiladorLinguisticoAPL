package gt.lea.usaid.perfiladorlinguistico.controller;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import gt.lea.usaid.perfiladorlinguistico.R;
import gt.lea.usaid.perfiladorlinguistico.view.espanol.Comprende;
import gt.lea.usaid.perfiladorlinguistico.view.espanol.ExpresionOral;
import gt.lea.usaid.perfiladorlinguistico.view.espanol.Interpreta;
import gt.lea.usaid.perfiladorlinguistico.view.espanol.SonidosEspecificos;
import gt.lea.usaid.perfiladorlinguistico.view.espanol.Vocabulario;
import gt.lea.usaid.perfiladorlinguistico.view.guias.GuiaComprensionOral;

/**
 * Created by Roberto on 21/06/16.
 */
public class GuiaEvaluacion extends android.support.v4.app.Fragment implements View.OnClickListener {
    private ImageView comprencionoral, expresionral, gramatica, interpretacionoral, precicionoral,sonidosespecificos, vocabulario;
    private OnFragmentInteractionListener mListener;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        View vista = inflater.inflate(R.layout.guia_evaluacion, container, false);
        comprencionoral =(ImageView) vista.findViewById(R.id.guia_comprension_oral);


        comprencionoral.setOnClickListener(this);
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

    @Override
    public void onClick(View v) {
        Intent intent = null;
        switch (v.getId()) {
            case R.id.guia_comprension_oral:
                intent = new Intent(getActivity(), GuiaComprensionOral.class);
                getActivity().startActivity(intent);
                break;
            case R.id.guia_expresion_oral:
                intent = new Intent(getActivity(), Comprende.class);
                startActivity(intent);
                break;
            case R.id.guia_gramatica:
                intent = new Intent(getActivity(), ExpresionOral.class);
                startActivity(intent);
                break;
            case R.id.guia_expresion_oral2:
                intent = new Intent(getActivity(), Interpreta.class);
                startActivity(intent);
                break;
            case R.id.guia_precicion_oral:
                intent = new Intent(getActivity(), Precicion.class);
                startActivity(intent);
                break;
            case R.id.guia_sonidosespeficicos:
                intent = new Intent(getActivity(), SonidosEspecificos.class);
                startActivity(intent);
                break;
            case R.id.guia_vocabulario:
                intent = new Intent(getActivity(), Vocabulario.class);
                startActivity(intent);
                break;
        }
    }

    public interface OnFragmentInteractionListener {

        void onFragmentInteraction(Uri uri);
    }

}
