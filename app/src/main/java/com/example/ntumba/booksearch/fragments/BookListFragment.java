package com.example.ntumba.booksearch.fragments;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.ntumba.booksearch.R;
import com.example.ntumba.booksearch.databinding.BookListFragmentLayoutBinding;
import com.example.ntumba.booksearch.listUtils.BookAdapter;
import com.example.ntumba.booksearch.model.Book;
import com.example.ntumba.booksearch.network.BookClient;
import com.loopj.android.http.JsonHttpResponseHandler;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import cz.msebera.android.httpclient.Header;


/**
 * Created by ntumba on 17-10-31.
 */

public class BookListFragment extends Fragment {


    private BookListFragmentLayoutBinding fragment;
    private BookAdapter adapter;
    private BookClient client;
    private ArrayList<Book> list = new ArrayList<>();



    public BookListFragment(){}



    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }



    /**
     * sets elements in screen
     * @param inflater
     * @param container
     * @param savedInstanceState
     * @return
     */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {



        fragment = DataBindingUtil.inflate(inflater , R.layout.book_list_fragment_layout , container , false);
        fragment.bookList.setLayoutManager(new LinearLayoutManager(getActivity()));
        adapter = new BookAdapter(getContext() , list);
        fragment.bookList.setAdapter(adapter);


        fetchBooks();
        return fragment.getRoot();
    }



    /**
     * retrieves the books from the Rest Api
     */
    private void fetchBooks(){

        client = new BookClient();
        client.getBooks("oscar Wilde" , new JsonHttpResponseHandler(){

            @Override
            public void onSuccess(int code , Header[] headers , JSONObject response){
                try{

                    JSONArray docs = null;

                    if(response != null){
                        //get docs from json array
                        docs = response.getJSONArray("docs");
                        //parse json array into array of model
                        final ArrayList<Book> books = Book.fromJson(docs);
                        //clear adapter
                        list.clear();
                        //load books

                        refreshList(books);

                    }
                }catch (JSONException exeption){
                    //show error
                    exeption.printStackTrace();
                }
            }
        });
    }




    /**
     * after adding the books in the list
     * put them on screen
     * @param books
     */
    private void refreshList(ArrayList<Book> books) {
        list.addAll(books);
        adapter = new BookAdapter(getActivity() , list);
        fragment.bookList.setAdapter(adapter);
    }


    /**
     * return an instance of this fragment
     * @return
     */
    public static Fragment getInstance(){
        return new BookListFragment();
    }




    /**
     * sets th emenu in screen
     * @param menu
     * @param inflater
     */
    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.menu_book , menu);
    }
}
