package com.example.sunjing.flightdoudou;

import android.graphics.Color;
import android.support.v7.content.res.AppCompatResources;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sunjing on 7/27/17.
 */

class FlightResultAdapter extends RecyclerView.Adapter<FlightViewHolder> {

    public static final int TYPE_NORMAL = 0;
    public static final int TYPE_BLACK = 1;
    private List<Flight> list;

    public FlightResultAdapter(List<Flight> list) {
        this.list = list;
    }

    public FlightResultAdapter() {
        this(new ArrayList<>());
    }

    @Override
    public int getItemViewType(int position) {
        return position%2 == 0 ? TYPE_NORMAL : TYPE_BLACK;
    }

    @Override
    public FlightViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view;
        if (viewType == TYPE_NORMAL) {
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.flight_list_item_layout, parent, false);
        } else {
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.flight_list_item_black_layout, parent, false);
        }
        return new FlightViewHolder(view);
    }

    @Override
    public void onBindViewHolder(FlightViewHolder holder, int position) {
        holder.config(list.get(position));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public void addFlight(List<Flight> flights) {
        list.addAll(flights);
    }
}
