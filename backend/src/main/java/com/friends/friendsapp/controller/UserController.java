package com.friends.friendsapp.controller;

import com.friends.friendsapp.model.AuthenticationRequest;
import com.friends.friendsapp.model.AuthenticationResponse;
import com.friends.friendsapp.model.User;
import com.friends.friendsapp.security.JwtUtil;
import com.friends.friendsapp.service.MyUserDetailsService;
import com.friends.friendsapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("api/v1/user")
@RestController
public class UserController {

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private MyUserDetailsService userDetailsService;
    @Autowired
    private JwtUtil jwtTokenUtil;
    private final UserService userService;


    //Create user
    @PostMapping(path = "/create")
    public void addUser(@NonNull @RequestBody User user){
        userService.addUser(user);
    }


    //Get all users
    @GetMapping
    public List<User> getAllUsers(){
        return  userService.getAllUsers();
    }


    //Get user by id
    @GetMapping(path = "{id}")
    public User getUserById(@PathVariable("id") int id){
        return userService.getUserById(id)
                .orElse(null);
    }


    //Delete user by id
    @DeleteMapping(path = "{id}")
    public void deleteUserById(@PathVariable("id") int id){
        userService.deleteUser(id);
    }


    //Update user by id
    @PutMapping(path = "{id}")
    public void updateUser(@PathVariable("id") int id,@NonNull @RequestBody User userToUpdate){
        userService.updateUser(id, userToUpdate);
    }


    //Login user and get JWT token
    @RequestMapping(value = "/authenticate", method = RequestMethod.POST)
    public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest) throws Exception{

        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(), authenticationRequest.getPassword())
            );
        }
        catch (BadCredentialsException e){
            throw new Exception("Incorrect username or password", e);
        }

        final UserDetails userDetails = userDetailsService
                .loadUserByUsername(authenticationRequest.getUsername());
        final String jwt = jwtTokenUtil.generateToken(userDetails);

        return  ResponseEntity.ok(new AuthenticationResponse(jwt));
    }
}
