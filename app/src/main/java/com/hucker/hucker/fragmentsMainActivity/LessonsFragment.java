package com.hucker.hucker.fragmentsMainActivity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hucker.hucker.R;
import com.hucker.hucker.YouTube.YouTubeAdapter;
import com.hucker.hucker.YouTube.YouTubeVideo;

import java.util.Vector;

public class LessonsFragment extends Fragment {
    private RecyclerView recyclerView = null;
    private Vector<YouTubeVideo> youtubeVideos = new Vector<YouTubeVideo>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_lessons, container, false);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

}