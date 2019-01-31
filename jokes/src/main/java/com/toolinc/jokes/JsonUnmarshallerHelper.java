package com.toolinc.jokes;

import com.google.common.annotations.VisibleForTesting;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/** Helper class to unrmashall json files. */
final class JsonUnmarshallerHelper {
  private JsonUnmarshallerHelper() {}

  static final Jokes toJokes(Class clazz, String fileName) {
    try {
      return Jokes.builder().fromJson(toString(clazz, fileName));
    } catch (IOException exception) {
      throw new IllegalStateException("Unable to unmarshal into a step instance.");
    }
  }

  static final Jokes toJokes(String fileName) {
    try {
      return Jokes.builder().fromJson(toString(fileName));
    } catch (IOException exception) {
      throw new IllegalStateException("Unable to unmarshal into a step instance.");
    }
  }

  static final Joke toJoke(Class clazz, String fileName) {
    try {
      return Joke.builder().fromJson(toString(clazz, fileName));
    } catch (IOException exception) {
      throw new IllegalStateException("Unable to unmarshal into a step instance.");
    }
  }

  @VisibleForTesting
  static String toString(Class clazz, String fileName) {
    try {
      URL url = clazz.getResource(fileName);
      Path path = Paths.get(url.toURI());
      return new String(Files.readAllBytes(path), StandardCharsets.UTF_8);
    } catch (URISyntaxException | IOException exception) {
      throw new IllegalStateException("Unable to unmarshal into a json instance.");
    }
  }

  @VisibleForTesting
  static String toString(String fileName) {
    try {
      Path path = Paths.get(new File(fileName).toURI());
      return new String(Files.readAllBytes(path), StandardCharsets.UTF_8);
    } catch (IOException exception) {
      throw new IllegalStateException("Unable to unmarshal into a json instance.", exception);
    }
  }
}
