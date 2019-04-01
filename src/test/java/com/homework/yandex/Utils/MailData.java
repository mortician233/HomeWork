package com.homework.yandex.Utils;

public class MailData {


    private String mailSending;
    private String topicLetter;


    public MailData(String mailSending, String topicLetter) {
        this.mailSending = mailSending;
        this.topicLetter = topicLetter;
    }


    public String getMailSending() {
        return mailSending;
    }

    public String getTopicLetter() {
        return topicLetter;
    }
}
