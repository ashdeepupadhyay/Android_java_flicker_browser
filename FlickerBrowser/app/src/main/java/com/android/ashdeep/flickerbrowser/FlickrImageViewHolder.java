package com.android.ashdeep.flickerbrowser;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class FlickrImageViewHolder extends RecyclerView.ViewHolder {
    protected ImageView thumbanil;
    protected TextView title;

    public FlickrImageViewHolder(@NonNull View itemView) {
        super(itemView);
        this.thumbanil = (ImageView) itemView.findViewById(R.id.thumbnail);
        this.title = (TextView) itemView.findViewById(R.id.title);
    }
}
