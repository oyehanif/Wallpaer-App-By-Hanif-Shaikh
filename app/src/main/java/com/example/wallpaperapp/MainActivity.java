package com.example.wallpaperapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.os.RecoverySystem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.wallpaperapp.Modals.Photo;
import com.example.wallpaperapp.Modals.wallpapermodal;

import java.util.ArrayList;
import java.util.Locale;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    WallpaperAdepter adepter;
    ArrayList<Photo> photoArrayList;
    EditText editText;
    ImageButton search;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();

        recyclerView = findViewById(R.id.recyclerView);
        editText = findViewById(R.id.editText);
        search = findViewById(R.id.searchBtn);
        photoArrayList = new ArrayList<>();

        adepter =new WallpaperAdepter(getApplicationContext(),photoArrayList);
        recyclerView.setLayoutManager(new GridLayoutManager(this,2));
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(adepter);

        getwallpapers();

        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               String query = editText.getText().toString().trim().toLowerCase();
                if (query.isEmpty()){
                    Toast.makeText(getApplicationContext(), "Enter Somthing!!", Toast.LENGTH_SHORT).show();
                }else {
                    getSerchWallpaper(query);
                }
            }
        });

    }

    private void getSerchWallpaper(String query) {

        ApiUtilities.getApiInterface().getSearchWallpaper(query,"80").enqueue(new Callback<wallpapermodal>() {
            @Override
            public void onResponse(Call<wallpapermodal> call, Response<wallpapermodal> response) {
                photoArrayList.clear();
                if (response.isSuccessful()){
                    photoArrayList.addAll(response.body().photos);
                    adepter.notifyDataSetChanged();
                }
            }

            @Override
            public void onFailure(Call<wallpapermodal> call, Throwable t) {

                Toast.makeText(getApplicationContext(), t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void getwallpapers() {

        ApiUtilities.getApiInterface().getWallpaper("80").enqueue(new Callback<wallpapermodal>() {
            @Override
            public void onResponse(Call<wallpapermodal> call, Response<wallpapermodal> response) {
                if (response.isSuccessful()){
                    photoArrayList.addAll(response.body().photos);
                    adepter.notifyDataSetChanged();

                }
            }

            @Override
            public void onFailure(Call<wallpapermodal> call, Throwable t) {

                Toast.makeText(getApplicationContext(), t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}