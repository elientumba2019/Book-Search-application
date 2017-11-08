package com.example.ntumba.booksearch.activities;

import android.support.v4.app.Fragment;

import com.example.ntumba.booksearch.fragments.BookDetailsFragment;

/**
 * Created by ntumba on 17-11-8.
 */

public class BookDetailsActivity extends SingleMainActivity {



    /**
     * returns the coresponding fragment
     * @return
     */
    @Override
    public Fragment makeFragment() {
        return BookDetailsFragment.getFragmentinstance();
    }
}
