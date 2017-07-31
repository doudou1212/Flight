package com.example.sunjing.flightdoudou;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        View view = findViewById(R.id.flight_main);


        view.setOnClickListener(view2 -> {
            Intent intent = new Intent(view.getContext(), FlightResultActivity.class);
            view.getContext().startActivity(intent);
        });


    }
}
