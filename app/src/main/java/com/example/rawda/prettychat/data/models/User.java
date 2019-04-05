package com.example.rawda.prettychat.data.models;

import android.annotation.TargetApi;
import android.os.Build;
import android.support.annotation.RequiresApi;

import java.text.DateFormat;
import java.text.Format;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

public class User {
    protected static long _id = 0;
    protected String fName;
    protected String lName;
    protected String email;
    protected String userName;
    protected String password;
    protected Date birthDate;
    protected String phone_number;
    protected String address;
    protected byte[] photo;
    protected List<Message> messages;
    protected List<User> followings;
    protected List<Post> posts;



    public User(long _id, String fName, String lName, String email,
                String userName, String password, Date birthDate,
                String phone_number, String address, byte[] photo) {
        this._id = _id;
        this.fName = fName;
        this.lName = lName;
        this.email = email;
        this.userName = userName;
        this.password = password;
        this.birthDate = birthDate;
        this.phone_number = phone_number;
        this.address = address;
        this.photo = photo;
        initialize_Lists();
    }

    public User(String fName, String lName, String email, Date birthDate,
                String phone_number, String address, byte[] photo) {
        _id++;
        this.fName = fName;
        this.lName = lName;
        this.email = email;
        this.userName = userName;
        this.password = password;
        this.birthDate = birthDate;
        this.phone_number = phone_number;
        this.address = address;
        this.photo = photo;
        initialize_Lists();
    }

    public User() {
        initialize_Lists();
    }
    private void initialize_Lists(){
        messages = new ArrayList<>();
        followings = new ArrayList<>();
        posts = new ArrayList<>();

    }
    public void addMessage(Message message){
        messages.add(message);
    }

    public void addFollowing(User user){
        followings.add(user);
    }
    public void addPost(Post post){
        posts.add(post);
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

    public byte[] getPhoto() {
        return photo;
    }

    public void setPhoto(byte[] photo) {
        this.photo = photo;
    }

    public List<Message> getMessages() {
        return messages;
    }

    public void setMessages(ArrayList<Message> messages) {
        this.messages = messages;
    }

    public List<User> getFollowings() {
        return followings;
    }

    public void setFollowings(List<User> followings) {
        this.followings = followings;
    }
    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(ArrayList<Post> posts) {
        this.posts = posts;
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        User user = (User) o;
        return get_id() == user.get_id() &&
                getPhoto() == user.getPhoto() &&
                Objects.equals(getfName(), user.getfName()) &&
                Objects.equals(getlName(), user.getlName()) &&
                Objects.equals(getEmail(), user.getEmail()) &&
                Objects.equals(getUserName(), user.getUserName()) &&
                Objects.equals(getPassword(), user.getPassword()) &&
                Objects.equals(getBirthDate(), user.getBirthDate()) &&
                Objects.equals(getPhone_number(), user.getPhone_number()) &&
                Objects.equals(getAddress(), user.getAddress()) &&
                Objects.equals(getMessages(), user.getMessages()) &&
                Objects.equals(getFollowings(), user.getFollowings());
    }

    @TargetApi(Build.VERSION_CODES.KITKAT)
    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    public int hashCode() {

        return Objects.hash(get_id(), getfName(), getlName(), getEmail(), getUserName(), getPassword(), getBirthDate(), getPhone_number(),
                getAddress(), getPhoto(), getMessages(), getFollowings());
    }
    private String messageStr(){
        String str_messages = "";
        for (int i = 0; i < messages.size(); i++) str_messages += messages.get(i) + " ";
        return str_messages;
    }




    private String followingsStr(){
        String str_followings = "";
        for (int i = 0; i < followings.size(); i++) str_followings += followings.get(i) + " ";
        return str_followings;
    }
    private String postsStr(){
        String str_posts = "";
        for (int i = 0; i < posts.size(); i++) str_posts += posts.get(i) + "";
        return str_posts;
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
                ", photo=" + photo +
                ", messages=" + messageStr() +
                ", followings=" + followingsStr() +
                ", posts=" + postsStr() +
                '}';
    }
}