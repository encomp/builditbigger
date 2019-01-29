package com.udacity.gradle.builditbigger.backend;

public final class MyJoke {

  private final String category;

  private final String title;

  private final String question;

  private final String answer;

  public MyJoke(String category, String title, String question, String answer) {
    this.category = category;
    this.title = title;
    this.question = question;
    this.answer = answer;
  }

  public String getCategory() {
    return category;
  }

  public String getTitle() {
    return title;
  }

  public String getQuestion() {
    return question;
  }

  public String getAnswer() {
    return answer;
  }
}
