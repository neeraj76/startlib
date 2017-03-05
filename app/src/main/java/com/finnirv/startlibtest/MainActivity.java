package com.finnirv.startlibtest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.finnirv.startlib.CentralTendency;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    TextView tvMain;
    Button btnMain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvMain = (TextView)findViewById(R.id.tvMain);
        btnMain = (Button)findViewById(R.id.btnMain);
        btnMain.setOnClickListener(btnMainListener);
    }


    View.OnClickListener btnMainListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            ArrayList<Integer> numbers = new ArrayList<>();
            Random r = new Random();

            for (int i = 0; i < 15; i++) {
                numbers.add(r.nextInt(7)+1);
            }

            double mean = CentralTendency.arithmeticMean(numbers).doubleValue();
            //double median = CentralTendency.median(numbers);
            //ArrayList<Integer> mode = CentralTendency.mode(numbers);

            Collections.sort(numbers);

            String res = String.format("Numbers:\n\n%s\nMean: %.1f\n", numbers, mean);


            tvMain.setText(res);
        }
    };
}
