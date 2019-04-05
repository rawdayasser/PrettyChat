package com.example.rawda.prettychat.data.models;

import android.annotation.TargetApi;
import android.os.Build;
import android.support.annotation.RequiresApi;

import java.util.ArrayList;
import java.util.Date;
import java.util.Objects;

public class Comment extends Reply{

    protected ArrayList<Reply> replies;

    public Comment(long _id, String content, User owner, Date date, boolean edited, ArrayList<Like> likes, ArrayList<Reply> replies) {
        super(_id, content, owner, date, edited, likes);
        this.replies = replies;
    }

    public Comment(ArrayList<Reply> replies) {
        this.replies = replies;
    }

    public Comment() {
    }

    private String repliesStr(){
        String replies_str = "";
        for (int i = 0; i < replies.size(); i++) replies_str += replies.get(i) + " ";
        return replies_str;
    }

    public ArrayList<Reply> getReplies() {
        return replies;
    }

    public void setReplies(ArrayList<Reply> replies) {
        this.replies = replies;
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Comment)) return false;
        if (!super.equals(o)) return false;
        Comment comment = (Comment) o;
        return Objects.equals(getReplies(), comment.getReplies());
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    public int hashCode() {

        return Objects.hash(super.hashCode(), getReplies());
}
}
