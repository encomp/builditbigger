package com.toolinc.jokes;

import com.google.auto.value.AutoValue;
import com.google.common.base.Preconditions;
import com.google.common.base.Strings;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

import java.io.IOException;
import java.io.Serializable;

import javax.annotation.Nonnull;

/** Specifies a joke model. */
@AutoValue
public abstract class Joke implements Serializable {

  public abstract String category();

  public abstract String title();

  public abstract String question();

  public abstract String answer();

  @Nonnull
  public static final Builder builder() {
    return new Builder();
  }

  /** Builder class to instantiate immutable objects of {@link Joke}. */
  public static final class Builder extends TypeAdapter<Joke> {
    private static final Gson GSON = new Gson();

    @SerializedName("category")
    private String category;

    @SerializedName("title")
    private String title;

    @SerializedName("question")
    private String question;

    @SerializedName("answer")
    private String answer;

    private Builder() {}

    public Builder setCategory(String category) {
      Preconditions.checkArgument(!Strings.isNullOrEmpty(category));
      this.category = category;
      return this;
    }

    public Builder setTitle(String title) {
      Preconditions.checkArgument(!Strings.isNullOrEmpty(title));
      this.title = title;
      return this;
    }

    public Builder setQuestion(String question) {
      Preconditions.checkArgument(!Strings.isNullOrEmpty(question));
      this.question = question;
      return this;
    }

    public Builder setAnswer(String answer) {
      Preconditions.checkArgument(!Strings.isNullOrEmpty(answer));
      this.answer = answer;
      return this;
    }

    @Override
    public void write(JsonWriter jsonWriter, Joke joke) throws IOException {
      throw new UnsupportedOperationException("This operation is not supported yet...");
    }

    @Override
    public Joke read(JsonReader jsonReader) throws IOException {
      Builder builder = GSON.fromJson(jsonReader, Builder.class);
      return builder.build();
    }

    public Joke build() {
      return new AutoValue_Joke(category, title, question, answer);
    }
  }
}
