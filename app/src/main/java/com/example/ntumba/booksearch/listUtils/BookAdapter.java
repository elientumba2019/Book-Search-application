package com.example.ntumba.booksearch.listUtils;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.example.ntumba.booksearch.R;
import com.example.ntumba.booksearch.databinding.BookSingleItemBinding;
import com.example.ntumba.booksearch.model.Book;

import java.util.ArrayList;

/**
 * Created by ntumba on 17-11-2.
 */

public class BookAdapter extends RecyclerView.Adapter<BookViewHolder> {


    private ArrayList<Book> list;
    private Context context;




    public BookAdapter(){}


    /**
     * constructor
     * @param context
     * @param list
     */
    public BookAdapter(Context context , ArrayList<Book> list){
        this.list = list;
        this.context = context;
    }


    /**
     * returns an instance of the view holder
     * @param parent
     * @param viewType
     * @return
     */
    @Override
    public BookViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(context);
        BookSingleItemBinding item = DataBindingUtil.inflate(inflater , R.layout.book_single_item , parent , false);
        return new BookViewHolder(context , item);

    }


    @Override
    public void onBindViewHolder(BookViewHolder holder, int position) {
        holder.bind(list.get(position));
    }


    @Override
    public int getItemCount() {
        return list.size();
    }
}
