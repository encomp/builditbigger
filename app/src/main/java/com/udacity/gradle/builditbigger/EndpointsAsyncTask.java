package com.udacity.gradle.builditbigger;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;

import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.google.api.client.googleapis.services.AbstractGoogleClientRequest;
import com.google.api.client.googleapis.services.GoogleClientRequestInitializer;
import com.toolinc.jokesui.Joke;
import com.toolinc.jokesui.JokeActivity;
import com.udacity.gradle.builditbigger.backend.myApi.MyApi;
import com.udacity.gradle.builditbigger.backend.myApi.model.MyJoke;

import java.io.IOException;

public class EndpointsAsyncTask extends AsyncTask<Context, Void, MyJoke> {
  private static MyApi myApiService = null;
  private Context context;

  @Override
  protected MyJoke doInBackground(Context... params) {
    if (myApiService == null) { // Only do this once
      MyApi.Builder builder =
          new MyApi.Builder(AndroidHttp.newCompatibleTransport(), new AndroidJsonFactory(), null)
              .setRootUrl("http://10.0.2.2:8080/_ah/api/")
              .setGoogleClientRequestInitializer(
                  new GoogleClientRequestInitializer() {
                    @Override
                    public void initialize(
                        AbstractGoogleClientRequest<?> abstractGoogleClientRequest)
                        throws IOException {
                      abstractGoogleClientRequest.setDisableGZipContent(true);
                    }
                  });
      myApiService = builder.build();
    }
    context = params[0];
    try {
      return myApiService.joke().execute();
    } catch (IOException e) {
      throw new IllegalStateException(e);
    }
  }

  @Override
  protected void onPostExecute(MyJoke myJoke) {
    Joke joke =
        Joke.builder()
            .setCategory(myJoke.getCategory())
            .setTitle(myJoke.getTitle())
            .setQuestion(myJoke.getQuestion())
            .setAnswer(myJoke.getAnswer())
            .build();
    Intent myIntent = new Intent(context, JokeActivity.class);
    myIntent.putExtra(JokeActivity.JOKE, joke);
    context.startActivity(myIntent);
  }
}
