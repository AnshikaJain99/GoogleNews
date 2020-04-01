package com.example.googlenews;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.googlenews.data.NewsListAsyncResponse;
import com.example.googlenews.data.listofnews;
import com.example.googlenews.model.news;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private TextView titleview;
    private TextView contentview;
    private TextView descview;
    private ImageView iv;
    private Button b1;
    private Button b2;
    private ArrayList<news> newsList;
    private int curr=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        titleview = findViewById(R.id.title);
        contentview = findViewById(R.id.content);
        descview = findViewById(R.id.desc);
        iv = findViewById(R.id.image);
        b1 = findViewById(R.id.button);
        b2 = findViewById(R.id.button1);
        b2.setOnClickListener(this);
        b1.setOnClickListener(this);
        titleview.setOnClickListener(this);
        contentview.setOnClickListener(this);
        descview.setOnClickListener(this);
        iv.setOnClickListener(this);

        newsList = new listofnews().getNews(new NewsListAsyncResponse() {
            @Override
            public void processFinished(ArrayList<news> newsArrayList) {
                Picasso.get().load(newsArrayList.get(curr).getImgurl()).into(iv);
                titleview.setText(newsArrayList.get(curr).getTitle());
                contentview.setText(newsArrayList.get(curr).getContent());
                descview.setText(newsArrayList.get(curr).getDesc());
            }
        });

    }

    @Override
    public void onClick(View v) {
        Uri uri;
        Intent intent;
        switch (v.getId())
        {
            case R.id.button:
                curr=(curr+1) % newsList.size();
                Picasso.get().load(newsList.get(curr).getImgurl()).into(iv);
                titleview.setText(newsList.get(curr).getTitle());
                contentview.setText(newsList.get(curr).getContent());
                descview.setText(newsList.get(curr).getDesc());
                break;
            case R.id.button1:
                if(curr==0)
                    curr=1;
                curr=(curr-1) % newsList.size();
                Picasso.get().load(newsList.get(curr).getImgurl()).into(iv);
                titleview.setText(newsList.get(curr).getTitle());
                contentview.setText(newsList.get(curr).getContent());
                descview.setText(newsList.get(curr).getDesc());
                break;
            case R.id.image:
                uri = Uri.parse(newsList.get(curr).getImgurl());
                intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
                break;
            case R.id.title:
                uri = Uri.parse(newsList.get(curr).getDescurl());
                intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
                break;
            case R.id.content:
                uri = Uri.parse(newsList.get(curr).getDescurl());
                intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
        }

    }

}