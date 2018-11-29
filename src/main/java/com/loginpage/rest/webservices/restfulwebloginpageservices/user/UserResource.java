package com.loginpage.rest.webservices.restfulwebloginpageservices.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
public class UserResource {
    @Autowired
    private UserDAOService service;

    @GetMapping(path = "/users")
    public List<UserBean> getAllUsers(){
        return service.getAll();
    }

    @GetMapping(path = "/users/{id}")
    public UserBean getUser(@PathVariable  int id) {
        return  service.find(id);
    }

    @PostMapping(path = "/users")
    public ResponseEntity<Object> addUser(@RequestBody UserBean user) {
        UserBean addedUser = service.insert(user);

        /*
         It is HTTP best practice to return status as created : 201
         whenever new resource is added.

         Also we need to return location(URI) of newly created entity.
         This return value will be added in Header->location field of response.
          */

        URI uri;
        uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(addedUser.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }
}
