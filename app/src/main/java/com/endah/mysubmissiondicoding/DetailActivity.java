package com.endah.mysubmissiondicoding;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        getSupportActionBar().setTitle("Detail");
        grabIntent();
        }

    private void grabIntent() {
        String item_name = getIntent().getStringExtra("name");
        int item_photo = getIntent().getIntExtra("photo", 0);
        String item_release = getIntent().getStringExtra("release");
        String item_detail = getIntent().getStringExtra("detail");

        TextView name = findViewById(R.id.tv_item_name);
        ImageView photo = findViewById(R.id.img_item_photo);
        TextView release  = findViewById(R.id.tv_item_release);
        TextView detail = findViewById(R.id.tv_item_detail);

        name.setText(item_name);
        release.setText(item_release);
        detail.setText(item_detail);


        Glide.with(this)
                .load(item_photo)
                .apply(new RequestOptions().override(150, 220))
                .into(photo);

    }

    public boolean onOptionItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
    }