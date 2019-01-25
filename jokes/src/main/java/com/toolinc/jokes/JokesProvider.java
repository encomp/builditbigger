package com.toolinc.jokes;

import com.google.common.collect.ImmutableList;

import javax.inject.Provider;

/** Joke iterator provider. */
public final class JokesProvider implements Provider<ImmutableList<Joke>> {

  private static final String JSON = "/jokes.json";

  @Override
  public ImmutableList<Joke> get() {
    Jokes jokes = JsonUnmarshallerHelper.toJokes(getClass(), JSON);
    return jokes.jokes();
  }
}
