package com.app.imagelistapplication;

import com.app.imagelistapplication.model.ImageData;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface MyApi {
    @GET("apod?api_key=DEMO_KEY&count=25")
    Call<List<ImageData>> geImgData();
}