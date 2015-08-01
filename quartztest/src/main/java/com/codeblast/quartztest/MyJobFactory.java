package com.codeblast.quartztest;

import org.quartz.Job;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.simpl.SimpleJobFactory;
import org.quartz.spi.TriggerFiredBundle;

import javax.inject.Inject;

public class MyJobFactory extends SimpleJobFactory {

    private final MyComponent component;

    @Inject
    public MyJobFactory(MyComponent component) {
        this.component = component;
    }

    @Override
    public Job newJob(TriggerFiredBundle bundle, Scheduler scheduler) throws SchedulerException {
        final Job job = super.newJob(bundle, scheduler);
        if (job instanceof MyJob) {
            component.inject((MyJob) job);
        }
        return job;
    }
}
