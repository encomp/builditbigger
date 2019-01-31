package com.toolinc.jokes;

import com.google.common.base.Preconditions;
import com.google.common.base.Strings;
import com.google.common.collect.ImmutableList;

import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Provider;

/** Joke iterator provider. */
public final class JokesProvider implements Provider<ImmutableList<Joke>> {

  private final String json;

  @Inject
  public JokesProvider(@Named("JSON_FILE") String jsonFile) {
    Preconditions.checkArgument(!Strings.isNullOrEmpty(jsonFile));
    this.json = jsonFile;
  }

  @Override
  public ImmutableList<Joke> get() {
    Jokes jokes = JsonUnmarshallerHelper.toJokes(json);
    return jokes.jokes();
  }
}
