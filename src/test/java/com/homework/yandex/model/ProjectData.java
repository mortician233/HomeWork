package com.homework.yandex.model;

public class ProjectData {
    private String mailSending;
    private String topicLetter;


    public ProjectData withMailSending(String mailSending) {
        this.mailSending = mailSending;
        return this;
    }

    public ProjectData withPassword(String topicLetter) {
        this.topicLetter = topicLetter;
        return this;
    }


    public ProjectData() {

    }

    public String getMailSending() {
        return mailSending;
    }

    public String getTopicLetter() {
        return topicLetter;
    }
}
