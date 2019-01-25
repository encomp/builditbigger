package com.udacity.gradle.builditbigger;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.google.android.gms.ads.MobileAds;
import com.toolinc.jokes.Joke;
import com.toolinc.jokesui.JokeActivity;

public class MainActivity extends AppCompatActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    MobileAds.initialize(this, getString(R.string.ad_app_id));
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

  public void tellJoke(View view) {
    Toast.makeText(this, "derp", Toast.LENGTH_SHORT).show();
    Intent myIntent = new Intent(this, JokeActivity.class);
    myIntent.putExtra(
        JokeActivity.JOKE,
        Joke.builder()
            .setCategory("Category")
            .setTitle("Title")
            .setQuestion("Question")
            .setAnswer("Answer")
            .build());
    startActivity(myIntent);
  }
}
