package com.udacity.movies.exam.diogo.popularmovies.activity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.GridView;
import android.widget.Toast;

import com.github.clans.fab.FloatingActionButton;
import com.github.clans.fab.FloatingActionMenu;
import com.udacity.movies.exam.diogo.popularmovies.R;
import com.udacity.movies.exam.diogo.popularmovies.adapter.CustomImageAdapter;
import com.udacity.movies.exam.diogo.popularmovies.constraints.BundleKeys;
import com.udacity.movies.exam.diogo.popularmovies.listeners.FloatingMenuListener;
import com.udacity.movies.exam.diogo.popularmovies.listeners.GridViewOnItemClickListener;
import com.udacity.movies.exam.diogo.popularmovies.model.Movie;
import com.udacity.movies.exam.diogo.popularmovies.presenter.ListMoviesPresenterImpl;
import com.udacity.movies.exam.diogo.popularmovies.view.ListView;

import java.util.List;

public class ListMoviesActivity extends AppCompatActivity implements ListView {

    private static String TAG = ListMoviesActivity.class.getSimpleName();

    ListMoviesPresenterImpl presenter = new ListMoviesPresenterImpl(this);

    GridView gridView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_movies);

        initializeFloatingButtonsListeners();

        Log.d(TAG, "Initializing");

        presenter.onCreate();
    }

    public void loadImageAdapter(List<Movie> movies) {
        gridView = (GridView) this.findViewById(R.id.movei_grid_view);
        gridView.setAdapter(new CustomImageAdapter(this, movies));
        gridView.setOnItemClickListener(new GridViewOnItemClickListener(this));
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

    public void alertGenericError() {
        Toast toast = Toast.makeText(this, R.string.api_generic_error, Toast.LENGTH_LONG);
        toast.show();
    }

    public void internetLostDialog() {
        new AlertDialog.Builder(this)
                .setTitle(R.string.dialog_title_internet_connection)
                .setMessage(R.string.dialog_content_internet_connection)
                .setPositiveButton((R.string.dialog_option_try_again), new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        presenter.loadView();
                    }
                })
                .setNegativeButton(R.string.dialog_option_close_app, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                        System.exit(0);
                    }
                })
                .show();
    }

    public void callSettingsActivity(Context context) {
        Intent intent = new Intent(context, SettingsActivity.class);
        context.startActivity(intent);
    }

    public void callMovieDetailActivity(Movie movie) {
        Bundle bundle = new Bundle();
        bundle.putSerializable(BundleKeys.MOVIE_BUNDLED_KEY, movie);

        Intent intent = new Intent(ListMoviesActivity.this, MovieDetailActivity.class);
        intent.putExtras(bundle);

        startActivity(intent);
    }

    private void initializeFloatingButtonsListeners() {
        final FloatingActionMenu menu = (FloatingActionMenu) findViewById(R.id.menu_floating);
        final FloatingActionButton btnTop = (FloatingActionButton) findViewById(R.id.menu_item_top_rated);
        final FloatingActionButton btnPopular = (FloatingActionButton) findViewById(R.id.menu_item_most_popular);

        btnTop.setOnClickListener(new FloatingMenuListener(menu, presenter));
        btnPopular.setOnClickListener(new FloatingMenuListener(menu, presenter));
    }



}
