package com.codeblast.dagger1app;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module(injects = PhotosFragment.class)
public class PhotosModule {

    @Provides
    @Singleton
    PhotoManager providePhotoManager() {
        return new PhotoManager();
    }
}
