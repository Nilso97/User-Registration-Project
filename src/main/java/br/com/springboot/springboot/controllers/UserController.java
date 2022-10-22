package br.com.springboot.springboot.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.springboot.springboot.models.User;
import br.com.springboot.springboot.repository.UserRepository;

@RestController
@RequestMapping(path = "/users")
public class UserController {

    private List<User> users = new ArrayList<>();

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/add-user")
    public User addUser(@RequestBody User user) {
        return this.userRepository.save(user);
    }

    @GetMapping("/list")
    public List<User> listUsers() {
        return this.userRepository.findAll();
    }

    @GetMapping("/list/{id}")
    public User findUserById(@PathVariable("id") Long id) {
        System.out.printf("Buscando o id " + id);

        Optional<User> findUser = this.userRepository.findById(id);

        if (findUser.isPresent()) {
            return findUser.get();
        }

        return null;
    }

    @GetMapping("/list-more-than/{id}")
    public List<User> listUsersMoreThan(@PathVariable("id") Long id) {
        return this.userRepository.findAllMoreThan(id);
    }

    @GetMapping("/find-by-name/{name}")
    public List<User> findUserByName(@PathVariable("name") String name) {
        return this.userRepository.findByNameIgnoreCase(name);
    }
}
