package com.example.rawda.prettychat.data.models;

import android.annotation.TargetApi;
import android.os.Build;
import android.support.annotation.RequiresApi;

import java.util.Date;
import java.util.Objects;

public class Like {
    private long _id;
    private User owner;
   private Date date;

    public Like() {
        _id = -1;
        owner = new User();
         date = new Date();
    }

    public Like(long _id, User owner, Comment comment, Post receiverPost, int postOrComment, Date date) {
        this._id = _id;
        this.owner = owner;
        this.date = date;
    }

    public Like(User owner, Comment comment, Post receiverPost, int postOrComment, Date date) {
        this.owner = owner;
        this.date = date;
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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Like)) return false;
        Like like = (Like) o;
        return get_id() == like.get_id() &&
                Objects.equals(getOwner(), like.getOwner()) &&
                Objects.equals(getDate(), like.getDate());
    }

    @TargetApi(Build.VERSION_CODES.KITKAT)
    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    public int hashCode() {

        return Objects.hash(get_id(), getOwner(), getDate());
    }

    @Override
    public String toString() {
        return "Like{" +
                "_id=" + _id +
                ", owner=" + owner +
                ", date=" + date +
                '}';
    }
}
