package com.example.ntumba.booksearch.model;

import java.io.Serializable;

/**
 * Created by ntumba on 17-10-31.
 */

public class Book implements Serializable {

    private String libraryId;
    private String author;
    private String title;


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




}
