package com.example.ntumba.booksearch.listUtils;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.example.ntumba.booksearch.R;
import com.example.ntumba.booksearch.activities.BookDetailsActivity;
import com.example.ntumba.booksearch.databinding.BookSingleItemBinding;
import com.example.ntumba.booksearch.model.Book;
import com.squareup.picasso.Picasso;

/**
 * Created by ntumba on 17-11-2.
 */

public class BookViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

    private Context context;
    private BookSingleItemBinding item;
    private Book book;



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
        item.getRoot().setOnClickListener(this);
    }




    /**
     *
     * @param book
     */
    public void bind(Book book){
        this.book = book;
        item.tvTitle.setText(book.getTitle());
        item.tvAuthor.setText(book.getAuthor());
        Picasso.with(context).load(Uri.parse(book.getCoverUrl())).error(R.drawable.no_cover).into(item.ivBookCover);

    }


    /**
     * onClick listener method;
     * @param view
     */
    @Override
    public void onClick(View view) {
        Intent intent = BookDetailsActivity.getIntent(context , book);
        context.startActivity(intent);
    }
}
