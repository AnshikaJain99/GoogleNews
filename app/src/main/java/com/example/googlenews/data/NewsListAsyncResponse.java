package com.example.googlenews.data;

import com.example.googlenews.model.news;

import java.util.ArrayList;

public interface NewsListAsyncResponse {
    void processFinished(ArrayList<news> newsArrayList);
}

