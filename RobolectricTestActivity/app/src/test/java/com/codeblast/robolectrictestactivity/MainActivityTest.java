package com.codeblast.robolectrictestactivity;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;

@RunWith(MyTestRunner.class)
public class MainActivityTest {
  @Test
  public void fakeActivityTest() {
    MainActivity activity = Robolectric.buildActivity(MainActivity.class)
        .create()
        .resume()
        .get();
  }
}