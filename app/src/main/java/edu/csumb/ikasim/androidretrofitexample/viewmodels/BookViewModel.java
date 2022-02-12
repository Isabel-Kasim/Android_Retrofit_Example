package edu.csumb.ikasim.androidretrofitexample.viewmodels;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import edu.csumb.ikasim.androidretrofitexample.ApiKeys;
import edu.csumb.ikasim.androidretrofitexample.models.VolumeResponse;
import edu.csumb.ikasim.androidretrofitexample.repositories.BookRepository;

public class BookViewModel extends AndroidViewModel {
    private BookRepository bookRepository;
    private LiveData<VolumeResponse> volumesResponseLiveData;

    public BookViewModel(@NonNull Application application) {
        super(application);
    }

    public void searchVolumes(String keyword, String author) {
        bookRepository.searchVolumes(keyword, author, "GOOGLE_API_KEY");
    }

    public void init() {
        bookRepository = new BookRepository();
        volumesResponseLiveData = bookRepository.getVolumesResponseLiveData();
    }

    public LiveData<VolumeResponse> getVolumesResponseLiveData() {
        return volumesResponseLiveData;
    }
}
