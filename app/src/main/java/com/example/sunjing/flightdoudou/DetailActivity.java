package com.example.sunjing.flightdoudou;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {

    public static final String KEY_START = "start";
    public static final String KEY_END = "end";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        TextView startAirportText = (TextView) findViewById(R.id.flight_start);
        TextView endAirportText = (TextView) findViewById(R.id.flight_end);

        startAirportText.setText(getIntent().getStringExtra(KEY_START));
        endAirportText.setText(getIntent().getStringExtra(KEY_END));
    }
}
