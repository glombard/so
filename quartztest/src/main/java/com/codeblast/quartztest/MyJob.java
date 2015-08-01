package com.codeblast.quartztest;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import javax.inject.Inject;

public class MyJob implements Job {
    @Inject
    Messager messager;

    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        messager.sendMessage("Hello.");
    }
}
