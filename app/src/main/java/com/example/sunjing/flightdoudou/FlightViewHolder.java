package com.example.sunjing.flightdoudou;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

class FlightViewHolder extends RecyclerView.ViewHolder {

    private final TextView startAirport;
    private final TextView endAirport;

    public FlightViewHolder(View itemView) {
        super(itemView);
        startAirport = itemView.findViewById(R.id.flight_start);
        endAirport = itemView.findViewById(R.id.flight_end);
        itemView.setOnClickListener(view -> {
            CharSequence startAirportText = startAirport.getText();
            CharSequence endAirportText = endAirport.getText();
            Intent intent = new Intent(itemView.getContext(), DetailActivity.class);
            intent.putExtra(DetailActivity.KEY_START, startAirportText);
            intent.putExtra(DetailActivity.KEY_END, endAirportText);
            itemView.getContext().startActivity(intent);
        });
    }

    public void config(Flight flight) {
        startAirport.setText(flight.getStart());
        endAirport.setText(flight.getEnd());
    }
}
