package com.example.taqtile.onboard;

/**
 * Created by taqtile on 1/6/16.
 */
public class User2 {
    private String first_name;
    private String last_name;
    private String avatar;
    private Boolean access;
    private Integer counter;
    private Integer id;

    public User2(Integer id, String first_name, String last_name, String avatar){
        this.avatar = avatar;
        this.id = id;
        this.last_name =  last_name.substring(0,1).toUpperCase() + last_name.substring(1);
        this.first_name = first_name.substring(0,1).toUpperCase() + first_name.substring(1);
        this.access = false;
        this.counter = 0;
    }

    public Integer getId() {
        return id;
    }

    public String getFirstName() {
        return first_name;
    }

    public String getLastName() {
        return last_name;
    }

    public String getAvatar() {
        return avatar;
    }

    public void addCounter() {
        this.counter=this.counter + 1;
    }

    public Integer getCounter() {
        return this.counter;
    }

    public String toString(){
        return this.first_name.toString() + this.last_name.toString();
    }

    public Boolean getAccess() {return this.access;}

    public void setAccess(Boolean access) {this.access = access;}
}
