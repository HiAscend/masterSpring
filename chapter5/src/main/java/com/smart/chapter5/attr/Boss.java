package com.smart.chapter5.attr;

import java.util.*;

/**
 * Boss
 * Created by ascend on 2017/9/29 16:19.
 */
public class Boss {
    private String name;
    private int age;
    private Car car = new Car();
    private Map jobs = new HashMap();
    private Properties mails = new Properties();
    private Map<String, Integer> jobTime = new HashMap<>();
    private Set favorites = new HashSet();

    public Boss() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public Map getJobs() {
        return jobs;
    }

    public void setJobs(Map jobs) {
        this.jobs = jobs;
    }

    public Properties getMails() {
        return mails;
    }

    public void setMails(Properties mails) {
        this.mails = mails;
    }

    public Map<String, Integer> getJobTime() {
        return jobTime;
    }

    public void setJobTime(Map<String, Integer> jobTime) {
        this.jobTime = jobTime;
    }

    public Set getFavorites() {
        return favorites;
    }

    public void setFavorites(Set favorites) {
        this.favorites = favorites;
    }

    @Override
    public String toString() {
        return "Boss{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", car=" + car +
                ", jobs=" + jobs +
                ", mails=" + mails +
                ", jobTime=" + jobTime +
                ", favorites=" + favorites +
                '}';
    }
}
