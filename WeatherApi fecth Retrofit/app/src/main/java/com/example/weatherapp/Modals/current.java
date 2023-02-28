package com.example.weatherapp.Modals;

public class current {
    private String last_updated;
    private double temp_c;
    private condition condition;

    public current() {
    }

    public String getLast_updated() {
        return last_updated;
    }

    public void setLast_updated(String last_updated) {
        this.last_updated = last_updated;
    }

    public double getTemp_c() {
        return temp_c;
    }

    public void setTemp_c(double temp_c) {
        this.temp_c = temp_c;
    }

    public com.example.weatherapp.Modals.condition getCondition() {
        return condition;
    }

    public void setCondition(com.example.weatherapp.Modals.condition condition) {
        this.condition = condition;
    }
}
