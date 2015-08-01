package com.codeblast.quartztest;

import javax.inject.Inject;

public class CustomMessager implements Messager {
    @Inject
    public CustomMessager() {
    }

    @Override
    public void sendMessage(String message) {
        System.out.print(message);
    }
}
