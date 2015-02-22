package com.codeblast.dagger;

import android.content.Context;

import dagger.Module;
import dagger.Provides;

@Module(includes = {RootModule.class})
public class UserProfileModule {
  @Provides
  public AccountUtils.UserProfile provideUserProfile(Context context) {
    return AccountUtils.getUserProfile(context);
  }
}