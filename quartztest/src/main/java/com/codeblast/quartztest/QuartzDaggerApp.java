package com.codeblast.quartztest;

import org.quartz.SchedulerException;

import java.io.IOException;

public class QuartzDaggerApp {
    public static void main(String[] args) throws SchedulerException, IOException {
        System.out.println("testing Quartz with Dagger 2");

        MyComponent component = DaggerMyComponent.create();

        MyJobScheduler myJobScheduler = component.getMyJobScheduler();

        myJobScheduler.scheduleJob();

        System.in.read();
    }
}
