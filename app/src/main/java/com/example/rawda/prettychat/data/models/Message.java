package com.example.rawda.prettychat.data.models;

import android.os.Build;
import android.support.annotation.RequiresApi;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

public class Message {
    private long _id;
    private String content;
    private Date date;
    private boolean seen;
    private List<User> seenBy;

    public Message() {
        _id = 0;
       content = "";
        date = new Date();
        seen = false;
        seenBy = new ArrayList<>();
    }
    public Message(long _id, User owner, String content, Date date, boolean seen, ArrayList<User> seenBy) {
        this._id = _id;
        this.content = content;
        this.date = date;
        this.seen = seen;
        this.seenBy = seenBy;
    }

    public Message(User owner, String content, Date date) {
       this.content = content;
        this.date = date;
        seenBy = new ArrayList<>();
    }

    public long get_id() {
        return _id;
    }

    public void set_id(long _id) {
        this._id = _id;
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

    public List<User> getSeenBy() {
        return seenBy;
    }

    private String seenByStr(){
        String seenBy_str = "";
        for (int i = 0; i < seenBy.size(); i++) seenBy_str += seenBy.get(i) + "\n";
        return seenBy_str;
    }
    @Override
    public String toString() {
        return "Message{" +
                "_id=" + _id +
               ", content='" + content + '\'' +
                ", date=" + date +
                ", seen=" + seen +
                ", seenBy=" + seenByStr() +
                '}';
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Message)) return false;
        Message message = (Message) o;
        return get_id() == message.get_id() &&
                isSeen() == message.isSeen() &&
                Objects.equals(getContent(), message.getContent()) &&
                Objects.equals(getDate(), message.getDate()) &&
                Objects.equals(getSeenBy(), message.getSeenBy());
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    public int hashCode() {

        return Objects.hash(get_id(), getContent(), getDate(), isSeen(), getSeenBy());
    }
}
