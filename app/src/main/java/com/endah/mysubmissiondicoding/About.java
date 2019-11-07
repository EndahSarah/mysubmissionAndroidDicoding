package com.endah.mysubmissiondicoding;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

public class About extends AppCompatActivity {

    ImageView img_url;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        getSupportActionBar().setTitle("About");
        img_url = (ImageView) findViewById(R.id.img_url);
        Glide.with(getApplicationContext())
                .load("https://www.dicoding.com/images/small/avatar/201906111254044ad501544b4f3ccf1e13f604733183bf.jpg")
                .placeholder(R.drawable.me)
                .into(img_url);

        img_url.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(view.getContext(), "This My Profile Picture on Dicoding", Toast.LENGTH_SHORT).show();
            }
        });

    }

}
