package com.udacity.gradle.builditbigger.backend;

import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiNamespace;
import com.toolinc.jokes.Joke;

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

  /** A simple endpoint method that takes a name and says Hi back */
  @ApiMethod(name = "sayHi")
  public MyBean sayHi(@Named("name") String name) {
    MyBean response = new MyBean();
    Joke joke =
        Joke.builder()
            .setTitle("title")
            .setCategory("category")
            .setAnswer("answer")
            .setQuestion("question")
            .build();
    response.setData("Hi, " + name + " " + joke);
    return response;
  }

  /**
  @ApiMethod(name = "joke")
  public Joke tellJoke() {
    return Joke.builder()
        .setTitle("title")
        .setCategory("category")
        .setAnswer("answer")
        .setQuestion("question")
        .build();
  }**/
}
