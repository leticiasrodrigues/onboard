package com.example.taqtile.onboard;

/**
 * Created by taqtile on 1/6/16.
 */
public class User2 {
    private static String first_name;
    private static String last_name;
    private String avatar;
    private Integer count;
    private Integer id;

    public User2(Integer id, String first_name, String last_name, String avatar){
        this.avatar = avatar;
        this.id = id;
        this.last_name = last_name;
        this.first_name = first_name;
        this.count = 0;
    }

    public Integer getId() {
        return id;
    }

    public static String getFirst_name() {
        return first_name;
    }

    public static String getLast_name() {
        return last_name;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public String toString(){
        return this.first_name.toString() + this.last_name.toString();
    }
}
