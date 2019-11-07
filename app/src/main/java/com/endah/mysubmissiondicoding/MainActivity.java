package com.endah.mysubmissiondicoding;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.telecom.Call;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class MainActivity extends AppCompatActivity {
    private RecyclerView rvHistorys;
    private ArrayList<History> list = new ArrayList<>();
    final String STATE_TITLE="state_string";
    final String STATE_LIST="list_state";

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Objects.requireNonNull(getSupportActionBar()).setDisplayShowTitleEnabled(true);


        this.setTitle("Home");

        rvHistorys = findViewById(R.id.rv_historys);
        rvHistorys.setHasFixedSize(true);

        list = new ArrayList<>();

        if (savedInstanceState == null) {
            list.addAll(HistorysData.getListData());
            showRecyclerList();

        }else {
            String stateTitle = savedInstanceState.getString(STATE_TITLE);
            ArrayList<History> stateList = savedInstanceState.getParcelableArrayList(STATE_LIST);
            setActionBarTitle(stateTitle);
            list.addAll(stateList);
        }

    }

    private void showSelectedHistory(History history) {
        Toast.makeText(this, "Kamu memilih" + history.getName(), Toast.LENGTH_SHORT).show();

        Intent detail = new Intent(MainActivity.this, DetailActivity.class);

        detail.putExtra("name", history.getName());
        detail.putExtra("release", history.getRelease());
        detail.putExtra("photo", history.getPhoto());
        detail.putExtra("detail", history.getDetail());
        startActivity(detail);
    }

    private void showRecyclerList() {
        rvHistorys.setLayoutManager(new LinearLayoutManager(this));
        ListHistoryAdapter listHistoryAdapter = new ListHistoryAdapter(list);
        listHistoryAdapter.setListHistory(list);
        rvHistorys.setAdapter(listHistoryAdapter);

        ItemClickSupport.addTo(rvHistorys).setOnItemClickListener(new ItemClickSupport.OnItemClickListener() {
            @Override
            public void onItemClicked(RecyclerView recyclerView, int position, View v) {
                showSelectedHistory(list.get(position));
            }
        });


    }


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        Intent goToAbout = new Intent(MainActivity.this, About.class);
        startActivity(goToAbout);
        return super.onOptionsItemSelected(item);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return super.onCreateOptionsMenu(menu);

    }
    private void setActionBarTitle (String title) {getSupportActionBar().setTitle(title);}

    }


