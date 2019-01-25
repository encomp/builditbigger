package com.toolinc.jokes;

import com.google.common.collect.ImmutableList;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.io.IOException;

import static com.google.common.truth.Truth.assertThat;

/** Tests for class {@link JokesProvider}. */
@RunWith(JUnit4.class)
public final class JokesProviderTest {

  @Test
  public void shouldCreateJokes() throws IOException {
    ImmutableList<Joke> jokes = new JokesProvider().get();
    assertThat(jokes.size()).isEqualTo(7);
  }
}
