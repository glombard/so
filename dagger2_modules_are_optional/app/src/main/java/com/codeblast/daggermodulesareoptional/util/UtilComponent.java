package com.codeblast.daggermodulesareoptional.util;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component
public interface UtilComponent {
    EventReporter eventReporter();
    LogMessageJoiner logMessageJoiner();
    RandomNumberSupplier randomNumberSupplier();
}
