package com.example.retrofitsetup;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.retrofitsetup.retrofit.ApiService;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private final String TAG = "MainActivity";

    private RecyclerView recyclerView;
    private ProgressBar progressBar;

    private MainAdapter mainAdapter;
    List<MainModel.Result> results = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setupview();
        setupRecyclerView();
        getDataFromApi();
    }

    private void setupview(){
        recyclerView = findViewById(R.id.recyclerView);
        progressBar = findViewById(R.id.progressBar);
    }

    private void setupRecyclerView(){
        mainAdapter = new MainAdapter(results, new MainAdapter.onAdapterListener() {
            @Override
            public void onClick(MainModel.Result result) {
//                Toast.makeText(MainActivity.this, result.getTitle(), Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(MainActivity.this, DetailActivity.class);
                intent.putExtra("intent_title",result.getTitle());
                intent.putExtra("intent_image",result.getImage());
                startActivity(intent);
            }
        });
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(mainAdapter);
    }


    private void getDataFromApi(){
        progressBar.setVisibility(View.VISIBLE);
    ApiService.endpoint().getData().enqueue(new Callback<MainModel>() {
        @Override
        public void onResponse(Call<MainModel> call, Response<MainModel> response) {
            progressBar.setVisibility(View.GONE);
            if (response.isSuccessful()) {
                List<MainModel.Result> results = response.body().getResult();
                Log.d(TAG,results.toString());
                mainAdapter.setData(results);
            }
        }

        @Override
        public void onFailure(Call<MainModel> call, Throwable t) {
            progressBar.setVisibility(View.GONE);
            Log.d(TAG,t.toString());

        }
    });
    }
}