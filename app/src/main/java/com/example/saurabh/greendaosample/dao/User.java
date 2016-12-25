package com.example.saurabh.greendaosample.dao;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Keep;
import org.greenrobot.greendao.annotation.Transient;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by saurabh on 25/12/16.
 */
@Entity
public class User {
    @Id(autoincrement = true)
    private Long id;
    private String name;
    @Transient
    private boolean hasDp;
    @Keep
    public User(String name) {
        this.name = name;
    }
    @Generated(hash = 586692638)
    public User() {
    }
    @Generated(hash = 873297011)
    public User(Long id, String name) {
        this.id = id;
        this.name = name;
    }
    public Long getId() {
        return this.id;
    }
    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
    public void setId(Long id) {
        this.id = id;
    }
}
