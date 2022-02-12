package edu.csumb.ikasim.androidretrofitexample.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

//this java class waits for a response from the api to see if it yields results, and if so, returns them
public class VolumeResponse {
    @SerializedName("kind")
    @Expose
    private String kind;

    @SerializedName("items")
    @Expose
    List<Volume> items = null; //this is a list because the volumes in the JSON output are nested

    @SerializedName("totalItems")
    @Expose
    int totalItems;

    public String getKind() {
        return kind;
    }

    public List<Volume> getItems() {
        return items;
    }

    public int getTotalItems() {
        return totalItems;
    }
}
