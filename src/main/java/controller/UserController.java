package controller;

import dto.UserDTO;
import service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/appActivitats/users")
public class UserController {

    @Autowired
    private UserServiceImpl userServiceImpl;

    @PostMapping("/user")
    public UserDTO registerUser(@RequestBody UserDTO userDTO) {
        return userServiceImpl.registerUser(userDTO);
    }

    @PutMapping("/{id}")
    public UserDTO updateUser(@PathVariable String id, @RequestBody UserDTO userDTO) {
        return userServiceImpl.updateUser(id, userDTO);
    }

    @GetMapping("/{id}")
    public UserDTO getUser(@PathVariable String id) {
        return userServiceImpl.getUser(id);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable String id) {
        userServiceImpl.deleteUser(id);
    }
}