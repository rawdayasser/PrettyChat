package com.example.rawda.prettychat.data.models;

import android.annotation.TargetApi;
import android.os.Build;
import android.support.annotation.RequiresApi;

import java.util.ArrayList;
import java.util.Date;
import java.util.Objects;

public class User {
    private long _id;
    private String fName;
    private String lName;
    private String email;
    private String userName;
    private String password;
    private Date birthDate;
    private String phone_number;
    private String address;
    private ArrayList<Message> messages;
    private ArrayList<Like> likes;

    public User() {
        fName = "";
        lName = "";
        email = "";
        userName = "";
        password = "";
        birthDate = new Date();
        phone_number = "";
        address = "";
    }
    public User(long _id, String fName, String lName, String email, String userName,
                String password, Date birthDate, String phone_number, String address) {
        this._id = _id;
        this.fName = fName;
        this.lName = lName;
        this.email = email;
        this.userName = userName;
        this.password = password;
        this.birthDate = birthDate;
        this.phone_number = phone_number;
        this.address = address;
    }

    public User(String fName, String lName, String email, String userName,
                String password, Date birthDate, String phone_number, String address) {
        this.fName = fName;
        this.lName = lName;
        this.email = email;
        this.userName = userName;
        this.password = password;
        this.birthDate = birthDate;
        this.phone_number = phone_number;
        this.address = address;
    }


    public long get_id() {
        return _id;
    }

    public void set_id(long _id) {
        this._id = _id;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public ArrayList<Message> getMessages() {
        return messages;
    }

    public void setMessages(ArrayList<Message> messages) {
        this.messages = messages;
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
        if (!(o instanceof User)) return false;
        User user = (User) o;
        return get_id() == user.get_id() &&
                Objects.equals(getfName(), user.getfName()) &&
                Objects.equals(getlName(), user.getlName()) &&
                Objects.equals(getEmail(), user.getEmail()) &&
                Objects.equals(getUserName(), user.getUserName()) &&
                Objects.equals(getPassword(), user.getPassword()) &&
                Objects.equals(getBirthDate(), user.getBirthDate()) &&
                Objects.equals(getPhone_number(), user.getPhone_number()) &&
                Objects.equals(getAddress(), user.getAddress()) &&
                Objects.equals(getMessages(), user.getMessages()) &&
                Objects.equals(getLikes(), user.getLikes());
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    public int hashCode() {

        return Objects.hash(get_id(), getfName(), getlName(), getEmail(), getUserName(), getPassword(), getBirthDate(), getPhone_number(), getAddress(), getMessages(), getLikes());
    }

    @Override
    public String toString() {
        return "User{" +
                "_id=" + _id +
                ", fName='" + fName + '\'' +
                ", lName='" + lName + '\'' +
                ", email='" + email + '\'' +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", birthDate=" + birthDate +
                ", phone_number='" + phone_number + '\'' +
                ", address='" + address + '\'' +
                ", messages=" + messages +
                ", likes=" + likes +
                '}';
    }
}
