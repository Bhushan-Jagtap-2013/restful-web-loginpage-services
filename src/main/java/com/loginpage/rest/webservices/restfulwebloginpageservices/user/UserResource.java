package com.loginpage.rest.webservices.restfulwebloginpageservices.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
public class UserResource {
    @Autowired
    private UserDAOService service;

    @Autowired
    private UserRepository userRepository;

    @GetMapping(path = "/users")
    public List<UserBean> getAllUsers() {
        return userRepository.findAll();
    }

    @GetMapping(path = "/users/{id}")
    public UserBean getUser(@PathVariable int id) {
        Optional<UserBean> ret = userRepository.findById(id);
        if (!ret.isPresent()) {
            throw new UserNotFoundException("user id - " + id);
        }
        return ret.get();
    }

    /*
    Validate input to method using Valid annotation
     */

    @PostMapping(path = "/users")
    public ResponseEntity<Object> addUser(@Valid @RequestBody UserBean user) {
        UserBean addedUser = userRepository.save(user);

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

    @DeleteMapping(path = "/users/{id}")
    public void addUser(@PathVariable int id) {
        userRepository.deleteById(id);
    }
}
