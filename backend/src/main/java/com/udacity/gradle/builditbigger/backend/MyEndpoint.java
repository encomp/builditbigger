package com.udacity.gradle.builditbigger.backend;

import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiNamespace;
import com.google.common.collect.ImmutableList;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Key;
import com.google.inject.TypeLiteral;
import com.toolinc.jokes.Joke;

import java.util.Random;

import javax.inject.Named;

/** An endpoint class we are exposing */
@Api(
    name = "myApi",
    version = "v1",
    namespace =
        @ApiNamespace(
            ownerDomain = "backend.builditbigger.gradle.udacity.com",
            ownerName = "backend.builditbigger.gradle.udacity.com",
            packagePath = ""))
public class MyEndpoint {

  private final Injector injector = Guice.createInjector(new MyJokeModule());
  private final ImmutableList<Joke> jokes = getJokes();

  /** A simple endpoint method that takes a name and says Hi back */
  @ApiMethod(name = "sayHi")
  public MyBean sayHi(@Named("name") String name) {
    MyBean response = new MyBean();
    Joke joke = getJokes().get(0);
    response.setData("Hi, " + name + " " + joke);
    return response;
  }

  @ApiMethod(name = "joke")
  public MyJoke joke() {
    Joke joke = jokes.get(getIndex());
    return new MyJoke(joke.category(), joke.title(), joke.question(), joke.answer());
  }

  private int getIndex() {
    Random rand = new Random();
    return rand.nextInt(((jokes.size() - 1) - 0) + 1);
  }

  private ImmutableList<Joke> getJokes() {
    return injector.getInstance(Key.get(new TypeLiteral<ImmutableList<Joke>>() {}));
  }
}
