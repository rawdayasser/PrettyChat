package com.example.rawda.prettychat.data.models;

import android.os.Build;
import android.support.annotation.RequiresApi;

import java.util.ArrayList;
import java.util.Date;
import java.util.Objects;

public class Message {
    private long _id;
    private User owner;
    private ArrayList<User> receivers;
    private String content;
    private Date date;
    private boolean seen;
    private ArrayList<User> seenBy;

    public Message() {
        _id = 0;
        owner = new User();
        receivers = new ArrayList<>();
        content = "";
        date = new Date();
        seen = false;
        seenBy = new ArrayList<>();
    }
    public Message(long _id, User owner, ArrayList<User> receivers, String content, Date date, boolean seen, ArrayList<User> seenBy) {
        this._id = _id;
        this.owner = owner;
        this.receivers = receivers;
        this.content = content;
        this.date = date;
        this.seen = seen;
        this.seenBy = seenBy;
    }

    public Message(User owner, String content, Date date) {
        this.owner = owner;
        this.content = content;
        this.date = date;
        receivers = new ArrayList<>();
        seenBy = new ArrayList<>();
    }

    public long get_id() {
        return _id;
    }

    public void set_id(long _id) {
        this._id = _id;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    public ArrayList<User> getReceivers() {
        return receivers;
    }

    public void setReceivers(ArrayList<User> receivers) {
        this.receivers = receivers;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public boolean isSeen() {
        return seen;
    }

    public void setSeen(boolean seen) {
        this.seen = seen;
    }

    public ArrayList<User> getSeenBy() {
        return seenBy;
    }

    public void setSeenBy(ArrayList<User> seenBy) {
        this.seenBy = seenBy;
    }

    @Override
    public String toString() {
        return "Message{" +
                "_id=" + _id +
                ", owner=" + owner +
                ", receivers=" + receivers +
                ", content='" + content + '\'' +
                ", date=" + date +
                ", seen=" + seen +
                ", seenBy=" + seenBy +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Message)) return false;
        Message message = (Message) o;
        return get_id() == message.get_id() &&
                isSeen() == message.isSeen() &&
                Objects.equals(getOwner(), message.getOwner()) &&
                Objects.equals(getReceivers(), message.getReceivers()) &&
                Objects.equals(getContent(), message.getContent()) &&
                Objects.equals(getDate(), message.getDate()) &&
                Objects.equals(getSeenBy(), message.getSeenBy());
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    public int hashCode() {

        return Objects.hash(get_id(), getOwner(), getReceivers(), getContent(), getDate(), isSeen(), getSeenBy());
    }
}
