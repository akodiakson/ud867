package com.udacity.gradle.builditbigger;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.akodiakson.jokedisplaylibrary.IntentConstants;
import com.akodiakson.jokedisplaylibrary.JokeDisplayActivity;
import com.akodiakson.jokeprovider.IJokeProvider;
import com.akodiakson.jokeprovider.JokeProvider;


public class MainActivity extends AppCompatActivity {

    private IJokeProvider jokeProvider;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        jokeProvider = new JokeProvider();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void tellJoke(View view){
        final String joke = jokeProvider.getJoke();
        Intent intent = new Intent(this, JokeDisplayActivity.class);
        intent.putExtra(IntentConstants.EXTRA_JOKE, joke);
        startActivity(intent);
    }


}
