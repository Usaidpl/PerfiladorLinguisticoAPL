package gt.lea.usaid.perfiladorlinguistico.controller.usaid;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import gt.lea.usaid.perfiladorlinguistico.R;
import gt.lea.usaid.perfiladorlinguistico.view.guias.GuiaComprensionOral;
import gt.lea.usaid.perfiladorlinguistico.view.guias.GuiaExpresionOral;
import gt.lea.usaid.perfiladorlinguistico.view.guias.GuiaGramatica;
import gt.lea.usaid.perfiladorlinguistico.view.guias.GuiaInteraccionOral;
import gt.lea.usaid.perfiladorlinguistico.view.guias.GuiaNavegacionApp;
import gt.lea.usaid.perfiladorlinguistico.view.guias.GuiaPrecisionOral;
import gt.lea.usaid.perfiladorlinguistico.view.guias.GuiaSonidosEspecificos;
import gt.lea.usaid.perfiladorlinguistico.view.guias.GuiaVocabulario;


public class GuiaEvaluacion extends android.support.v4.app.Fragment implements View.OnClickListener {
    private ImageView comprencionoral, expresionral, gramatica, interpretacionoral, precicionoral,sonidosespecificos, vocabulario, guia;
    private OnFragmentInteractionListener mListener;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        View vista = inflater.inflate(R.layout.guia_evaluacion, container, false);
        comprencionoral =(ImageView) vista.findViewById(R.id.guia_interaccion_oral_oral);
        expresionral =(ImageView) vista.findViewById(R.id.guia_compresion_oral);
        gramatica =(ImageView) vista.findViewById(R.id.guia_vocabulario_precision);
        interpretacionoral =(ImageView) vista.findViewById(R.id.guia_vocabulario);
        precicionoral =(ImageView) vista.findViewById(R.id.guia_sonidos_especificos);
        sonidosespecificos =(ImageView) vista.findViewById(R.id.guia_gramatica);
        vocabulario =(ImageView) vista.findViewById(R.id.guia_expresion_oral);
        guia = (ImageView) vista.findViewById(R.id.guia_navegacion2);



        comprencionoral.setOnClickListener(this);
        expresionral.setOnClickListener(this);
        gramatica.setOnClickListener(this);
        interpretacionoral.setOnClickListener(this);
        precicionoral.setOnClickListener(this);
        sonidosespecificos.setOnClickListener(this);
        vocabulario.setOnClickListener(this);
        guia.setOnClickListener(this);

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
            case R.id.guia_interaccion_oral_oral:
                intent = new Intent(getActivity(), GuiaInteraccionOral.class);
                getActivity().startActivity(intent);
                break;
            case R.id.guia_compresion_oral:
                intent = new Intent(getActivity(), GuiaComprensionOral.class);
                startActivity(intent);
                break;
            case R.id.guia_vocabulario_precision:
                intent = new Intent(getActivity(), GuiaPrecisionOral.class);
                startActivity(intent);
                break;
            case R.id.guia_vocabulario:
                intent = new Intent(getActivity(), GuiaVocabulario.class);
                startActivity(intent);
                break;
            case R.id.guia_sonidos_especificos:
                intent = new Intent(getActivity(), GuiaSonidosEspecificos.class);
                startActivity(intent);
                break;
            case R.id.guia_gramatica:
                intent = new Intent(getActivity(), GuiaGramatica.class);
                startActivity(intent);
                break;
            case R.id.guia_expresion_oral:
                intent = new Intent(getActivity(), GuiaExpresionOral.class);
                startActivity(intent);
                break;
            case R.id.guia_navegacion2:
                intent = new Intent(getActivity(), GuiaNavegacionApp.class);
                startActivity(intent);
                break;
        }
    }

    public interface OnFragmentInteractionListener {

        void onFragmentInteraction(Uri uri);
    }

}
