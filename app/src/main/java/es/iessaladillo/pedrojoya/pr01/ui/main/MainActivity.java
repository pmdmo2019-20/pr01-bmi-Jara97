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
import es.iessaladillo.pedrojoya.pr01.bmi.BmiCalculator;
import es.iessaladillo.pedrojoya.pr01.utils.SoftInputUtils;

public class MainActivity extends AppCompatActivity {

    EditText txtWeight;
    EditText txtHeight;
    TextView lblResult;
    TextView lblWeight;
    TextView lblHeight;
    Button btnCalculate;
    Button btnReset;
    ImageView imgBmi;
    BmiCalculator calculator=new BmiCalculator();



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
        btnReset.setOnClickListener(x->{reset();
                    txtWeight.setError(null);
                    txtHeight.setError(null);
        }
        );

        btnCalculate.setOnClickListener(x->{calculate();
        SoftInputUtils.hideKeyboard(findViewById(R.id.viewId));
        });

    }

    private void reset(){
        txtHeight.setText("");
        txtWeight.setText("");
        lblResult.setText("");
        imgBmi.setImageResource(R.drawable.bmi);
    }

    private void  calculate(){
        float bmi;
        String type;
        String type2;
       if(validarW(txtWeight.getText().toString())&&validarH(txtHeight.getText().toString())) {
           int weight=Integer.parseInt(txtWeight.getText().toString());
           float height=Float.parseFloat(txtHeight.getText().toString());
           calculator.calculateBmi(weight,height);
           bmi=calculator.calculateBmi(weight,height);
           type=calculator.getBmiClasification(Float.valueOf(bmi)).toString();
           type2=translate(type);
           lblResult.setText(String.format("BMI: %s %s",bmi,type2));
           setImage(bmi);
       }
        if(!validarW(txtWeight.getText().toString())){
            txtWeight.setError("invalid weight");
       }
        if(!validarH(txtHeight.getText().toString())){
            txtHeight.setError("invalid height");
        }


    }

    private void setImage(float bmi){
        if(bmi<18.5){
            imgBmi.setImageResource(R.drawable.underweight);
        }
        if(bmi>=18.5 && bmi<=24.9){
            imgBmi.setImageResource(R.drawable.normal_weight);
        }
        if(bmi>24.9 && bmi<=29.9){
            imgBmi.setImageResource(R.drawable.overweight);
        }
        if(bmi>29.9 && bmi<=34.9){
            imgBmi.setImageResource(R.drawable.obesity1);
        }
        if(bmi>34.9 && bmi<40){
            imgBmi.setImageResource(R.drawable.obesity2);
        }
        if(bmi>=40){
            imgBmi.setImageResource(R.drawable.obesity3);
        }
    }

    public boolean validarW(String weight){
        if(weight.equals("")||Integer.parseInt(weight)<=0){
            return false;
        }
        else{
            return true;
        }

    }

    public boolean validarH(String height){
        if(height.equals("")||Float.parseFloat(height)<=0){
            return false;
        }
        else{
            return true;
        }

    }


    public String translate(String s){
        if(s.equals("LOW_WEIGHT")){
            return "Low weight";
        }
        if(s.equals("NORMAL_WEIGHT")){
            return "Normal weight";
        }
        if(s.equals("OVERWWEIGHT")){
            return "Overweight";
        }
        if(s.equals("OBESITY_GRADE_1")){
            return "Obesity grade 1";
        }
        if(s.equals("OBESITY_GRADE_2")){
            return "Obesity grade 2";
        }
        else{
            return "Obesity grade 3";
        }
    }


    // TODO

}
