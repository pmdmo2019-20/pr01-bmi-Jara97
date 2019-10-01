package es.iessaladillo.pedrojoya.pr01.ui.main;

import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import es.iessaladillo.pedrojoya.pr01.R;

public class MainActivity extends AppCompatActivity {

    EditText txtWeight;
    EditText txtHeight;
    TextView lblResult;
    TextView lblWeight;
    TextView lblHeight;
    Button btnCalculate;
    Button btnReset;
    ImageView imgBmi;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);
        inicializar();
    }

    private void inicializar() {
        txtWeight= ActivityCompat.requireViewById(this,R.id.txtWeight);
        lblResult= ActivityCompat.requireViewById(this,R.id.lblResult);
        txtHeight= ActivityCompat.requireViewById(this, R.id.txtHeight);
        lblWeight= ActivityCompat.requireViewById(this, R.id.lblWeight);
        lblHeight= ActivityCompat.requireViewById(this, R.id.lblHeight);
        btnCalculate=ActivityCompat.requireViewById(this,R.id.btnCalculate);
        btnReset=ActivityCompat.requireViewById(this,R.id. btnReset);
        imgBmi= ActivityCompat.requireViewById(this, R.id.imgBmi);
        btnReset.setOnClickListener(x->reset());
        btnCalculate.setOnClickListener(x->calculate());

    }

    private void reset(){
        txtHeight.setText("");
        txtWeight.setText("");
        lblResult.setText("");
        imgBmi.setImageResource(R.drawable.bmi);
    }

    private void  calculate(){
        int weight=Integer.parseInt(txtWeight.getText().toString());
        float height=Float.parseFloat(txtHeight.getText().toString());
        lblResult.setText(String.valueOf(weight/(height*height)));


    }


    // TODO

}
