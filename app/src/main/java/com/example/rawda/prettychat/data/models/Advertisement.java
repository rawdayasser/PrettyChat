package com.example.rawda.prettychat.data.models;

import android.os.Build;
import android.support.annotation.RequiresApi;
import java.util.Date;
import java.util.Objects;

public class Advertisement {
    private long _id;
    private User owner;
    private Post post;
    private long numberOfWatches;
    private Date date;

    public Advertisement(long _id, User owner, Post post, long numberOfWatches, Date date) {
        this._id = _id;
        this.owner = owner;
        this.post = post;
        this.numberOfWatches = numberOfWatches;
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

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    public long getNumberOfWatches() {
        return numberOfWatches;
    }

    public void setNumberOfWatches(long numberOfWatches) {
        this.numberOfWatches = numberOfWatches;
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
        if (!(o instanceof Advertisement)) return false;
        Advertisement that = (Advertisement) o;
        return get_id() == that.get_id() &&
                getNumberOfWatches() == that.getNumberOfWatches() &&
                Objects.equals(getOwner(), that.getOwner()) &&
                Objects.equals(getPost(), that.getPost()) &&
                Objects.equals(getDate(), that.getDate());
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    public int hashCode() {

        return Objects.hash(get_id(), getOwner(), getPost(), getNumberOfWatches(), getDate());
    }

    @Override
    public String toString() {
        return "Advertisement{" +
                "_id=" + _id +
                ", owner=" + owner +
                ", post=" + post +
                ", numberOfWatches=" + numberOfWatches +
                ", date=" + date +
                '}';
    }
}
