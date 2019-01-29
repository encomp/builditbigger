package com.toolinc.jokesui;

import android.support.annotation.NonNull;

import com.google.auto.value.AutoValue;

import java.io.Serializable;

@AutoValue
public abstract class Joke implements Serializable {

  @NonNull
  public abstract String category();

  @NonNull
  public abstract String title();

  @NonNull
  public abstract String question();

  @NonNull
  public abstract String answer();

  public static final Builder builder() {
    return new AutoValue_Joke.Builder();
  }

  /** Builder class to instantiate immutable objects of {@link Joke}. */
  @AutoValue.Builder
  public abstract static class Builder {

    public abstract Builder setCategory(String category);

    public abstract Builder setTitle(String title);

    public abstract Builder setQuestion(String question);

    public abstract Builder setAnswer(String answer);

    public abstract Joke build();
  }
}
