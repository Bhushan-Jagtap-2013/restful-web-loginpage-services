package com.loginpage.rest.webservices.restfulwebloginpageservices.user;

import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.util.Date;

public class UserBean {

    /*
    Validate that size has to be greater than 8 character.
     */

    @Size(min = 8, message = "Name should have at-least 8 characters")
    private String name;

    /*
    Validate that date of birth has to be in past.
     */

    @Past(message = "Date of birth should be less than current date")
    private Date dob;
    private Integer id;

    /*
    We need default constructor as it will give
    use error using post method call
     */
    protected UserBean() {
    }

    public UserBean(String name, Date dob, Integer id) {
        super();
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
