package com.example.ntumba.booksearch.fragments;

import android.databinding.DataBindingUtil;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.ntumba.booksearch.R;
import com.example.ntumba.booksearch.databinding.BookDetailFragmentBinding;
import com.example.ntumba.booksearch.model.Book;
import com.example.ntumba.booksearch.network.BookClient;
import com.loopj.android.http.JsonHttpResponseHandler;
import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import cz.msebera.android.httpclient.Header;

/**
 * Created by ntumba on 17-11-8.
 */

public class BookDetailsFragment extends Fragment {


    private static final String ARGUMENT_KEY = "key";
    private Book book;
    private BookClient client;


    public BookDetailsFragment(){}



    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        setHasOptionsMenu(true);
        super.onCreate(savedInstanceState);
        book  = (Book) getArguments().getSerializable(ARGUMENT_KEY);
    }



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

        if(book == null){
            Toast.makeText(getActivity() , "The book details couldn't load" , Toast.LENGTH_LONG).show();
        }
        else{
            loadBook(book , binding);
        }

        return  binding.getRoot();
    }




    /**
     * loads the books details and displays them on screes
     * @param book
     */
    private void loadBook(Book book , BookDetailFragmentBinding binding){

        getActivity().setTitle(book.getTitle());

        Picasso.with(getActivity()).load(Uri.parse(book.getCoverUrl())).error(R.drawable.no_cover).into(binding.ivBookCover);
        binding.tvTitle.setText(book.getTitle());
        binding.tvAuthor.setText(book.getAuthor());


        client = new BookClient();
        client.getExtraBookDetail(book.getLibraryId() , new JsonHttpResponseHandler(){

            @Override
            public void onSuccess(int statusCode , Header[] headers , JSONObject response){

                try{

                    if(response.has("publishers")){
                        //display comma separated list of publishers
                        final JSONArray publisher = response.getJSONArray("publishers");
                        final int numPublichser = publisher.length();

                        final String[] publishers = new String[numPublichser];

                        for(int c = 0 ; c < numPublichser ; c++){
                            publishers[c] = publisher.getString(c);
                        }

                        binding.tvPublisher.setText(TextUtils.join(", " , publishers));
                    }

                    if(response.has("number_of_pages")){
                        binding.tvPageCount.setText(Integer.toString(response.getInt("number_of_pages")) + " pages");
                    }
                }

                catch (JSONException e){
                    e.printStackTrace();
                }
            }

        });



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




    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.menu_book , menu);
    }




    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()){
            case R.id.share :
                setShareIntent();
                break;
        }
    }




    private void setShareIntent(){

    }
}
