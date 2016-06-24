package gt.lea.usaid.perfiladorlinguistico.controller;

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
import gt.lea.usaid.perfiladorlinguistico.view.espanol.ComprensionOral;
import gt.lea.usaid.perfiladorlinguistico.view.espanol.ExpresionOral;
import gt.lea.usaid.perfiladorlinguistico.view.espanol.Gramatica;
import gt.lea.usaid.perfiladorlinguistico.view.espanol.InteraccionOral;
import gt.lea.usaid.perfiladorlinguistico.view.espanol.SonidosEspecificos;
import gt.lea.usaid.perfiladorlinguistico.view.espanol.Vocabulario;
import gt.lea.usaid.perfiladorlinguistico.view.guias.GuiaPrecisionOral;

/**
 * Created by Roberto on 19/06/2016.
 */
public class Series extends Fragment implements View.OnClickListener {
    private Button gramatica, expresionoral, vocabulario, sonidosespecificos, comprende, interpreta, precicion;
    private OnFragmentInteractionListener mListener;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View vista = inflater.inflate(R.layout.series, container, false);

        gramatica = (Button) vista.findViewById(R.id.btnGramatica);
        expresionoral = (Button) vista.findViewById(R.id.btnExpresionOral);
        vocabulario = (Button) vista.findViewById(R.id.btnVocabulario);
        sonidosespecificos = (Button) vista.findViewById(R.id.btnSonidosEspecificos);
        comprende = (Button) vista.findViewById(R.id.btnComprende);
        interpreta = (Button) vista.findViewById(R.id.btnInterpreta);
        precicion = (Button) vista.findViewById(R.id.btnPrecicion);

        gramatica.setOnClickListener(this);
        expresionoral.setOnClickListener(this);
        vocabulario.setOnClickListener(this);
        sonidosespecificos.setOnClickListener(this);
        comprende.setOnClickListener(this);
        interpreta.setOnClickListener(this);
        precicion.setOnClickListener(this);
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
            case R.id.btnGramatica:
                intent = new Intent(getActivity(), Gramatica.class);
                getActivity().startActivity(intent);
                break;
            case R.id.btnComprende:
                intent = new Intent(getActivity(), ComprensionOral.class);
                startActivity(intent);
                break;
            case R.id.btnExpresionOral:
                intent = new Intent(getActivity(), ExpresionOral.class);
                startActivity(intent);
                break;
            case R.id.btnInterpreta:
                intent = new Intent(getActivity(), InteraccionOral.class);
                startActivity(intent);
                break;
            case R.id.btnPrecicion:
                intent = new Intent(getActivity(), GuiaPrecisionOral.class);
                startActivity(intent);
                break;
            case R.id.btnSonidosEspecificos:
                intent = new Intent(getActivity(), SonidosEspecificos.class);
                startActivity(intent);
                break;
            case R.id.btnVocabulario:
                intent = new Intent(getActivity(), Vocabulario.class);
                startActivity(intent);
                break;
        }
    }

    public interface OnFragmentInteractionListener {

        void onFragmentInteraction(Uri uri);
    }

}
