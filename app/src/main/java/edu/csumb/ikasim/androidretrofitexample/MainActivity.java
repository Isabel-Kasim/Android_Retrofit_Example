package edu.csumb.ikasim.androidretrofitexample;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import edu.csumb.ikasim.androidretrofitexample.api.BookSearchService;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        Button search_button = findViewById(R.id.searchButton);

        search_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, BookSearchFragment.class);
                startActivity(intent);
            }
        });

    }
    public static Intent newIntent(Context packageContext) {
        Intent intent = new Intent(packageContext, BookSearchResultsAdapter.class);
        return intent;
    }




}