package com.example.ntumba.booksearch.activities;

import android.support.v4.app.Fragment;

import com.example.ntumba.booksearch.fragments.BookListFragment;

/**
 * Created by ntumba on 17-10-31.
 */

public class BookListActivty extends SingleMainActivity {


    /**
     * returns the activity fragment
     * @return
     */
    @Override
    public Fragment makeFragment() {
        return BookListFragment.getInstance();
    }
}
