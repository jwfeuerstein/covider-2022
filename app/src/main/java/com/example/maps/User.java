package com.example.maps;

import java.io.Serializable;

public class User implements Serializable {
    String email;
    String firstName;
    String lastName;
    String type;
    String password;

    public User(String e, String f, String l, String t, String p){
        email = e;
        firstName = f;
        lastName = l;
        type = t;
        password = p;
    }

    public String getEmail(){
        return email;
    }

    public String getFirstName(){
        return firstName;
    }

    public String getLastName(){
        return lastName;
    }

    public String getType(){
        return type;
    }

    public String getPassword(){
        return password;
    }

    public void setEmail(String temp){
        email = temp;
    }

    public void setFirstName(String name){
        firstName = name;
    }

    public void setLastName(String name){
        lastName = name;
    }

    public void setType(String types){
        type = types;
    }

    public void setPassword(String temppass){
        password = temppass;
    }



}