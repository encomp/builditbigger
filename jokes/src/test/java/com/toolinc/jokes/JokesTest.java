package com.toolinc.jokes;

import com.google.gson.stream.JsonWriter;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintWriter;

import static com.google.common.truth.Truth.assertThat;

/** Tests for class {@link Jokes}. */
@RunWith(JUnit4.class)
public final class JokesTest {

  private static final String JSON =
      JsonUnmarshallerHelper.toString(JsonUnmarshallerHelperTest.class, "/jokesTest.json");
  private static final JsonWriter JSON_WRITER =
      new JsonWriter(new PrintWriter(new ByteArrayOutputStream(10)));

  @Rule public final ExpectedException expectedException = ExpectedException.none();

  @Test
  public void shouldCreateJokes() throws IOException {
    Jokes jokes = Jokes.builder().fromJson(JSON);
    assertThat(jokes.jokes().size()).isEqualTo(2L);
  }

  @Test
  public void shouldNotCreateJson() throws IOException {
    expectedException.expect(UnsupportedOperationException.class);
    expectedException.expectMessage("supported");
    Jokes.builder().write(JSON_WRITER, Jokes.builder().fromJson(JSON));
  }
}
