package gt.lea.usaid.perfiladorlinguistico.view.espanol;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.view.View;
import android.widget.CompoundButton;

import gt.lea.usaid.perfiladorlinguistico.R;
import gt.lea.usaid.perfiladorlinguistico.utils.interfaces.OnInitializeComponent;

public class ExpresionOral extends Activity implements OnInitializeComponent, View.OnClickListener, CompoundButton.OnCheckedChangeListener {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_expresion_oral);
    }

    @Override
    public void setOnInit(@IdRes int[][] matriz) {

    }

    @Override
    public void onClick(View v) {

    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

    }


}
