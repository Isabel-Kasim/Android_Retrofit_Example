package edu.csumb.ikasim.androidretrofitexample.repositories;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import edu.csumb.ikasim.androidretrofitexample.api.BookSearchService;
import edu.csumb.ikasim.androidretrofitexample.models.VolumeResponse;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.converter.gson.GsonConverterFactory;


//this class will be used when the user clicks the search button. It'll consume the api here.
public class BookRepository {
    private static final String BOOK_SEARCH_SERVICE_BASE_URL = "https://www.googleapis.com/";

    private BookSearchService bookSearchService;
    private MutableLiveData<VolumeResponse> volumesResponseLiveData;

    //method to act as a mediator to catch new changing Live data
    public BookRepository() {
        volumesResponseLiveData = new MutableLiveData<>();

        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(interceptor).build();

        bookSearchService = new retrofit2.Retrofit.Builder() //retrofit here will take the api, create a middle client, take the JSON files, use the Gson converter library, build it, then fill in the details in BookSearchService
                .baseUrl(BOOK_SEARCH_SERVICE_BASE_URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(BookSearchService.class);

    }

    //this is a handler to find exceptions and values of the response, if pass, the value of the code will be posted.
    public void searchVolumes(String keyword, String author, String apiKey) {
        bookSearchService.searchVolumes(keyword, author, apiKey)
                .enqueue(new Callback<VolumeResponse>() {
                    @Override
                    public void onResponse(Call<VolumeResponse> call, Response<VolumeResponse> response) {
                        if (response.body() != null) {
                            volumesResponseLiveData.postValue(response.body());
                        }
                    }

                    @Override
                    public void onFailure(Call<VolumeResponse> call, Throwable t) {
                        volumesResponseLiveData.postValue(null);
                    }
                });
    }

    //getter method
    public LiveData<VolumeResponse> getVolumesResponseLiveData() {
        return volumesResponseLiveData;
    }
}
