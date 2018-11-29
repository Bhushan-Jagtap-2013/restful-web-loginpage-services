package com.loginpage.rest.webservices.restfulwebloginpageservices.user;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

@Component
public class UserDAOService {
    private static List<UserBean> users = new ArrayList<>();
    private static int count = 3;
    static {
        users.add(new UserBean("Bhushan", new Date(), 1));
        users.add(new UserBean("Mike", new Date(), 2));
        users.add(new UserBean("Sam", new Date(), 3));
    }

    public List<UserBean> getAll() {
        return users;
    }

    public UserBean insert(UserBean user) {
        if (user.getId() == null) {
            user.setId(++count);
        }
        users.add(user);
        return user;
    }

    public UserBean find(int id) {
        for (UserBean user: users) {
            if (user.getId() == id) {
                return user;
            }
        }
        return null;
    }

    public UserBean remove(int id) {
        Iterator<UserBean> it = users.iterator();
        while(it.hasNext()) {
            UserBean u = it.next();
            if (u.getId() == id) {
                it.remove();
                return u;
            }
        }
        return null;
    }
}
