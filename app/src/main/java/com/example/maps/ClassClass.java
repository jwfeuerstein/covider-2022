package com.example.maps;

import java.util.List;
import java.util.ArrayList;

public class ClassClass {
    User instructor;
    String className;
    List<User> students;

    public ClassClass(User instruct, String name, List<User> temp){
        students = temp;
        instructor = instruct;
        className = name;

    }
}
