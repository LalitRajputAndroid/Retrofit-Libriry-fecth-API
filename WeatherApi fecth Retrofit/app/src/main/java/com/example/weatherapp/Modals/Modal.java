package com.example.weatherapp.Modals;

public class Modal {
    private location location;
    private  current current;

    public Modal() {
    }

    public com.example.weatherapp.Modals.location getLocation() {
        return location;
    }

    public void setLocation(com.example.weatherapp.Modals.location location) {
        this.location = location;
    }

    public com.example.weatherapp.Modals.current getCurrent() {
        return current;
    }

    public void setCurrent(com.example.weatherapp.Modals.current current) {
        this.current = current;
    }
}
