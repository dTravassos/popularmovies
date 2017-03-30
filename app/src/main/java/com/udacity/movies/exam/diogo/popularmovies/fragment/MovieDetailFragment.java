package com.udacity.movies.exam.diogo.popularmovies.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.udacity.movies.exam.diogo.popularmovies.R;
import com.udacity.movies.exam.diogo.popularmovies.constraints.BundleKeys;
import com.udacity.movies.exam.diogo.popularmovies.model.Movie;

public class MovieDetailFragment extends Fragment {

    private static final String TAG = MovieDetailFragment.class.getSimpleName();

    Movie movie;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (savedInstanceState != null) {
            movie = savedInstanceState.getParcelable(BundleKeys.MOVIE_BUNDLED_KEY);
        } else {
            movie = (Movie) getArguments().getParcelable(BundleKeys.MOVIE_BUNDLED_KEY);
        }
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
       savedInstanceState.putParcelable(BundleKeys.MOVIE_BUNDLED_KEY, movie);
       super.onSaveInstanceState(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_detail, container, false);

        ImageView backView = (ImageView) view.findViewById(R.id.detail_poster_image);

        Glide.with(getActivity()).load(movie.getThumbUrl()).centerCrop().into(backView);

        TextView textView = (TextView) view.findViewById(R.id.detail_poster_tittle);
        textView.setText(movie.getOriginal_title());

        TextView textViewS = (TextView) view.findViewById(R.id.detail_synopsis);
        textViewS.setText(movie.getOverview());

        TextView textViewD = (TextView) view.findViewById(R.id.detail_release_date);
        textViewD.setText(movie.getRelease_date());

        RatingBar ratingBar = (RatingBar) view.findViewById(R.id.detail_rating_bar);
        ratingBar.setRating(normalizeRatingValue(movie.getVote_average()));
        ratingBar.setEnabled(false);

        return view;
    }

    private Float normalizeRatingValue(String rating) {
        try {

            return Float.valueOf(rating) / 2;
        } catch(Exception err) {
            Log.e(TAG, err.getMessage());
        }

        return 0f;
    }
}
