package com.qf.test;

import org.quartz.JobKey;
import org.quartz.Matcher;
import org.quartz.impl.StdScheduler;
import org.quartz.impl.matchers.GroupMatcher;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestQuartz {
    public static void main(String[] args) throws Exception{

        ClassPathXmlApplicationContext applicationContext =
                new ClassPathXmlApplicationContext("applicationContext.xml");

        StdScheduler scheduler = (StdScheduler)applicationContext.getBean("scheduler");

        Thread.sleep(3000);

        //删除任务
        //scheduler.deleteJob(JobKey.jobKey("myjob","mygroup"));

        //暂定任务
        //scheduler.pauseJob(JobKey.jobKey("myjob","mygroup"));
        //System.out.println("-----------------------------");
        //Thread.sleep(7000);
        //继续任务
        //scheduler.resumeJob(JobKey.jobKey("myjob","mygroup"));

        //批量操作
        GroupMatcher<JobKey> groupMatcher = GroupMatcher.groupEquals("mygroup");
        scheduler.pauseJobs(groupMatcher);
        Thread.sleep(7000);
        scheduler.resumeJobs(groupMatcher);
    }
}
