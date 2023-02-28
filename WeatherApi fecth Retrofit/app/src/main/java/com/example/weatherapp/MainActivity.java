package com.example.weatherapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.os.Build;
import android.os.Bundle;
import android.security.NetworkSecurityPolicy;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.weatherapp.Modals.Modal;
import com.squareup.picasso.Picasso;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    String url = "http://api.weatherapi.com/";
    TextView cityname, region, country, localtime, temp_c, textW, tz_id,last_update;
    ImageView img;
    SwipeRefreshLayout refreshLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            NetworkSecurityPolicy.getInstance().isCleartextTrafficPermitted();
        }
        cityname = findViewById(R.id.city_name_id);
        region = findViewById(R.id.region_id);
        country = findViewById(R.id.country_id);
        localtime = findViewById(R.id.localtime_id);
        temp_c = findViewById(R.id.temp_c_id);
        textW = findViewById(R.id.textW_id);
        tz_id = findViewById(R.id.tzidid);
        img = findViewById(R.id.imag_id);
        last_update = findViewById(R.id.lastupdate_id);
        refreshLayout = findViewById(R.id.refresh_id);

        refreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                refresh();
                refreshLayout.setRefreshing(false);
                Toast.makeText(MainActivity.this, "Refreshed", Toast.LENGTH_SHORT).show();
            }
        });


    }
    public void refresh(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        API api = retrofit.create(API.class);
        Call<Modal> listCall = api.getallmodal();

        listCall.enqueue(new Callback<Modal>() {
            @Override
            public void onResponse(Call<Modal> call, Response<Modal> response) {
                Modal modal = response.body();

                cityname.setText(modal.getLocation().getName());
                region.setText(modal.getLocation().getRegion()+",");
                country.setText(modal.getLocation().getCountry());
                localtime.setText(modal.getLocation().getLocaltime());
                temp_c.setText(String.valueOf(modal.getCurrent().getTemp_c())+"\u2103");
                textW.setText(modal.getCurrent().getCondition().getText());
                tz_id.setText(modal.getLocation().getTz_id());
//                Picasso.get().load(modal.getCurrent().getCondition().getIcon()).into(img);
                img.setImageResource(R.drawable.weather_icon);
                last_update.setText("Last Update : "+modal.getCurrent().getLast_updated());

            }

            @Override
            public void onFailure(Call<Modal> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Error" + t.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });

    }
}