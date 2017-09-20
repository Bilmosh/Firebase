package com.bill.firebase;

/**
 * Created by bill on 9/14/17.
 */


//constructor
public class User {
    String names;
    int age;

    public User() {

    }
    //getter
    public User(String names, int age) {
        this.names = names;
        this.age = age;
    }

    public String getNames() {
        return names;
    }

    public int getAge() {
        return age;
    }
}
