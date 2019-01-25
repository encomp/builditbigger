package com.toolinc.jokesui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

import com.toolinc.jokes.Joke;

/** Displays a {@link Joke}. */
public final class JokeActivity extends AppCompatActivity {
  public static final String JOKE = "JOKE";
  private TextView mTitle;
  private TextView mQuestion;
  private TextView mAnswer;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_joke);
    Toolbar toolbar = findViewById(R.id.toolbar);
    setSupportActionBar(toolbar);

    mTitle = findViewById(R.id.title);
    mQuestion = findViewById(R.id.question);
    mAnswer = findViewById(R.id.answer);

    Intent intent = getIntent();
    if (intent.hasExtra(JOKE)) {
      Joke joke = (Joke) intent.getSerializableExtra(JOKE);
      mTitle.setText(joke.title());
      mQuestion.setText(joke.question());
      mAnswer.setText(joke.answer());
    }
  }
}
