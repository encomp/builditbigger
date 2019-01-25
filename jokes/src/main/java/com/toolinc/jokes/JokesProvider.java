package com.toolinc.jokes;

import java.util.Iterator;

import javax.inject.Provider;

/** Joke iterator. */
public final class JokesProvider implements Provider<Iterator<Joke>> {

  private static final String JSON = "/jokes.json";

  @Override
  public Iterator<Joke> get() {
    Jokes jokes = JsonUnmarshallerHelper.toJokes(getClass(), JSON);
    return jokes.jokes().iterator();
  }
}
