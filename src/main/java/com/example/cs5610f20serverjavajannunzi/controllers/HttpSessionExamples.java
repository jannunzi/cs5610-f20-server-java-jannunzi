package com.example.cs5610f20serverjavajannunzi.controllers;

import com.example.cs5610f20serverjavajannunzi.models.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@RestController
public class HttpSessionExamples {
    @GetMapping("/api/session/set/{attr}/{value}")
    public String setSessionAttribute(
            @PathVariable("attr") String attr,
            @PathVariable("value") String value,
            HttpSession session) {
        session.setAttribute(attr, value);
        return value;
    }

    @GetMapping("/api/session/get/{attr}")
    public String getSessionAttribute(
            @PathVariable("attr") String attr,
            HttpSession session) {
        return (String)session.getAttribute(attr);
    }

    @GetMapping("/api/session/kill")
    public void invalidateSession(
            HttpSession session) {
        session.invalidate();
    }

    // TODO: use a database instead of this list
    List<User> users = new ArrayList<User>();
    // TODO: user POST instead of GET
    @GetMapping("/api/register/{username}/{password}")
    public User register(
            @PathVariable("username") String username,
            @PathVariable("password") String password,
            HttpSession session) {
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        users.add(user);
        session.setAttribute("profile", user);
        return user;
    }
    @GetMapping("/api/login/{username}/{password}")
    public User login(
            @PathVariable("username") String username,
            @PathVariable("password") String password,
            HttpSession session) {
        for (User user: users) {
            if(user.getUsername().equals(username) &&
                user.getPassword().equals(password)) {
                session.setAttribute("profile", user);
                return user;
            }
        }
        return null;
    }
    @GetMapping("/api/profile")
    public User profile(HttpSession session) {
        return (User)session.getAttribute("profile");
    }
    @GetMapping("/api/logout")
    public void logout(HttpSession session) {
        session.invalidate();
    }
}
