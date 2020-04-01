package com.example.googlenews.data;

import android.app.DownloadManager;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.example.googlenews.controller.AppController;
import com.example.googlenews.model.news;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class listofnews {
    private ArrayList<news> newsArrayList = new ArrayList<>();
    final String url="https://newsapi.org/v2/top-headlines?sources=google-news&apiKey=bb54793815df4d7ea0c8f1094d6a0718";
    public ArrayList<news> getNews(final NewsListAsyncResponse callBack)
    {
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url,
                null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        JSONArray jsonArray = null;
                        Log.d("abc","dfhhfg"+response);
                        try {
                            jsonArray = response.getJSONArray("articles");
                            for(int i=0;i<jsonArray.length();i++)
                            {
                                news obj=new news();
                                JSONObject jsonObject = jsonArray.getJSONObject(i);
                                obj.setTitle(jsonObject.getString("title"));
                                obj.setDesc(jsonObject.getString("description"));
                                obj.setImgurl(jsonObject.getString("urlToImage"));
                                obj.setContent(jsonObject.getString("content"));
                                obj.setDescurl(jsonObject.getString("url"));
                                newsArrayList.add(obj);
                                Log.d("pqr","fg"+obj);
                            }
                            Log.d("Hello","fg"+newsArrayList);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        if(callBack!=null)
                            callBack.processFinished(newsArrayList);
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        AppController.getInstance().addToRequestQueue(jsonObjectRequest);
        return newsArrayList;
    }

}
