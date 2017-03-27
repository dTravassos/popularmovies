package com.udacity.movies.exam.diogo.popularmovies.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.udacity.movies.exam.diogo.popularmovies.R;
import com.udacity.movies.exam.diogo.popularmovies.model.Movie;

import java.util.List;

public class CustomImageAdapter extends BaseAdapter {

    private Context mContext;

    private List<Movie> items;

    public CustomImageAdapter(Context context, List<Movie> items) {
        this.mContext = context;
        this.items = items;
    }

    @Override
    public int getCount() {
        return items.size() ;
    }

    @Override
    public Object getItem(int position) {
        return items.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if ( convertView == null) {
            convertView = LayoutInflater.from(mContext).inflate(R.layout.movie_item, parent, false);
        }

        Movie movie = items.get(position);

        ImageView posterView = (ImageView) convertView.findViewById(R.id.movie_item_image);

        Glide.with(mContext).load(movie.getPosterUrl()).placeholder(R.drawable.square_placeholder).centerCrop().into(posterView);

        return convertView;
    }

}
