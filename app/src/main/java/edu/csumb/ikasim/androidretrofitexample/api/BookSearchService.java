package edu.csumb.ikasim.androidretrofitexample.api;

import edu.csumb.ikasim.androidretrofitexample.models.VolumeResponse;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface BookSearchService {
    @GET("/books/v1/volumes") // retrieve the info using the api link
    Call<VolumeResponse> searchVolumes(
            @Query("q") String query, //queries here are for user input that will be passed through
            @Query("inauthor") String author,
            @Query("key") String apiKey
    );
}
