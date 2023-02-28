package com.example.weatherapp;

import com.example.weatherapp.Modals.Modal;

import retrofit2.Call;
import retrofit2.http.GET;

public interface API {
    @GET("v1/current.json?key=d4d31304f1c344e6b8755029222812&q=Udaipur&aqi=yes")
        Call<Modal> getallmodal();
}
