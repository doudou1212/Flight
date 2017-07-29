package com.example.sunjing.flightdoudou;

class Flight {

    private final String start;
    private final String end;

    Flight(String start, String end) {

        this.start = start;
        this.end = end;
    }

    public String getStart() {
        return start;
    }

    public String getEnd() {
        return end;
    }
}
