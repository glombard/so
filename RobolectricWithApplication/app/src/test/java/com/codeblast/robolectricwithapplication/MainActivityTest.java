package com.codeblast.robolectricwithapplication;

import android.app.Application;
import android.widget.TextView;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.util.ActivityController;

import static org.junit.Assert.assertEquals;
import static org.robolectric.Robolectric.buildActivity;

@RunWith(MyTestRunner.class)
public class MainActivityTest {

  @Test
  public void usesMessageFromProvider() {
    // We use 'withApplication()' to override the activity's application
    // in order to use our TestApp for the test...
    final ActivityController<MainActivity> controller = buildActivity(MainActivity.class)
        .withApplication(new TestApp())       // <-- adding this causes NullPointerException
        .create()                             //     at the .create() step
        .start()
        .resume()
        .visible();
    final MainActivity activity = controller.get();
    TextView message = (TextView) activity.findViewById(R.id.message);
    assertEquals("hi", message.getText());
  }

  public static class TestApp extends Application implements MessageProvider {
    @Override
    public String getMessage() {
      return "hi";
    }
  }
}