package com.example.wallpaperapp.Modals;

import java.util.ArrayList;

public class wallpapermodal {

    public int total_results;
    public int page;
    public int per_page;
    public ArrayList<Photo> photos;
    public String next_page;


    public wallpapermodal(int total_results, int page, int per_page, ArrayList<Photo> photos, String next_page) {
        this.total_results = total_results;
        this.page = page;
        this.per_page = per_page;
        this.photos = photos;
        this.next_page = next_page;
    }


    public int getTotal_results() {
        return total_results;
    }

    public void setTotal_results(int total_results) {
        this.total_results = total_results;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getPer_page() {
        return per_page;
    }

    public void setPer_page(int per_page) {
        this.per_page = per_page;
    }

    public ArrayList<Photo> getPhotos() {
        return photos;
    }

    public void setPhotos(ArrayList<Photo> photos) {
        this.photos = photos;
    }

    public String getNext_page() {
        return next_page;
    }

    public void setNext_page(String next_page) {
        this.next_page = next_page;
    }
}
