package com.example.googlenews.controller;

import android.app.Activity;
import android.app.Application;
import android.text.TextUtils;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

public class AppController extends Application {
    public  static final String TAG=AppController.class.getSimpleName();
    private static AppController minstance;
    private RequestQueue requestQueue;

    public static AppController getInstance()
    {
        if(minstance==null)
        {
            synchronized (AppController.class)
            {
                if(minstance==null)
                    minstance=new AppController();
            }
        }
        return minstance;
    }
    @Override
    public void onCreate()
    {
        super.onCreate();
        minstance=this;
    }
    public RequestQueue getRequestQueue()
    {
        if (requestQueue==null)
            requestQueue= Volley.newRequestQueue(getApplicationContext());
        return requestQueue;
    }
    public <T> void addToRequestQueue(Request<T> req, String tag)
    {
        if(TextUtils.isEmpty(tag))
            req.setTag(TAG);
        else
            req.setTag(tag);
        getRequestQueue().add(req);
    }
    public <T> void addToRequestQueue(Request<T> req)
    {
        req.setTag(TAG);
        getRequestQueue().add(req);
    }
    public void cancelPendingRequests(Object tag)
    {
        if(requestQueue!=null)
            requestQueue.cancelAll(tag);
    }
}
