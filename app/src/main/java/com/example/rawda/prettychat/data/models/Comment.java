package com.example.rawda.prettychat.data.models;

import android.annotation.TargetApi;
import android.os.Build;
import android.support.annotation.RequiresApi;

import java.util.ArrayList;
import java.util.Date;
import java.util.Objects;

public class Comment {
    private long _id;
    private String content;
    private User owner;
    private Date date;
    private long post_id;
    private boolean edited;
    private ArrayList<Reply> replies;
    private ArrayList<Like> likes;

    public Comment() {
        _id = -1;
        content = "";
        owner = new User();
        date = new Date();
        post_id = -1;
        edited = false;
        replies = new ArrayList<>();
        likes = new ArrayList<>();
    }

    public Comment(long _id, String content, User owner, Date date, long post_id, boolean edited, ArrayList<Reply> replies, ArrayList<Like> likes) {
        this._id = _id;
        this.content = content;
        this.owner = owner;
        this.date = date;
        this.post_id = post_id;
        this.edited = edited;
        this.replies = replies;
        this.likes = likes;
    }

    public Comment(String content, User owner, Date date, long post_id, boolean edited) {
        this.content = content;
        this.owner = owner;
        this.date = date;
        this.post_id = post_id;
        this.edited = edited;
        replies = new ArrayList<>();
        likes = new ArrayList<>();
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

    public long getPost_id() {
        return post_id;
    }

    public void setPost_id(long post_id) {
        this.post_id = post_id;
    }

    public boolean isEdited() {
        return edited;
    }

    public void setEdited(boolean edited) {
        this.edited = edited;
    }

    public ArrayList<Reply> getReplies() {
        return replies;
    }

    public void setReplies(ArrayList<Reply> replies) {
        this.replies = replies;
    }

    public ArrayList<Like> getLikes() {
        return likes;
    }

    public void setLikes(ArrayList<Like> likes) {
        this.likes = likes;
    }

    @TargetApi(Build.VERSION_CODES.KITKAT)
    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Comment)) return false;
        Comment comment = (Comment) o;
        return get_id() == comment.get_id() &&
                getPost_id() == comment.getPost_id() &&
                isEdited() == comment.isEdited() &&
                Objects.equals(getContent(), comment.getContent()) &&
                Objects.equals(getOwner(), comment.getOwner()) &&
                Objects.equals(getDate(), comment.getDate()) &&
                Objects.equals(getReplies(), comment.getReplies()) &&
                Objects.equals(getLikes(), comment.getLikes());
    }

    @TargetApi(Build.VERSION_CODES.KITKAT)
    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    public int hashCode() {

        return Objects.hash(get_id(), getContent(), getOwner(), getDate(), getPost_id(), isEdited(), getReplies(), getLikes());
    }

    @Override
    public String toString() {
        return "Comment{" +
                "_id=" + _id +
                ", content='" + content + '\'' +
                ", owner=" + owner +
                ", date=" + date +
                ", post_id=" + post_id +
                ", edited=" + edited +
                ", replies=" + replies +
                ", likes=" + likes +
                '}';
    }
}
