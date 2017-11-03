package com.example.ntumba.booksearch.fragments;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.ntumba.booksearch.R;
import com.example.ntumba.booksearch.databinding.BookListFragmentLayoutBinding;
import com.example.ntumba.booksearch.listUtils.BookAdapter;
import com.example.ntumba.booksearch.model.Book;

import java.util.ArrayList;


/**
 * Created by ntumba on 17-10-31.
 */

public class BookListFragment extends Fragment {


    private BookListFragmentLayoutBinding fragment;
    private BookAdapter adapter;



    public BookListFragment(){}


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
        adapter = new BookAdapter(getContext() , new ArrayList<Book>());
        fragment.bookList.setAdapter(adapter);

        return fragment.getRoot();
    }




    /**
     * return an instance of this fragment
     * @return
     */
    public static Fragment getInstance(){
        return new BookListFragment();
    }
}
