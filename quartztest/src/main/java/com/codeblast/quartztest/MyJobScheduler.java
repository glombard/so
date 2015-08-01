package com.codeblast.quartztest;

import org.quartz.*;

import javax.inject.Inject;

public class MyJobScheduler {

    private final Scheduler scheduler;

    @Inject
    public MyJobScheduler(Scheduler scheduler, MyJobFactory myJobFactory) {
        this.scheduler = scheduler;
        try {
            this.scheduler.setJobFactory(myJobFactory);
        } catch (SchedulerException e) {
            e.printStackTrace();
        }
    }

    public void scheduleJob() throws SchedulerException {
        JobDetail myJob = JobBuilder.newJob(MyJob.class)
                .withIdentity("myJobId", "Group1")
                .build();

        Trigger trigger = TriggerBuilder.newTrigger()
                .withIdentity("myTriggerId", "Group1")
                .startNow()
                .build();

        scheduler.start();
        scheduler.scheduleJob(myJob, trigger);
    }
}
