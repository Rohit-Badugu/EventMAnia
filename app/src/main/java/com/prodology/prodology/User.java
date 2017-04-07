package com.prodology.prodology;

/**
 * Created by Rohit33 on 18-03-2017.
 */


public class User {

    public String Feedback;
    public float Rating;

    // Default constructor required for calls to
    // DataSnapshot.getValue(User.class)
    public User() {
    }

    public User(String name, float email) {
        Feedback=name  ;
        Rating=email ;
    }
}
