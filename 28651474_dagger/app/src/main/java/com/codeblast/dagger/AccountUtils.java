package com.codeblast.dagger;

import android.content.Context;
import android.util.Log;

public class AccountUtils {
  public static AccountUtils.UserProfile getUserProfile(Context context) {
    return new UserProfile(context);
  }

  public static class UserProfile {
    public UserProfile(Context context) {
    }

    public void message() {
      Log.d("UserProfile", "Hi from UserProfile!");
    }
  }
}
