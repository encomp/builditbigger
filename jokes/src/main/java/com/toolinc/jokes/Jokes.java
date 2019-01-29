package com.toolinc.jokes;

import com.google.auto.value.AutoValue;
import com.google.common.collect.ImmutableList;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

import java.io.IOException;
import java.io.Serializable;

/** Specifies a jokes model. */
@AutoValue
abstract class Jokes implements Serializable {

  abstract ImmutableList<Joke> jokes();

  static final Builder builder() {
    return new Builder();
  }

  /** Builder class to instantiate immutable objects of {@link Jokes}. */
  static final class Builder extends TypeAdapter<Jokes> {
    private static final Gson GSON =
        new GsonBuilder().registerTypeAdapter(Joke.class, Joke.builder()).create();

    private Joke[] jokes;

    private Builder() {}

    @Override
    public void write(JsonWriter jsonWriter, Jokes jokes) throws IOException {
      throw new UnsupportedOperationException("This operation is not supported yet...");
    }

    @Override
    public Jokes read(JsonReader jsonReader) throws IOException {
      jokes = GSON.fromJson(jsonReader, Joke[].class);
      return build();
    }

    Jokes build() {
      return new AutoValue_Jokes(ImmutableList.copyOf(jokes));
    }
  }
}
