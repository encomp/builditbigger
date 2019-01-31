package com.udacity.gradle.builditbigger.backend;

import com.google.common.collect.ImmutableList;
import com.google.inject.AbstractModule;
import com.google.inject.Key;
import com.google.inject.Provides;
import com.google.inject.TypeLiteral;
import com.toolinc.jokes.Joke;
import com.toolinc.jokes.JokesProvider;

import javax.inject.Named;
import javax.inject.Singleton;

public final class MyJokeModule extends AbstractModule {

  @Override
  protected void configure() {
    bind(Key.get(new TypeLiteral<ImmutableList<Joke>>() {})).toProvider(JokesProvider.class);
  }

  @Provides
  @Singleton
  @Named("JSON_FILE")
  String providesJsonFile() {
    return "WEB-INF/jokes.json";
  }
}
