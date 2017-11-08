package com.example.ntumba.booksearch.fragments;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.ntumba.booksearch.R;
import com.example.ntumba.booksearch.databinding.BookDetailFragmentBinding;
import com.example.ntumba.booksearch.model.Book;

/**
 * Created by ntumba on 17-11-8.
 */

public class BookDetailsFragment extends Fragment {


    private static final String ARGUMENT_KEY = "key";


    public BookDetailsFragment(){}




    /**
     * creates the view for the fragment
     * @param inflater
     * @param container
     * @param savedInstanceState
     * @return
     */
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        BookDetailFragmentBinding binding;
        binding = DataBindingUtil.inflate(inflater , R.layout.book_detail_fragment , container , false);
        return  binding.getRoot();
    }





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
