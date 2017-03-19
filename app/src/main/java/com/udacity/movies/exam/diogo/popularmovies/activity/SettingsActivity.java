package com.udacity.movies.exam.diogo.popularmovies.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.udacity.movies.exam.diogo.popularmovies.R;
import com.udacity.movies.exam.diogo.popularmovies.presenter.SettingsPresenterImpl;
import com.udacity.movies.exam.diogo.popularmovies.view.SettingsView;

public class SettingsActivity extends AppCompatActivity implements SettingsView {

    SettingsPresenterImpl presenter = new SettingsPresenterImpl(this);

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_settings);

        buildActionBar();

        presenter.onCreate();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();

        this.finish();
    }

    private void buildActionBar() {
        //the return hierarchy is in manifest
       this.getSupportActionBar().setDisplayShowHomeEnabled(true);
       this.getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
}
