package com.example.ntumba.booksearch.network;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/**
 * Created by ntumba on 17-10-31.
 */

public class BookClient {

    private static final String API_BASE_URL = "http://openlibrary.org/";
    private AsyncHttpClient client;


    /**
     * constructor
     */
    public BookClient(){
        this.client = new AsyncHttpClient();
    }





    /**
     * return the api url
     * @param relativeUrl
     * @return
     */
    public String getApiUrl(String relativeUrl){
        return API_BASE_URL + relativeUrl;
    }




    /**
     * method fo accessing the search
     * @param query
     * @param handler
     */
    public void getBooks(final String query , JsonHttpResponseHandler handler){
        try{

            String url = getApiUrl("search.json?q=");
            client.get(url + URLEncoder.encode(query , "utf-8") , handler);

        }catch (UnsupportedEncodingException e){
            e.printStackTrace();
        }
    }
}

