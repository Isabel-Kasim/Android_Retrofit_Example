package edu.csumb.ikasim.androidretrofitexample;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button search_button = findViewById(R.id.searchButton);

        search_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(newIntent(MainActivity.this));
            }
        });

    }
    public static Intent newIntent(Context packageContext) {
        Intent intent = new Intent(packageContext, BookSearchFragment.class);
        return intent;
    }




}