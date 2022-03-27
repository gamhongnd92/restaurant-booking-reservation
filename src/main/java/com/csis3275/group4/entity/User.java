package com.csis3275.group4.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "User")
public class User {
    @Id
    private String id;
    private String UserName;
    private String Password;

    public User() {}

    public User(String UserName, String Password){
        this.UserName = UserName;
        this.Password = Password;
    }

    public String getId() {
        return id;
    }

    public String getUserName() {
        return UserName;
    }

    public String getPassword() {
        return Password;
    }

    public void setId(String id) { this.id = id; }

    public void setUserName(String userName) { UserName = userName; }

    public void setPassword(String password) { Password = password; }

}
