package com.example.rawda.prettychat.data.models;

import android.os.Build;
import android.support.annotation.RequiresApi;

import java.util.ArrayList;
import java.util.Objects;

public class Page {
    private long _id;
    private String name;
    private ArrayList<User> admins;
    private int numberOfLikes;
    private ArrayList<User> followers;
    private ArrayList<Advertisement> advertisements;

    public Page(long _id, String name, ArrayList<User> admins,
                int numberOfLikes, ArrayList<User> followers, ArrayList<Advertisement> advertisements) {
        this._id = _id;
        this.name = name;
        this.admins = admins;
        this.numberOfLikes = numberOfLikes;
        this.followers = followers;
        this.advertisements = advertisements;
    }

    public Page(long _id, String name, ArrayList<User> admins) {
        this._id = _id;
        this.name = name;
        this.admins = admins;
    }

    public long get_id() {
        return _id;
    }

    public void set_id(long _id) {
        this._id = _id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<User> getAdmins() {
        return admins;
    }

    public void setAdmins(ArrayList<User> admins) {
        this.admins = admins;
    }

    public int getNumberOfLikes() {
        return numberOfLikes;
    }

    public void setNumberOfLikes(int numberOfLikes) {
        this.numberOfLikes = numberOfLikes;
    }

    public ArrayList<User> getFollowers() {
        return followers;
    }

    public void setFollowers(ArrayList<User> followers) {
        this.followers = followers;
    }

    public ArrayList<Advertisement> getAdvertisements() {
        return advertisements;
    }

    public void setAdvertisements(ArrayList<Advertisement> advertisements) {
        this.advertisements = advertisements;
    }
    private String adminsStr(){
        StringBuilder admins_st = new StringBuilder();
        for (int i = 0; i < admins.size(); i++) admins_st.append(admins.get(i)).append("\n");
        return admins_st.toString();
    }
    private String followerStr(){
        StringBuilder followers_st = new StringBuilder();
        for (int i = 0; i < followers.size(); i++) followers_st.append(followers.get(i)).append("\n");
        return followers_st.toString();
    }
    private String advertisementStr(){
        StringBuilder ad_st = new StringBuilder();
        for (int i = 0; i < followers.size(); i++) ad_st.append(advertisements.get(i)).append("\n");
        return ad_st.toString();
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Page)) return false;
        Page page = (Page) o;
        return get_id() == page.get_id() &&
                getNumberOfLikes() == page.getNumberOfLikes() &&
                Objects.equals(getName(), page.getName()) &&
                Objects.equals(getAdmins(), page.getAdmins()) &&
                Objects.equals(getFollowers(), page.getFollowers()) &&
                Objects.equals(getAdvertisements(), page.getAdvertisements());
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    public int hashCode() {

        return Objects.hash(get_id(), getName(), getAdmins(), getNumberOfLikes(), getFollowers(), getAdvertisements());
    }

    @Override
    public String toString() {
        return "Page{" +
                "_id=" + _id +
                ", name='" + name + '\'' +
                ", admins=" + adminsStr() +
                ", numberOfLikes=" + numberOfLikes +
                ", followers=" + followerStr() +
                ", advertisements=" + advertisementStr() +
                '}';
    }
}
