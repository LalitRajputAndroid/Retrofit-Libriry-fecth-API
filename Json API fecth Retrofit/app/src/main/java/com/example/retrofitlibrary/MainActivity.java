package com.example.retrofitlibrary;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.retrofitlibrary.Modals.Modal1;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    String URL = "https://jsonplaceholder.typicode.com/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerview_id);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));


        //1. retrofit object
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(URL)
                //2.json to GSON object
                    .addConverterFactory(GsonConverterFactory.create())
                .build();

        //3.call of api reference
        API api = retrofit.create(API.class);
        Call<List<Modal1>> call = api.getallModal();

        call.enqueue(new Callback<List<Modal1>>() {
            @Override

            //4. response objectc from retrofit list api

            public void onResponse(Call<List<Modal1>> call, Response<List<Modal1>> response) {
                List<Modal1> mlist = response.body();

                Adapter adapter = new Adapter(mlist);
                recyclerView.setAdapter(adapter);

            }

            @Override
            public void onFailure(Call<List<Modal1>> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Error", Toast.LENGTH_SHORT).show();
            }
        });

    }
}