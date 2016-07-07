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
import gt.lea.usaid.perfiladorlinguistico.view.espanol.Interactua;
import gt.lea.usaid.perfiladorlinguistico.view.mam.GramaticaMam;

/**
 * Created by Roberto on 21/06/16.
 */
public class IniciarEvaluacion extends android.support.v4.app.Fragment implements View.OnClickListener  {
     private ImageView ivEspanolEva, ivMamEva, ivKicheEva;
    private OnFragmentInteractionListener mListener;
    public static final String KEY_EVALUACION = "Evaluacion";

    @Override
    public View onCreateView(LayoutInflater inflater,  ViewGroup container, Bundle savedInstanceState) {
        View vista = inflater.inflate(R.layout.iniciar_evaluacion, container, false);
        ivMamEva =(ImageView) vista.findViewById(R.id.ivMamEva);
        ivKicheEva =(ImageView) vista.findViewById(R.id.ivKicheEva);
        ivEspanolEva = (ImageView) vista.findViewById(R.id.ivEspanolEva);
        ivMamEva.setOnClickListener(this);
        ivKicheEva.setOnClickListener(this);
        ivEspanolEva.setOnClickListener(this);
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
        Bundle b = new Bundle();
        int evalua = 0;
        switch (v.getId()) {
            case R.id.ivMamEva:
                intent = new Intent(getActivity(), Interactua.class);
               //b.putInt(KEY_EVALUACION, 0);
                intent.putExtras(envia(0));
                getActivity().startActivity(intent);
                break;
            case R.id.ivKicheEva:
                intent = new Intent(getActivity(), GramaticaMam.class);
                intent.putExtras(envia(1));
                getActivity().startActivity(intent);
                break;
            case R.id.ivEspanolEva:
                intent = new Intent(getActivity(), Interactua.class);
                intent.putExtras(envia(2));
                getActivity().startActivity(intent);
                break;
        }
        //select * from entrevista join interaccion join .... where id = 002;
        //Inte
    }

    private Bundle envia(int cantidad){
        Bundle b= new Bundle();
        b.putInt(KEY_EVALUACION , cantidad);
        return b;
    }

    public interface OnFragmentInteractionListener {
        void onFragmentInteraction(Uri uri);
    }

}
