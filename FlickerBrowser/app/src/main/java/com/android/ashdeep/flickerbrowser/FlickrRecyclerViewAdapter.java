package com.android.ashdeep.flickerbrowser;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.squareup.picasso.Picasso;

import java.util.List;

public class FlickrRecyclerViewAdapter extends RecyclerView.Adapter<FlickrImageViewHolder> {
    private List<Photo>mPhotosList;
    private Context mContext;
    private final String LOG_TAG=FlickrRecyclerViewAdapter.class.getSimpleName();

    public FlickrRecyclerViewAdapter(Context context,List<Photo> mPhotosList) {
        mContext=context;
        this.mPhotosList = mPhotosList;
    }

    @NonNull
    @Override
    public FlickrImageViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view =LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.browse,null);
        FlickrImageViewHolder flickrImageViewHolder=new FlickrImageViewHolder(view);
        return flickrImageViewHolder;
    }

    @Override
    public int getItemCount() {
        return (null!=mPhotosList?mPhotosList.size():0);
    }

    @Override
    public void onBindViewHolder(@NonNull FlickrImageViewHolder flickrImageViewHolder, int position) {
        Photo photoItem=mPhotosList.get(position);
        Log.d(LOG_TAG,"processing"+photoItem.getmTitle()+"----->"+Integer.toString(position));
        Picasso.with(mContext).load(photoItem.getmImage())
                .error(R.drawable.download)
                .placeholder(R.drawable.download)
                .into(flickrImageViewHolder.thumbanil);
        flickrImageViewHolder.title.setText(photoItem.getmTitle());

    }
}
