package com.example.ntumba.booksearch.activities;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;

import com.example.ntumba.booksearch.fragments.BookDetailsFragment;
import com.example.ntumba.booksearch.model.Book;

/**
 * Created by ntumba on 17-11-8.
 */

public class BookDetailsActivity extends SingleMainActivity {


    private static final String INTENT_KEY = "key";


    /**
     * returns the coresponding fragment
     * @return
     */
    @Override
    public Fragment makeFragment() {
        Intent intent = getIntent();
        Book book = (Book) intent.getSerializableExtra(INTENT_KEY);
        return BookDetailsFragment.getFragmentinstance(book);
    }



    /**
     * returns an intent to some activity which will
     * launch this activity
     * @param context
     * @param book
     * @return
     */
    public static Intent getIntent(Context context , Book book){
        Intent intent = new Intent(context , BookDetailsActivity.class);
        intent.putExtra(INTENT_KEY , book);
        return intent;
    }


    /**
     * different signature
     * @param context
     * @return
     */
    public static Intent getIntent(Context context){
        return new Intent(context , BookDetailsActivity.class);
    }
}
