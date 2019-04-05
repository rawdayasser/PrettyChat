package com.example.rawda.prettychat.data.models;

import android.os.Build;
import android.support.annotation.RequiresApi;

import java.util.ArrayList;
import java.util.Date;
import java.util.Objects;

public class Reply {
    protected long _id;
    protected String content;
    protected User owner;
    protected Date date;
    protected boolean edited;
    protected ArrayList<Like> likes;

    public Reply(long _id, String content, User owner, Date date, boolean edited, ArrayList<Like> likes) {
        this._id = _id;
        this.content = content;
        this.owner = owner;
        this.date = date;
        this.edited = edited;
        this.likes = likes;
    }

    public Reply() {
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

    public boolean isEdited() {
        return edited;
    }

    public void setEdited(boolean edited) {
        this.edited = edited;
    }

    public ArrayList<Like> getLikes() {
        return likes;
    }

    public void setLikes(ArrayList<Like> likes) {
        this.likes = likes;
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Reply)) return false;
        Reply reply = (Reply) o;
        return get_id() == reply.get_id() &&
                isEdited() == reply.isEdited() &&
                Objects.equals(getContent(), reply.getContent()) &&
                Objects.equals(getOwner(), reply.getOwner()) &&
                Objects.equals(getDate(), reply.getDate()) &&
                Objects.equals(getLikes(), reply.getLikes());
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    public int hashCode() {

        return Objects.hash(get_id(), getContent(), getOwner(), getDate(), isEdited(), getLikes());
    }
    protected String likesStr(){
        String likes_str = "";
        for (int i = 0; i < likes.size(); i++) likes_str += likes.get(i) + " ";
        return likes_str;
    }

}
