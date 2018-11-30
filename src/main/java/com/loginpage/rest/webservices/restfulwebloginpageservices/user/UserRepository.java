package com.loginpage.rest.webservices.restfulwebloginpageservices.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserBean, Integer> { //<Entity that need to manage , primary key>
}
