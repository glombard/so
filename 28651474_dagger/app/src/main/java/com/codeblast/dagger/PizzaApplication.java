package com.codeblast.dagger;

import android.app.Application;

import dagger.ObjectGraph;

public class PizzaApplication extends Application {
  private ObjectGraph objectGraph;

  @Override
  public void onCreate() {
    super.onCreate();
    objectGraph = ObjectGraph.create(new RootModule(this), new UserProfileModule());
  }

  public void inject(Object object) {
    objectGraph.inject(object);
  }
}
