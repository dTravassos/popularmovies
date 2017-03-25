package com.udacity.movies.exam.diogo.popularmovies.helpers;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.udacity.movies.exam.diogo.popularmovies.R;

public class PreferenceHelper {

    public static String getOrganizeMovieListType(Context context) {
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(context);
        return preferences.getString(context.getResources().getString(R.string.pref_search_type_key),
                context.getResources().getString(R.string.pref_search_popular_value));
    }

}
