package com.example.rawda.prettychat.data.models;

import android.annotation.TargetApi;
import android.os.Build;
import android.support.annotation.RequiresApi;

import java.util.Date;
import java.util.Objects;

public class Like {
    private long _id;
    private User owner;
    private Comment receiverComment;
    private Post receiverPost;
    private int postOrComment;
    private Date date;

    public Like() {
        _id = -1;
        owner = new User();
        receiverComment = new Comment();
        receiverPost = new Post();
        postOrComment = 1;
        date = new Date();
    }

    public Like(long _id, User owner, Comment receiverComment, Post receiverPost, int postOrComment, Date date) {
        this._id = _id;
        this.owner = owner;
        this.receiverComment = receiverComment;
        this.receiverPost = receiverPost;
        this.postOrComment = postOrComment;
        this.date = date;
    }

    public Like(User owner, Comment receiverComment, Post receiverPost, int postOrComment, Date date) {
        this.owner = owner;
        this.receiverComment = receiverComment;
        this.receiverPost = receiverPost;
        this.postOrComment = postOrComment;
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

    public Comment getReceiverComment() {
        return receiverComment;
    }

    public void setReceiverComment(Comment receiverComment) {
        this.receiverComment = receiverComment;
    }

    public Post getReceiverPost() {
        return receiverPost;
    }

    public void setReceiverPost(Post receiverPost) {
        this.receiverPost = receiverPost;
    }

    public int getPostOrComment() {
        return postOrComment;
    }

    public void setPostOrComment(int postOrComment) {
        this.postOrComment = postOrComment;
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
                getPostOrComment() == like.getPostOrComment() &&
                Objects.equals(getOwner(), like.getOwner()) &&
                Objects.equals(getReceiverComment(), like.getReceiverComment()) &&
                Objects.equals(getReceiverPost(), like.getReceiverPost()) &&
                Objects.equals(getDate(), like.getDate());
    }

    @TargetApi(Build.VERSION_CODES.KITKAT)
    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    public int hashCode() {

        return Objects.hash(get_id(), getOwner(), getReceiverComment(), getReceiverPost(), getPostOrComment(), getDate());
    }

    @Override
    public String toString() {
        return "Like{" +
                "_id=" + _id +
                ", owner=" + owner +
                ", receiverComment=" + receiverComment +
                ", receiverPost=" + receiverPost +
                ", postOrComment=" + postOrComment +
                ", date=" + date +
                '}';
    }
}
