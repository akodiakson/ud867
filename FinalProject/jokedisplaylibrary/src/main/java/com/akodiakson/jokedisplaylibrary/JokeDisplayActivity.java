package com.akodiakson.jokedisplaylibrary;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class JokeDisplayActivity extends AppCompatActivity {

    private TextView jokeTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_joke_display);

        jokeTextView = (TextView) findViewById(R.id.joke_text_view);

        final Intent intent = getIntent();
        if(intent.hasExtra(IntentConstants.EXTRA_JOKE)){
            String joke = intent.getStringExtra(IntentConstants.EXTRA_JOKE);
            jokeTextView.setText(joke);
        }
    }
}
