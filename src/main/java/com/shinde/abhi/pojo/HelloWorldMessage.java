package com.shinde.abhi.pojo;

import java.io.Serializable;

/**
 * Created by user on 7/10/2016.
 */
public class HelloWorldMessage implements Serializable{

    private String message;

    private String from;

    private String to;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    @Override
    public String toString() {
        return "HelloWorldMessage{" +
                "message='" + message + '\'' +
                ", from='" + from + '\'' +
                ", to='" + to + '\'' +
                '}';
    }
}
