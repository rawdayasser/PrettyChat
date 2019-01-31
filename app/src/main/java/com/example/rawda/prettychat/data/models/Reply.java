package com.example.rawda.prettychat.data.models;

import android.os.Build;
import android.support.annotation.RequiresApi;

import java.util.Date;
import java.util.Objects;

public class Reply extends Comment {
    private long _id;

    public Reply(long _id, String content, User owner, Date date, long post_id, boolean edited) {
        super(content, owner, date, post_id, edited);
    }

    @Override
    public long get_id() {
        return _id;
    }

    @Override
    public void set_id(long _id) {
        this._id = _id;
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Reply)) return false;
        if (!super.equals(o)) return false;
        Reply reply = (Reply) o;
        return get_id() == reply.get_id();
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    public int hashCode() {

        return Objects.hash(super.hashCode(), get_id());
    }

    @Override
    public String toString() {
        return "Reply{" +
                "_id=" + _id +
                '}';
    }
}
