package com.example.sunjing.flightdoudou;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.flight_list);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        FlightResultAdapter adapter = new FlightResultAdapter();
        recyclerView.setAdapter(adapter);

        perpareData(adapter);
    }

    private void perpareData(FlightResultAdapter adapter) {
        List<Flight> list = createFlights();
        adapter.addFlight(list);
        adapter.notifyDataSetChanged();
    }

    @NonNull
    private List<Flight> createFlights() {
        List<Flight> list = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            list.add(new Flight("A", "i" + i));
        }
        return list;
    }
}
