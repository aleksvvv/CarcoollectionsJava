package com.example.carcoollectionsjava;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import java.time.temporal.TemporalQueries;
import java.util.Comparator;
import java.util.Set;
import java.util.StringJoiner;
import java.util.TreeSet;

public class MainActivity extends AppCompatActivity {
    private TextView tt;
    private Set<Integer> cars;
    StringBuilder ss;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        cars = new TreeSet<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
//                if (o1>o2){
//                    return 1;
//                } else if (o1<o2)
//                {
//                    return -1;
//                } else {
//                    return 0;
//                }
return o2.compareTo(o1);
            }
        });

        for (int i= 0; i < 100; i++){
            cars.add((int) (Math.random()*10));

            }
        for ( int t : cars){
            Log.d("trest", "t - "+ t);
    }

}
    }