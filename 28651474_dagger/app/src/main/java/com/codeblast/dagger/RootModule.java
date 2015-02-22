package com.codeblast.dagger;

import android.content.Context;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module(
    injects = {MainActivity.class},
    library = true,
    complete = false
)
public class RootModule {
  private final Context _context;

  public RootModule(Context context) {
    _context = context;
  }

  @Provides
  @Singleton
  public Context provideApplicationContext() {
    return _context;
  }
}