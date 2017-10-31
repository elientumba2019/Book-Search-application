package com.example.ntumba.booksearch.fragments;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.ntumba.booksearch.R;


/**
 * Created by ntumba on 17-10-31.
 */

public class BookListFragment extends Fragment {



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

        View view = inflater.inflate(R.layout.book_list_fragment_layout , container , false);
        return view;
    }




    /**
     * return an instance of this fragment
     * @return
     */
    public static Fragment getInstance(){
        return new BookListFragment();
    }
}
