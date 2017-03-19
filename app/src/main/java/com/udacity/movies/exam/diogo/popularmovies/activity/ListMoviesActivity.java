package com.udacity.movies.exam.diogo.popularmovies.activity;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.udacity.movies.exam.diogo.popularmovies.R;
import com.udacity.movies.exam.diogo.popularmovies.presenter.ListMoviesPresenterImpl;
import com.udacity.movies.exam.diogo.popularmovies.view.ListMoviesView;

public class ListMoviesActivity extends AppCompatActivity implements ListMoviesView {

    private static String TAG = ListMoviesActivity.class.getSimpleName();

    ListMoviesPresenterImpl presenter = new ListMoviesPresenterImpl(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_movies);

        Log.d(TAG, "Initializing");

        presenter.onCreate();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_settings:
                Log.d(TAG, "Settings Pressed");

                callSettingsActivity(this);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public void callSettingsActivity(Context context) {
        Intent intent = new Intent(context, SettingsActivity.class);
        context.startActivity(intent);
    }
}
