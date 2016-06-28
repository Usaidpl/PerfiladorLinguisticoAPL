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
import gt.lea.usaid.perfiladorlinguistico.view.espanol.Interactua;

/**
 * Created by Roberto on 21/06/16.
 */
public class IniciarEvaluacion extends android.support.v4.app.Fragment implements View.OnClickListener  {
    private ImageView ivMamEva, ivKicheEva;
    private OnFragmentInteractionListener mListener;

    @Override
    public View onCreateView(LayoutInflater inflater,  ViewGroup container, Bundle savedInstanceState) {
        View vista = inflater.inflate(R.layout.iniciar_evaluacion, container, false);
        ivMamEva =(ImageView) vista.findViewById(R.id.ivMamEva);
        ivKicheEva =(ImageView) vista.findViewById(R.id.ivKicheEva);

        ivMamEva.setOnClickListener(this);
        ivKicheEva.setOnClickListener(this);
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
            case R.id.ivMamEva:
                intent = new Intent(getActivity(), gt.lea.usaid.perfiladorlinguistico.view.espanol.SonidosEspecificos.class);
                getActivity().startActivity(intent);
                break;
            case R.id.ivKicheEva:
                //intent = new Intent(getActivity(), ExpresionOral.class);
                intent = new Intent(getContext(), Comprende.class);
                startActivity(intent);
                break;
        }
    }

    public interface OnFragmentInteractionListener {

        void onFragmentInteraction(Uri uri);
    }

}
