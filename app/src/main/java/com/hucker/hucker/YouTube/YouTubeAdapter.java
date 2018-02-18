package com.hucker.hucker.YouTube;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.widget.VideoView;

import com.hucker.hucker.R;

import java.util.List;

/**
 * Created by aldor on 18.02.2018.
 */

public class YouTubeAdapter extends RecyclerView.Adapter<YouTubeAdapter.ViewVideoHolder> {
    List<YouTubeVideo> youTubeVideoList;

    public YouTubeAdapter(){}

    public YouTubeAdapter(List<YouTubeVideo> youTubeVideoList) {
        this.youTubeVideoList = youTubeVideoList;
    }

    @Override
    public ViewVideoHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view  = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_video, parent, false);
        return new ViewVideoHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewVideoHolder holder, int position) {
        holder.videoWeb.loadData(youTubeVideoList.get(position).getVideoUrl(), "text/html", "utf-8");
    }

    @Override
    public int getItemCount() {
        return youTubeVideoList.size();
    }

    public class ViewVideoHolder extends RecyclerView.ViewHolder{

        WebView videoWeb;

        public ViewVideoHolder(View itemView){
            super(itemView);

            videoWeb = (WebView)itemView.findViewById(R.id.webViewVideo);
            videoWeb.getSettings().setJavaScriptEnabled(true);
            videoWeb.setWebChromeClient(new WebChromeClient(){

            });
        }
    }
}
