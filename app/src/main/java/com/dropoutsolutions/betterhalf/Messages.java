package com.dropoutsolutions.betterhalf;

public class Messages {
    public String date, from, message, time, type, to, messageid, name;

    public Messages() {

    }

    public Messages(String date, String from, String message, String time, String type, String to, String messageid, String name) {
        this.date = date;
        this.from = from;
        this.message = message;
        this.time = time;
        this.type = type;
        this.to = to;
        this.messageid = messageid;
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getMessageid() {
        return messageid;
    }

    public void setMessageid(String messageid) {
        this.messageid = messageid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}