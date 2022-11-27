package ru.yandex.practicum.catsgram.controller;

import org.springframework.web.bind.annotation.*;
import ru.yandex.practicum.catsgram.exception.InvalidEmailException;
import ru.yandex.practicum.catsgram.exception.UserAlreadyExistException;
import ru.yandex.practicum.catsgram.model.User;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    List<User> users = new ArrayList<>();

    @GetMapping
    public List<User> getUsers() {
        return users;
    }

    @PostMapping
    public User addUser(@RequestBody User user) {
        if (users.contains(user)) {
            throw new UserAlreadyExistException();
        }
        validateUser(user);
        users.add(user);
        return user;
    }

    @PutMapping
    public User updateUser(@RequestBody User user) {
        validateUser(user);
        users.remove(user);
        users.add(user);
        return user;
    }

    private void validateUser(User user) {
        if (user == null || user.getEmail() == null || user.getEmail().isBlank()) {
            throw new InvalidEmailException();
        }
    }
}
