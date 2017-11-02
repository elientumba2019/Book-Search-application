package com.example.ntumba.booksearch.model;

import android.text.TextUtils;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by ntumba on 17-10-31.
 */

public class Book implements Serializable {

    private String libraryId;
    private String author;
    private String title;


    public Book(){}


    public Book(String id , String author , String title){
        this.libraryId = id;
        this.author = author;
        this.title = title;
    }


    public String getLibraryId() {
        return libraryId;
    }

    public String getAuthor() {
        return author;
    }

    public String getTitle() {
        return title;
    }



    /**
     * return the sized book cover from cover API
     * @return
     */
    public String getCoverUrl(){
        String url ="http://covers.openlibrary.org/b/olid/" + libraryId + "-M.jpg?default=false";
        return  url;
    }



    /**
     * return the large sized cover from the API
     * @return
     */
    public String getLargeCoverUrl(){
        String url = "http://covers.openlibrary.org/b/olid/" + libraryId + "-L.jpg?default=false";
        return  url;
    }




    /**
     * returns the book object given the JSON object
     * will take the object and deserialize it
     * @param object
     */
    public static Book fromJson(JSONObject object){

        Book book = new Book();

        try{

            //deserialize json into object fields and assign
            //those fields to the book object
            //checks
            if(object.has("cover_edition_key")){
                book.libraryId = object.getString("cover_edition_key");
            }

            else if(object.has("edition_key")){
                final JSONArray ids = object.getJSONArray("edition_key");
                book.libraryId = ids.getString(0);
            }

            book.title = object.has("title_suggest") ? object.getString("title_suggest") : "";
            book.author = getAuthor(object);


        }catch (JSONException e){
            e.printStackTrace();
            return null;
        }

        return book;
    }


    /**
     * given a json object corresponding to the book
     * will retrieve the author of the book
     * or authors separated with commas if there are more than one
     * @param object
     * @return
     */
    public static String getAuthor(JSONObject object){


        try{

            final JSONArray authors = object.getJSONArray("author_name");
            int numberOfAuthors = authors.length();
            final String[] authorStrings = new String[numberOfAuthors];

            //adds the authors from the json object o the string array
            for(int c = 0 ; c < authorStrings.length ; c++){
                authorStrings[c] = authors.getString(c);
            }

            return TextUtils.join("," , authorStrings );

        }catch (JSONException e){
            e.printStackTrace();
            return "";
        }
    }




    /**
     * takes a json array and decodes them into business model
     * by makes individual objects and adding them to an array List
     * @param array
     * @return
     */
    public static ArrayList<Book> fromJson(JSONArray array){

        ArrayList<Book> books = new ArrayList<>(array.length());



            for(int c = 0 ; c < array.length() ; c++){

                JSONObject bookJson = null;

                try{

                    bookJson = array.getJSONObject(c);

                }catch (Exception e){
                    e.printStackTrace();
                    continue;
                }

                Book book = Book.fromJson(bookJson);
                if(book != null){
                    books.add(book);
                }
            }
        return books;
    }





}
