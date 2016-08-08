package gt.lea.usaid.perfiladorlinguistico.controller;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import gt.lea.usaid.perfiladorlinguistico.R;

public class IniciarEvaluacion extends android.support.v4.app.Fragment implements View.OnClickListener  {
    public static String KEY_EVALUACION = "Evalua";
    private ImageView ivEspanolEva, ivMamEva, ivKicheEva;
    private OnFragmentInteractionListener mListener;

    @Override
    public View onCreateView(LayoutInflater inflater,  ViewGroup container, Bundle savedInstanceState) {
        View vista = inflater.inflate(R.layout.iniciar_evaluacion, container, false);
        ivMamEva =(ImageView) vista.findViewById(R.id.ivMamEva);
        ivKicheEva =(ImageView) vista.findViewById(R.id.ivKicheEva);
        //ivEspanolEva = (ImageView) vista.findViewById(R.id.ivEspanolEva);
        ivMamEva.setOnClickListener(this);
        ivKicheEva.setOnClickListener(this);
        //ivEspanolEva.setOnClickListener(this);
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
        int evalua = -9;
        switch (v.getId()) {
            case R.id.ivMamEva:
                evalua = 0;
                break;
            case R.id.ivKicheEva:
                evalua = 1;
                break;
        }
    }


    public interface OnFragmentInteractionListener {
        void onFragmentInteraction(Uri uri);
    }

}
