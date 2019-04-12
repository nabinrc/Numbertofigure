package com.e.numbertofigure;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText enternumber;
    Button change;
    Numtofigure getset =new Numtofigure();


    TextView result;
    private static final String[] tensNames = { "", " ten", " twenty", " thirty", " forty",
            " fifty", " sixty", " seventy", " eighty", " ninety" };

    private static final String[] numNames = { "", " one", " two", " three", " four", " five",
            " six", " seven", " eight", " nine", " ten", " eleven", " twelve", " thirteen",
            " fourteen", " fifteen", " sixteen", " seventeen", " eighteen", " nineteen" };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        enternumber=findViewById(R.id.etEnternum);
        change =findViewById(R.id.btnConvert);
        result =findViewById(R.id.tvMyresult);

        change.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (TextUtils.isEmpty(enternumber.getText().toString())) {
            enternumber.setError("Please Enter a number 0 to 999");
            return;
        }

//        String number=enternumber.getText().toString();
        getset.setNumber(enternumber.getText().toString());

        result.setText(convertLessThanOneThousand(Integer.parseInt(getset.getNumber())));

    }
    private static String convertLessThanOneThousand(int number)
    {
        String soFar;

        if (number % 100 < 20)
        {
            soFar = numNames[number % 100];
            number /= 100;
        } else
        {
            soFar = numNames[number % 10];
            number /= 10;

            soFar = tensNames[number % 10] + soFar;
            number /= 10;
        }
        if (number == 0)
            return soFar;
        return numNames[number] + " hundred" + soFar;
    }

}
