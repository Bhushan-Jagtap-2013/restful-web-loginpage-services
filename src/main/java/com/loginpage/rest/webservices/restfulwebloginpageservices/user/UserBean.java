package com.loginpage.rest.webservices.restfulwebloginpageservices.user;

import java.util.Date;

public class UserBean {
    private String name;
    private Date dob;
    private Integer id;

    public UserBean(String name, Date dob, Integer id) {
        this.name = name;
        this.dob = dob;
        this.id = id;
    }

    @Override
    public String toString() {
        return "UserBean{" +
                "name='" + name + '\'' +
                ", dob=" + dob +
                ", id=" + id +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public Integer getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
