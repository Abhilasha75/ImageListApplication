package com.app.imagelistapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.app.imagelistapplication.adapter.ImageAdapter;
import com.app.imagelistapplication.model.ImageData;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    RecyclerView imageRecycleView;
    MyApi myApi;
    private List<ImageData> feedList;
    ImageAdapter feedAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageRecycleView = findViewById(R.id.imageListView);
        getdata();
    }
    private void getdata() {
        myApi=RetrofitInstance.getRetrofitInstance().create(MyApi.class);
        Call<List<ImageData>> call=myApi.geImgData();
        call.enqueue(new Callback<List<ImageData>>() {
            @Override
            public void onResponse(Call<List<ImageData>> call, Response<List<ImageData>> response) {
                feedList=response.body();
                feedAdapter=new ImageAdapter(feedList,MainActivity.this);
                imageRecycleView.setAdapter(feedAdapter);
                imageRecycleView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
                feedAdapter.notifyDataSetChanged();

            }

            @Override
            public void onFailure(Call<List<ImageData>> call, Throwable t) {

            }
        });
    }
}