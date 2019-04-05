package com.example.rawda.prettychat.data.models;

import android.annotation.TargetApi;
import android.os.Build;
import android.support.annotation.RequiresApi;

import java.util.ArrayList;
import java.util.Date;
import java.util.Objects;

public class Post {
    private static long _id = 0;
    private String content;
    private User owner;
    private int accessedBy; // 1->public  2->friends  3->group 4->only me
    private Date date;
    private ArrayList<Comment> comments = new ArrayList<>();
    private ArrayList<Like> likes = new ArrayList<>();
    private int numberOfShares = 0;

   public Post() {
        _id++;
        content = "";
        owner = new User();
        accessedBy = 2;
        date = new Date();
        comments = new ArrayList<>();
        likes = new ArrayList<>();
        numberOfShares = 0;

   }
    public Post( String content, User owner, int accessedBy, Date date, ArrayList<Comment> comments, ArrayList<Like> likes, int numberOfShares) {
        _id++;
        this.content = content;
        this.owner = owner;
        this.accessedBy = accessedBy;
        this.date = date;
        this.comments = comments;
        this.likes = likes;
        this.numberOfShares = numberOfShares;
    }
    public Post(long _id, String content, User owner, int accessedBy, Date date, ArrayList<Comment> comments, ArrayList<Like> likes, int numberOfShares) {
        this._id = _id;
        this.content = content;
        this.owner = owner;
        this.accessedBy = accessedBy;
        this.date = date;
        this.comments = comments;
        this.likes = likes;
        this.numberOfShares = numberOfShares;
    }

    public Post(String content, User owner, int accessedBy, Date date) {
        this.content = content;
        this.owner = owner;
        this.accessedBy = accessedBy;
        this.date = date;
        comments = new ArrayList<>();
        likes = new ArrayList<>();
        numberOfShares = 0;
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

    public int getAccessedBy() {
        return accessedBy;
    }

    public void setAccessedBy(int accessedBy) {
        this.accessedBy = accessedBy;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public ArrayList<Comment> getComments() {
        return comments;
    }

    public void setComments(ArrayList<Comment> comments) {
        this.comments = comments;
    }

    public ArrayList<Like> getLikes() {
        return likes;
    }

    public void setLikes(ArrayList<Like> likes) {
        this.likes = likes;
    }

    public int getNumberOfShares() {
        return numberOfShares;
    }

    public void setNumberOfShares(int numberOfShares) {
        this.numberOfShares = numberOfShares;
    }

    @TargetApi(Build.VERSION_CODES.KITKAT)
    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Post)) return false;
        Post post = (Post) o;
        return get_id() == post.get_id() &&
                getAccessedBy() == post.getAccessedBy() &&
                getNumberOfShares() == post.getNumberOfShares() &&
                Objects.equals(getContent(), post.getContent()) &&
                Objects.equals(getOwner(), post.getOwner()) &&
                Objects.equals(getDate(), post.getDate()) &&
                Objects.equals(getComments(), post.getComments()) &&
                Objects.equals(getLikes(), post.getLikes());
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    public int hashCode() {

        return Objects.hash(get_id(), getContent(), getOwner(), getAccessedBy(), getDate(), getComments(), getLikes(), getNumberOfShares());
    }
    private String commentsStr(){
        String str_comments = "";
        for (int i = 0; i < comments.size(); i++) str_comments += comments.get(i) + " ";
        return  str_comments;
    }
    private String likesStr(){
        String str_likes = "";
        for (int i = 0; i < likes.size(); i++) str_likes += likes.get(i) + " ";
        return str_likes;
    }
    @Override
    public String toString() {
        return "Post{" +
                "_id=" + _id +
                ", content='" + content + '\'' +
                ", owner=" + owner +
                ", accessedBy=" + accessedBy +
                ", date=" + date +
                ", comments=" + commentsStr() +
                ", likes=" + likesStr() +
                ", numberOfShares=" + numberOfShares +
                '}';
    }


}
