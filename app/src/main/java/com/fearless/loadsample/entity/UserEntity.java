package com.fearless.loadsample.entity;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by Fearless on 16/10/14.
 */

@Entity
public class UserEntity  {
    @Id
    private Long id;
    private String userName;
    @Generated(hash = 1975882781)
    public UserEntity(Long id, String userName) {
        this.id = id;
        this.userName = userName;
    }
    @Generated(hash = 1433178141)
    public UserEntity() {
    }
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getUserName() {
        return this.userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }

}
