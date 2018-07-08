package com.example.asus_pc.madicalcalculatorapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    String doWhat;
    TextView ansView;
    EditText et;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ansView = findViewById(R.id.textView_ans);
        et = findViewById(R.id.editText_weight);
    }

    public void convert(View view) {
        float w = (float) 0.0;
        float q = (float) 0.453592;
        float ans = (float) 0.0;
        if (TextUtils.isEmpty(et.getText().toString())) {
            Toast.makeText(this, "Enter Weight", Toast.LENGTH_SHORT).show();
        } else {
            w = Float.parseFloat(et.getText().toString());
            if (doWhat == "PtoK") {
                ans = w * q;
                ansView.setText(String.valueOf(ans) + " Kilogram");
            } else if (doWhat == "KtoP") {
                ans = w / q;
                ansView.setText(String.valueOf(ans) + " Pount");

            } else {
                Toast.makeText(this, "Chack What you want to convert", Toast.LENGTH_SHORT).show();
            }

        }
    }

    public void onClickRadioButton(View view) {
        boolean isClick = ((RadioButton) view).isChecked();
        switch (view.getId()) {
            case R.id.radioButton_PtoK:
                if (isClick)
                    doWhat = "PtoK";
                break;
            case R.id.radioButton_KtoP:
                if (isClick)
                    doWhat = "KtoP";
                break;
        }
    }
}
