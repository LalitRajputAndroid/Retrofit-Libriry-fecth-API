package com.example.retrofitlibrary;

import com.example.retrofitlibrary.Modals.Modal1;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface API {
    @GET("posts")
    Call<List<Modal1>> getallModal();
}
