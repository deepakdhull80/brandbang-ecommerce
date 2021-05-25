package com.store.webstore.model;


import javax.persistence.*;

@Entity
@Table(name = "user",uniqueConstraints = @UniqueConstraint(columnNames = {"user_name"}))
public class User {
    @Id
    @Column(name = "userid")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    int userid;
    @Column(name="user_name")
    String userName;
    @Column(name="phone_no")
    String phoneNo;


    public User() {
    }

    public User(int userid, String userName, String phoneNo) {
        this.userid = userid;
        this.userName = userName;
        this.phoneNo = phoneNo;
    }

    public int getUserid() {
        return userid;
    }

    public String getUserName() {
        return userName;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

}
