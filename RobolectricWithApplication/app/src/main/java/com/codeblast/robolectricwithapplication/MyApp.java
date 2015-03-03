package com.codeblast.robolectricwithapplication;

import android.app.Application;

public class MyApp extends Application implements MessageProvider {
  @Override
  public String getMessage() {
    return "Hello world!";
  }
}
