package com.app.imagelistapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

public class ImageDetailActivity extends AppCompatActivity {

    ImageView detailImageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_detail);
        detailImageView = findViewById(R.id.detailImageView);

        String imageUrl = getIntent().getStringExtra("IMAGE");

        Glide.with(this)
                .load(Uri.parse(imageUrl))
                .apply(new RequestOptions().placeholder(R.drawable.loading))
                .into(detailImageView);
    }
}