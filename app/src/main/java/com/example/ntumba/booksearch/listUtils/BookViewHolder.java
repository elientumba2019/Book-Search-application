package com.example.ntumba.booksearch.listUtils;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.ntumba.booksearch.databinding.BookSingleItemBinding;

/**
 * Created by ntumba on 17-11-2.
 */

public class BookViewHolder extends RecyclerView.ViewHolder{

    private Context context;
    private BookSingleItemBinding item;



    /**
     * Constructor of the view
     * holder
     * @param context
     * @param item
     */
    public BookViewHolder(Context context , BookSingleItemBinding item) {
        super(item.getRoot());
        this.context = context;
        this.item = item;
    }
}
