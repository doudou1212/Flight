package com.example.sunjing.flightdoudou;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import io.reactivex.Flowable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class FlightResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flight_result);

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.flight_list);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        FlightResultAdapter adapter = new FlightResultAdapter();
        recyclerView.setAdapter(adapter);

        Flowable.just(R.raw.flight)
                .map(getResources()::openRawResource)
                .map(InputStreamReader::new)
                .map(v-> new Gson().fromJson(v, new TypeToken<List<Flight>>(){}.getType()))
                .subscribeOn(Schedulers.io())
                .delay(5, TimeUnit.SECONDS)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<Object>() {
                    @Override
                    public void accept(Object o) throws Exception {
                        ProgressBar progressBar = (ProgressBar) findViewById(R.id.bar);
                        progressBar.setVisibility(View.GONE);

                        adapter.addFlight((List<Flight>)o);
                        adapter.notifyDataSetChanged();
                    }
                });

//        perpareData(adapter);
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
