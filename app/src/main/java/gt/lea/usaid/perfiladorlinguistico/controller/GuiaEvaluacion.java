package gt.lea.usaid.perfiladorlinguistico.controller;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import gt.lea.usaid.perfiladorlinguistico.R;

/**
 * Created by Roberto on 21/06/16.
 */
public class GuiaEvaluacion extends android.support.v4.app.Fragment{
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        View vista = inflater.inflate(R.layout.pruebastres, container, false);
        return vista;
    }
}
