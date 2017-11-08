package com.example.ntumba.booksearch.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;

import com.example.ntumba.booksearch.model.Book;

/**
 * Created by ntumba on 17-11-8.
 */

public class BookDetailsFragment extends Fragment {


    private static final String ARGUMENT_KEY = "key";


    public BookDetailsFragment(){}


    /**
     * returns an instance of the fragment
     * with its fragment arguments
     * @return
     */
    public static BookDetailsFragment getFragmentinstance(Book book){
        Bundle bundle = new Bundle();
        bundle.putSerializable(ARGUMENT_KEY , book);
        BookDetailsFragment fragment = new BookDetailsFragment();
        fragment.setArguments(bundle);
        return  fragment;
    }
}
