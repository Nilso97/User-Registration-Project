package br.com.springboot.springboot.controller;

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

import br.com.springboot.springboot.model.User;
import br.com.springboot.springboot.repository.UserRepository;

@RestController
@RequestMapping("/users")
public class UserController {

    private List<User> users = new ArrayList<>();

    // Injection
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
    public User user(@PathVariable("id") Long id) {
        System.out.println("O id buscado é: " + id);

        Optional<User> findUser = this.userRepository.findById(id); /*users.stream()
                .filter(user -> user.getId() == id)
                .findFirst();*/

        if (findUser.isPresent()) {
            return findUser.get();
        }
        return null;
    }

    @GetMapping("/list-more-than/{id}")
    public List<User> listMoreThan(@PathVariable("id") Long id) {
        return this.userRepository.findByIdGreaterThan(id);
    }

    @GetMapping("/find-by-name/{name}")
    public List<User> findByName(@PathVariable("name") String name) {
        return this.userRepository.findByNameIgnoreCase(name);
    }
}
